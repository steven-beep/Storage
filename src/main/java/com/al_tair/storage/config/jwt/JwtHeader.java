package com.al_tair.storage.config.jwt;

import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/18-15:06
 */
@Data
public class JwtHeader {
    private String alg;
    private String typ;
}
