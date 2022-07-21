package com.al_tair.storage.operation;

import com.al_tair.storage.operation.delete.Deleter;
import com.al_tair.storage.operation.delete.product.LocalStorageDeleter;
import com.al_tair.storage.operation.download.Downloader;
import com.al_tair.storage.operation.download.product.LocalStorageDownloader;
import com.al_tair.storage.operation.upload.Uploader;
import com.al_tair.storage.operation.upload.product.LocalStorageUploader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Al_tair
 * @date 2022/7/21-14:06
 */

@Component
public class LocalStorageOperationFactory implements FileOperationFactory{

    @Resource
    LocalStorageUploader localStorageUploader;
    @Resource
    LocalStorageDownloader localStorageDownloader;
    @Resource
    LocalStorageDeleter localStorageDeleter;
    @Override
    public Uploader getUploader() {
        return localStorageUploader;
    }
    @Override
    public Downloader getDownloader() {
        return localStorageDownloader;
    }
    @Override
    public Deleter getDeleter() {
        return localStorageDeleter;
    }
}
