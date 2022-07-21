package com.al_tair.storage.operation.delete;

import com.al_tair.storage.operation.delete.domain.DeleteFile;

/**
 * @author Al_tair
 * @date 2022/7/21-13:56
 */
public abstract class Deleter {
    public abstract void delete(DeleteFile deleteFile);
}
