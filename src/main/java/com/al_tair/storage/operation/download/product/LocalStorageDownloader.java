package com.al_tair.storage.operation.download.product;

import com.al_tair.storage.operation.download.Downloader;
import com.al_tair.storage.operation.download.domain.DownloadFile;
import com.al_tair.storage.util.PathUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Al_tair
 * @date 2022/7/21-13:54
 */
@Component
public class LocalStorageDownloader extends Downloader {
    @Override
    public void download(HttpServletResponse httpServletResponse, DownloadFile downloadFile) {
        BufferedInputStream bis = null;
        byte[] buffer = new byte[1024];
        //设置文件路径
        File file = new File(PathUtil.getStaticPath() + downloadFile.getFileUrl());
        if (file.exists()) {

            FileInputStream fis = null;

            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = httpServletResponse.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
