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

    /**
     * 删除逻辑文件
     * @param userFileId
     * @param sessionUserId
     */
    void deleteUserFile(Long userFileId, Long sessionUserId);

    /**
     * 批量删除逻辑文件
     * @param filePath
     * @param userId
     * @return
     */
    List<UserFile> selectFileTreeListLikeFilePath(String filePath, long userId);

    /**
     * 通过文件 ID 查询文件路径
     * @param userId
     * @return
     */
    List<UserFile> selectFilePathTreeByUserId(Long userId);

    /**
     * 更新文件路径
     * @param oldfilePath
     * @param newfilePath
     * @param fileName
     * @param extendName
     * @param userId
     */
    void updateFilepathByFilepath(String oldfilePath, String newfilePath, String fileName, String extendName, Long userId);

    /**
     *
     * @param fileName
     * @param filePath
     * @param userId
     * @return
     */
    List<UserFile> selectUserFileByNameAndPath(String fileName, String filePath, Long userId);

    /**
     *
     * @param filePath
     * @param oldFilePath
     * @param userId
     */
    void replaceUserFilePath(String filePath, String oldFilePath, Long userId);
}
