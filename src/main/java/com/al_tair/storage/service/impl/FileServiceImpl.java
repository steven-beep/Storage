package com.al_tair.storage.service.impl;

import com.al_tair.storage.mapper.FileMapper;
import com.al_tair.storage.model.File;
import com.al_tair.storage.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Al_tair
 * @date 2022/7/20-13:43
 */

@Slf4j
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
}
