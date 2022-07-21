package com.al_tair.storage.operation.delete.domain;

import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/21-13:59
 */
@Data
public class DeleteFile {
    private String fileUrl;
    private String timeStampName;
}