package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/21-14:54
 * 用来接受重命名接口传参
 */
@Data
@Schema(name = "重命名文件DTO",required = true)
public class RenameFileDTO {
    private Long userFileId;

    @Schema(description = "文件名")
    private String fileName;

}
