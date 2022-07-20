package com.al_tair.storage.service;

import com.al_tair.storage.model.UserFile;
import com.al_tair.storage.vo.UserFileListVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @author Al_tair
 * @date 2022/7/20-13:39
 */
public interface UserFileService extends IService<UserFile> {
    /**
     * 根据文件路径获取逻辑文件的信息
     * @param filePath
     * @param userId 用户Id
     * @param currentPage 当前页号
     * @param pageCount 页数
     * @return
     */
    List<UserFileListVO> getUserFileByFilePath(String filePath, Long userId, Long currentPage, Long pageCount);

    /**
     * 根据文件类型进行查找（对应文件数值在常量包中）
     * @param fileType 文件类型
     * @param currentPage 当前页号
     * @param pageCount 页数
     * @param userId 用户Id
     * @return
     */
    Map<String, Object> getUserFileByType(int fileType, Long currentPage, Long pageCount, Long userId);
}
