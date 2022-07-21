package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/21-14:10
 */
@Data
@Schema(name = "下载文件DTO",required = true)
public class DownloadFileDTO {
    private Long userFileId;
}