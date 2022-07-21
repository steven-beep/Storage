package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/21-14:46
 */
@Data
@Schema(name = "批量移动文件DTO",required = true)
public class BatchMoveFileDTO {
    @Schema(description="文件集合")
    private String files;
    @Schema(description="文件路径")
    private String filePath;
}