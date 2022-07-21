package com.al_tair.storage.config;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.al_tair.storage.util.PropertiesUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Al_tair
 * @date 2022/7/21-11:34
 * 用来读取环境变量
 */
@Configuration
public class PropertiesConfig {

    @Resource
    private Environment env;

    @PostConstruct
    public void setProperties() {
        PropertiesUtil.setEnvironment(env);
    }
}
