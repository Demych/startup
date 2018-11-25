package com.netcrackerpractice.startup_social_network;

import com.google.api.services.drive.Drive;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ServiceImage {
    void saveImage(MultipartFile file) throws GeneralSecurityException, IOException;

}
