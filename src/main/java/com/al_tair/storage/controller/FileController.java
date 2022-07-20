package com.al_tair.storage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.al_tair.storage.common.RestResult;
import com.al_tair.storage.dto.CreateFileDTO;
import com.al_tair.storage.dto.UserFileListDTO;
import com.al_tair.storage.model.User;
import com.al_tair.storage.model.UserFile;
import com.al_tair.storage.service.FileService;
import com.al_tair.storage.service.UserFileService;
import com.al_tair.storage.service.UserService;
import com.al_tair.storage.util.DateUtil;
import com.al_tair.storage.vo.UserFileListVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Al_tair
 * @date 2022/7/20-14:01
 */

@Slf4j
@RestController
@RequestMapping("/file")
@Tag(name = "file", description = "该接口为文件接口，主要用来做一些文件的基本操作，如创建目录，删除，移动，复制等")
public class FileController {

    @Resource
    FileService fileService;

    @Resource
    UserService userService;

    @Resource
    UserFileService userfileService;


    @PostMapping(value = "/createfile")
    @ResponseBody
    @Operation(summary = "创建文件", description = "目录(文件夹)的创建", tags = {"file"})
    public RestResult<String> createFile(@RequestBody CreateFileDTO createFileDto, @RequestHeader("token") String token) {
        User sessionUser = userService.getUserByToken(token);
        if (sessionUser == null) {
            RestResult.fail().message("token认证失败");
        }
        LambdaQueryWrapper<UserFile> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserFile::getFileName, "").eq(UserFile::getFilePath, "").eq(UserFile::getUserId, 0);
        List<UserFile> userfiles = userfileService.list(lambdaQueryWrapper);
        if (!userfiles.isEmpty()) {
            RestResult.fail().message("同目录下文件名重复");
        }

        UserFile userFile = new UserFile();
        userFile.setUserId(sessionUser.getUserId());
        userFile.setFileName(createFileDto.getFileName());
        userFile.setFilePath(createFileDto.getFilePath());
        userFile.setIsDir(1);
        userFile.setUploadTime(DateUtil.getCurrentTime());

        userfileService.save(userFile);
        return RestResult.success();
    }

    @GetMapping(value = "/getfilelist")
    @ResponseBody
    @Operation(summary = "获取文件列表", description = "用来做前台文件列表展示", tags = { "file" })
    public RestResult<UserFileListVO> getUserfileList(UserFileListDTO userfileListDto,
                                                      @RequestHeader("token") String token) {
        User sessionUser = userService.getUserByToken(token);
        if (sessionUser == null) {
            return RestResult.fail().message("token验证失败");
        }

        List<UserFileListVO> fileList = userfileService.getUserFileByFilePath(userfileListDto.getFilePath(),
                sessionUser.getUserId(), userfileListDto.getCurrentPage(), userfileListDto.getPageCount());

        LambdaQueryWrapper<UserFile> userFileLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userFileLambdaQueryWrapper.eq(UserFile::getUserId, sessionUser.getUserId()).eq(UserFile::getFilePath, userfileListDto.getFilePath());
        long total = userfileService.count(userFileLambdaQueryWrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("list", fileList);

        return RestResult.success().data(map);
    }

    @Operation(summary = "通过文件类型选择文件", description = "该接口可以实现文件格式分类查看", tags = {"file"})
    @GetMapping(value = "/selectfilebyfiletype")
    @ResponseBody
    public RestResult<List<Map<String, Object>>> selectFileByFileType(int fileType, Long currentPage, Long pageCount, @RequestHeader("token") String token) {

        User sessionUser = userService.getUserByToken(token);
        if (sessionUser == null) {
            return RestResult.fail().message("token验证失败");
        }
        long userId = sessionUser.getUserId();

        Map<String, Object> map = userfileService.getUserFileByType(fileType, currentPage, pageCount, userId);
        return RestResult.success().data(map);
    }
}
