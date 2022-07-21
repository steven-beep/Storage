package com.al_tair.storage.mapper;

import com.al_tair.storage.model.RecoveryFile;
import com.al_tair.storage.vo.RecoveryFileListVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Al_tair
 * @date 2022/7/21-14:33
 */
public interface RecoveryFileMapper extends BaseMapper<RecoveryFile> {
    List<RecoveryFileListVO> selectRecoveryFileList();
}