package com.ch.schori.locationapp.locationapp.controllers;

import com.ch.schori.locationapp.locationapp.entities.Location;
import com.ch.schori.locationapp.locationapp.repos.LocationRepository;
import com.ch.schori.locationapp.locationapp.services.LocationService;
import com.ch.schori.locationapp.locationapp.services.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationServiceImpl locationService;

    @CrossOrigin
    @GetMapping("users/{uid}/locations")
    public List<Location> getLocations(@PathVariable("uid") Long user_id) {
        return locationService.getAllLocationsFromUser(user_id);
    }

    @CrossOrigin
    @PostMapping("users/{uid}/locations")
    public Location createLocation(@PathVariable("uid") Long user_id, @RequestBody Location location) {
        return locationService.saveLocationPerUser(user_id, location);
    }

    @CrossOrigin
    @PutMapping("/users/{uid}/locations/{id}")
    public Location updateLocation(@PathVariable("uid") Long user_id, @PathVariable("id") Long location_id, @RequestBody Location location) {
        return locationService.updateLocationPerLocationId(location_id, location);
    }

    @CrossOrigin
    @DeleteMapping("users/{uid}/locations/{id}")
    public void deleteLocation(@PathVariable("uid") Long user_id, @PathVariable("id") Long location_id) {
        locationService.deleteLocationSave(user_id, location_id);
    }
}
