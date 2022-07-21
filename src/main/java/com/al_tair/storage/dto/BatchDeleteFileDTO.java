package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/21-14:28
 */
@Data
@Schema(name = "批量删除文件DTO",required = true)
public class BatchDeleteFileDTO {
    @Schema(description="文件集合")
    private String files;
}
