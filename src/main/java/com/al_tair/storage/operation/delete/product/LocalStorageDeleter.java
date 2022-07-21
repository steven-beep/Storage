package com.al_tair.storage.operation.delete.product;

import java.io.File;

import com.al_tair.storage.operation.delete.Deleter;
import com.al_tair.storage.operation.delete.domain.DeleteFile;
import com.al_tair.storage.util.FileUtil;
import com.al_tair.storage.util.PathUtil;
import org.springframework.stereotype.Component;

/**
 * @author Al_tair
 * @date 2022/7/21-13:59
 */
@Component
public class LocalStorageDeleter extends Deleter {
    @Override
    public void delete(DeleteFile deleteFile) {
        File file = new File(PathUtil.getStaticPath() + deleteFile.getFileUrl());
        if (file.exists()) {
            file.delete();
        }

        if (FileUtil.isImageFile(FileUtil.getFileExtendName(deleteFile.getFileUrl()))) {
            File minFile = new File(PathUtil.getStaticPath() + deleteFile.getFileUrl().replace(deleteFile.getTimeStampName(), deleteFile.getTimeStampName() + "_min"));
            if (minFile.exists()) {
                minFile.delete();
            }
        }
    }
}