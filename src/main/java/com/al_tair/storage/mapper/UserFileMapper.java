package com.al_tair.storage.mapper;

import com.al_tair.storage.model.UserFile;
import com.al_tair.storage.vo.UserFileListVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Al_tair
 * @date 2022/7/18-13:23
 */
public interface UserFileMapper extends BaseMapper<UserFile> {
    /**
     * 文件列表查询
     * @param userfile 逻辑文件引用信息
     * @param beginCount
     * @param pageCount
     * @return
     */
    List<UserFileListVO> userfileList(@Param("userfile") UserFile userfile,@Param("beginCount") Long beginCount,@Param("pageCount") Long pageCount);

    /**
     * 通过文件扩展名来查询文件列表
     * @param fileNameList
     * @param beginCount
     * @param pageCount
     * @param userId
     * @return
     */
    List<UserFileListVO> selectFileByExtendName(@Param("fileNameList") List<String> fileNameList,@Param("beginCount") Long beginCount,@Param("pageCount") Long pageCount,@Param("userId") long userId);

    /**
     * 通过文件扩展名来查看文件数量
     * @param fileNameList
     * @param beginCount
     * @param pageCount
     * @param userId
     * @return
     */
    Long selectCountByExtendName(@Param("fileNameList") List<String> fileNameList,@Param("beginCount") Long beginCount,@Param("pageCount") Long pageCount,@Param("userId") long userId);

    /**
     * 通过文件扩展名查询不是该扩展名的文件列表
     * @param fileNameList
     * @param beginCount
     * @param pageCount
     * @param userId
     * @return
     */
    List<UserFileListVO> selectFileNotInExtendNames(@Param("fileNameList") List<String> fileNameList,@Param("beginCount") Long beginCount,@Param("pageCount") Long pageCount,@Param("userId") long userId);

    /**
     * 通过文件扩展名查询不是该扩展名的文件数量
     * @param fileNameList
     * @param beginCount
     * @param pageCount
     * @param userId
     * @return
     */
    Long selectCountNotInExtendNames(@Param("fileNameList") List<String> fileNameList,@Param("beginCount") Long beginCount,@Param("pageCount") Long pageCount,@Param("userId") long userId);

    /**
     * 更新文件路径
     * @param oldfilePath
     * @param newfilePath
     * @param userId
     */
    void updateFilepathByFilepath(@Param("oldfilePath") String oldfilePath,@Param("newfilePath") String newfilePath,@Param("userId") Long userId);

    /**
     *
     * @param filePath
     * @param oldFilePath
     * @param userId
     */
    void replaceFilePath(@Param("filePath") String filePath, @Param("oldFilePath") String oldFilePath, @Param("userId") Long userId);

    /**
     *
     * @param userId
     * @return
     */
    Long selectStorageSizeByUserId(Long userId);
}
