package com.al_tair.storage.operation;

import com.al_tair.storage.operation.delete.Deleter;
import com.al_tair.storage.operation.download.Downloader;
import com.al_tair.storage.operation.upload.Uploader;

/**
 * @author Al_tair
 * @date 2022/7/21-14:03
 */
public interface FileOperationFactory {
    Uploader getUploader();
    Downloader getDownloader();
    Deleter getDeleter();
}