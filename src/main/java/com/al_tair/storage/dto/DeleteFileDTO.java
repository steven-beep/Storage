package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/21-14:28
 */
@Data
@Schema(name = "删除文件DTO",required = true)
public class DeleteFileDTO {
    @Schema(description = "用户文件id")
    private Long userFileId;
    @Schema(description = "文件路径")
    @Deprecated
    private String filePath;
    @Schema(description = "文件名")
    @Deprecated
    private String fileName;
    @Schema(description = "是否是目录")
    @Deprecated
    private Integer isDir;
}
