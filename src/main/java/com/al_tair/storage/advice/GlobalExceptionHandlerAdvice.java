package com.al_tair.storage.advice;

import com.al_tair.storage.common.RestResult;
import com.al_tair.storage.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Al_tair
 * @date 2022/7/18-14:31
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
    /**
     * 通用异常处理方法
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResult error(Exception e) {
        e.printStackTrace();
        log.error("全局异常捕获：" + e);
        return RestResult.fail();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    /**
     * 空指针处理方法
     */
    public RestResult error(NullPointerException e) {
        e.printStackTrace();
        log.error("全局异常捕获：" + e);
        return RestResult.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    /**
     * 下标越界处理方法
     */
    public RestResult error(IndexOutOfBoundsException e) {
        e.printStackTrace();
        log.error("全局异常捕获：" + e);
        return RestResult.setResult(ResultCodeEnum.INDEX_OUT_OF_BOUNDS);
    }
}
