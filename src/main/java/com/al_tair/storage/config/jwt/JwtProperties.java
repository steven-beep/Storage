package com.al_tair.storage.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Al_tair
 * @date 2022/7/18-15:10
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String secret;
    private JwtHeader header;
    private JwtPayload payload;
}
