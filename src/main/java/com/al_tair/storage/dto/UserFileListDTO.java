package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/20-14:19
 */
@Data
@Schema(name = "文件列表DTO",required = true)
public class UserFileListDTO {
    @Schema(description = "文件路径")
    private String filePath;
    @Schema(description = "当前页码")
    private Long currentPage;
    @Schema(description = "一页显示数量")
    private Long pageCount;
}