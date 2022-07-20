package com.al_tair.storage.service.impl;

import com.al_tair.storage.constant.FileConstant;
import com.al_tair.storage.mapper.UserFileMapper;
import com.al_tair.storage.model.UserFile;
import com.al_tair.storage.service.UserFileService;
import com.al_tair.storage.vo.UserFileListVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Al_tair
 * @date 2022/7/20-13:42
 */

@Slf4j
@Service
public class UserFileServiceImpl extends ServiceImpl<UserFileMapper, UserFile> implements UserFileService {

    @Resource
    UserFileMapper userfileMapper;

    /**
     * 根据文件路径获取引用文件的信息
     * @param filePath
     * @param userId 用户 Id
     * @param currentPage 当前页号
     * @param pageCount 页数
     * @return
     */
    @Override
    public List<UserFileListVO> getUserFileByFilePath(String filePath, Long userId, Long currentPage, Long pageCount) {
        Long beginCount = (currentPage - 1) * pageCount;
        UserFile userfile = new UserFile();
        userfile.setUserId(userId);
        userfile.setFilePath(filePath);
        List<UserFileListVO> fileList = userfileMapper.userfileList(userfile, beginCount, pageCount);
        return fileList;
    }

    /**
     * 根据文件类型进行查找（对应文件数值在常量包中）
     * @param fileType 文件类型
     * @param currentPage 当前页号
     * @param pageCount 页数
     * @param userId 用户Id
     * @return
     */
    @Override
    public Map<String, Object> getUserFileByType(int fileType, Long currentPage, Long pageCount, Long userId) {
        Long beginCount = (currentPage - 1) * pageCount;
        List<UserFileListVO> fileList;
        Long total;
        if (fileType == FileConstant.OTHER_TYPE) {

            List<String> arrList = new ArrayList<>();
            arrList.addAll(Arrays.asList(FileConstant.DOC_FILE));
            arrList.addAll(Arrays.asList(FileConstant.IMG_FILE));
            arrList.addAll(Arrays.asList(FileConstant.VIDEO_FILE));
            arrList.addAll(Arrays.asList(FileConstant.MUSIC_FILE));

            fileList = userfileMapper.selectFileNotInExtendNames(arrList,beginCount, pageCount, userId);
            total = userfileMapper.selectCountNotInExtendNames(arrList,beginCount, pageCount, userId);
        } else {
            List<String> fileExtends = null;
            if (fileType == FileConstant.IMAGE_TYPE) {
                fileExtends = Arrays.asList(FileConstant.IMG_FILE);
            } else if (fileType == FileConstant.DOC_TYPE) {
                fileExtends = Arrays.asList(FileConstant.DOC_FILE);
            } else if (fileType == FileConstant.VIDEO_TYPE) {
                fileExtends = Arrays.asList(FileConstant.VIDEO_FILE);
            } else if (fileType == FileConstant.MUSIC_TYPE) {
                fileExtends = Arrays.asList(FileConstant.MUSIC_FILE);
            }
            fileList = userfileMapper.selectFileByExtendName(fileExtends, beginCount, pageCount,userId);
            total = userfileMapper.selectCountByExtendName(fileExtends, beginCount, pageCount,userId);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("list",fileList);
        map.put("total", total);
        return map;
    }
}
