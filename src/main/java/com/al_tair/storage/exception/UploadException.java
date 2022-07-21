package com.al_tair.storage.exception;

/**
 * @author Al_tair
 * @date 2022/7/21-9:37
 */
public class UploadException extends RuntimeException {
    public UploadException(Throwable cause) {
        super("上传出现了异常", cause);
    }

    public UploadException(String message) {
        super(message);
    }

    public UploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
