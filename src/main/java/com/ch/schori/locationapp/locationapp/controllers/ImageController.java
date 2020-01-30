package com.ch.schori.locationapp.locationapp.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

@RestController
public class ImageController {

    private static String UPLOADED_FOLDER = "P:\\Java Projects\\locationapp\\src\\main\\java\\com\\ch\\schori\\locationapp\\locationapp\\images\\";

    @CrossOrigin
    @GetMapping("/images/{fileName}")
    public String downloadFileFromLocal(@PathVariable String fileName) {

        String base64 = "";
        try {
            InputStream iSteamReader = new FileInputStream(UPLOADED_FOLDER + fileName);
            byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
            base64 = Base64.getEncoder().encodeToString(imageBytes);
            System.out.println(base64);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + base64;
    }
}
