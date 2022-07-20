package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/20-13:56
 */
@Data
@Schema(name = "创建文件DTO",required = true)
public class CreateFileDTO {
    @Schema(description="文件名")
    private String fileName;
    @Schema(description="文件路径")
    private String filePath;
}
