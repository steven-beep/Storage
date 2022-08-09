package com.al_tair.storage.common;

import lombok.Getter;
/**
 * @author Al_tair
 * @date 2022/7/18-14:07
 * 结果类枚举
 */
@Getter
public enum ResultCodeEnum {
    /**
     * SUCCESS: 响应成功
     * UNKNOWN_ERROR：未知错误
     * PARAM_ERROR：参数错误
     * NULL_POINT：空指针异常
     * INDEX_OUT_OF_BOUNDS：下标越界异常
     */
    SUCCESS(true,20000,"成功"),
    UNKNOWN_ERROR(false,20001,"未知错误"),
    PARAM_ERROR(false,20002,"参数错误"),
    NULL_POINT(false, 20003, "空指针异常"),
    INDEX_OUT_OF_BOUNDS(false, 20004, "下标越界异常"),
    ;

    private Boolean success;
    private Integer code;
    private String message;

    /**
     * 初始化参数
     * @param success 响应是否成功
     * @param code 响应状态码
     * @param message 响应信息
     */
    ResultCodeEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
