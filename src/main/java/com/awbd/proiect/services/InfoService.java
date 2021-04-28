package com.awbd.proiect.services;

import org.springframework.web.multipart.MultipartFile;

public interface InfoService {
    void saveImageFile(Long locationId, MultipartFile file);
}
