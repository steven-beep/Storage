package com.al_tair.storage.operation.download;

import com.al_tair.storage.operation.download.domain.DownloadFile;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Al_tair
 * @date 2022/7/21-13:54
 */
public abstract class Downloader {
    public abstract void download(HttpServletResponse httpServletResponse, DownloadFile uploadFile);
}
