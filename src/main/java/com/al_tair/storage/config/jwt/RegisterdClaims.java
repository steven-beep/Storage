package com.al_tair.storage.config.jwt;

import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/18-15:09
 */
@Data
public class RegisterdClaims {
    private String iss;
    private String exp;
    private String sub;
    private String aud;
}