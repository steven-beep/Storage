package com.al_tair.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/18-16:11
 */
@Data
@Schema(description="注册DTO")
public class LoginVO {
    @Schema(description="用户名")
    private String username;
    @Schema(description="token")
    private String token;
}
