package com.ch.schori.locationapp.locationapp.controllers;

import com.ch.schori.locationapp.locationapp.entities.Location;
import com.ch.schori.locationapp.locationapp.services.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@RestController
public class LocationController {

    private static String UPLOADED_FOLDER = "P:\\Java Projects\\locationapp\\src\\main\\java\\com\\ch\\schori\\locationapp\\locationapp\\images\\";

    @Autowired
    LocationServiceImpl locationService;

    @CrossOrigin
    @GetMapping("users/{uid}/locations")
    public List<Location> getLocations(@PathVariable("uid") Long user_id) {
        return locationService.getAllLocationsFromUser(user_id);
    }

    @CrossOrigin
    @PostMapping("users/{uid}/locations")
    public Location createLocation(@PathVariable("uid") Long user_id, @RequestParam String name, @RequestParam String address, @RequestParam String description, @RequestParam Long fk_user, @RequestParam("file") MultipartFile file) {
        Date date = new Date();
        long timeMilli = date.getTime();
        String filename = timeMilli + "_" + file.getOriginalFilename();
        Location location = new Location();
        location.setFk_user(fk_user);
        location.setName(name);
        location.setAddress(address);
        location.setDescription(description);
        location.setImagename(filename);
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + filename);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return locationService.saveLocationPerUser(user_id, location);
    }

    @CrossOrigin
    @PutMapping("/users/{uid}/locations/{id}")
    public Location updateLocation(@PathVariable("uid") Long user_id, @PathVariable("id") Long location_id, @RequestParam String name, @RequestParam String address, @RequestParam String description, @RequestParam Long fk_user, @RequestParam(value = "file", required = false) MultipartFile file) {

        Location location = new Location();
        location.setFk_user(fk_user);
        location.setName(name);
        location.setAddress(address);
        location.setDescription(description);
        location.setImagename("empty");

        if (file != null) {
            Date date = new Date();
            long timeMilli = date.getTime();
            String filename = timeMilli + "_" + file.getOriginalFilename();

            location.setImagename(filename);
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + filename);
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return locationService.updateLocationPerLocationId(location_id, location);
    }

    @CrossOrigin
    @DeleteMapping("users/{uid}/locations/{id}")
    public void deleteLocation(@PathVariable("uid") Long user_id, @PathVariable("id") Long location_id) {
        locationService.deleteLocationSave(user_id, location_id);
    }
}
