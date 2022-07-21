package com.al_tair.storage.exception;

/**
 * @author Al_tair
 * @date 2022/7/21-9:37
 */
public class NotSameFileExpection extends Exception {
    public NotSameFileExpection() {
        super("File MD5 Different");
    }
}
