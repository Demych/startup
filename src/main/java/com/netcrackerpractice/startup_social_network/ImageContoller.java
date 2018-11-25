package com.netcrackerpractice.startup_social_network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class ImageContoller {

    @Autowired
    ServiceImageImpl serviceImage;
    @GetMapping
    private String getRequs() {
        return "controller work";
    }
    @PostMapping("/image")
    private String saveImage(@RequestParam("image") MultipartFile image) throws GeneralSecurityException, IOException {

        serviceImage.saveImage(image);
        return "ololo";
    }
}

