package com.al_tair.storage.util;

import org.springframework.core.env.Environment;
/**
 * @author Al_tair
 * @date 2022/7/21-11:36
 */
public class PropertiesUtil {
    private static Environment env = null;

    public static void setEnvironment(Environment env) {
        PropertiesUtil.env = env;
    }

    public static String getProperty(String key) {
        return PropertiesUtil.env.getProperty(key);
    }
}
