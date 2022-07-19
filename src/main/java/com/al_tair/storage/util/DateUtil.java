package com.al_tair.storage.util;

import java.util.Date;

/**
 * @author Al_tair
 * @date 2022/7/18-15:30
 */
public class DateUtil {
    /**
     * 获取系统当前时间
     *
     * @return 系统当前时间
     */
    public static String getCurrentTime() {
        Date date = new Date();
        String stringDate = String.format("%tF %<tT", date);
        return stringDate;
    }
}