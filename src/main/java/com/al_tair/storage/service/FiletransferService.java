package com.al_tair.storage.service;

import com.al_tair.storage.dto.DownloadFileDTO;
import com.al_tair.storage.dto.UploadFileDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Al_tair
 * @date 2022/7/21-14:12
 */
public interface FiletransferService {
    /**
     * 上传文件
     * @param request
     * @param uploadFileDto
     * @param userId
     */
    void uploadFile(HttpServletRequest request, UploadFileDTO uploadFileDto, Long userId);

    /**
     * 下载文件
     * @param httpServletResponse
     * @param downloadFileDTO
     */
    void downloadFile(HttpServletResponse httpServletResponse, DownloadFileDTO downloadFileDTO);

    /**
     *
     * @param userId
     * @return
     */
    Long selectStorageSizeByUserId(Long userId);
}
