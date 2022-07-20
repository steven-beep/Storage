package com.al_tair.storage.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/18-16:00
 */
@Data
@Schema(description="注册DTO")
public class RegisterDTO {
    @Schema(description="用户名")
    private String username;
    @Schema(description="手机号")
    private String telephone;
    @Schema(description="密码")
    private String password;
}