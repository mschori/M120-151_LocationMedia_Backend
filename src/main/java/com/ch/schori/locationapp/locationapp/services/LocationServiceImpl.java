package com.ch.schori.locationapp.locationapp.services;

import com.ch.schori.locationapp.locationapp.entities.Location;
import com.ch.schori.locationapp.locationapp.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public List<Location> getAllLocationsFromUser(Long user_id) {
        return locationRepository.getLocationsFromUser(user_id);
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location saveLocationPerUser(Long user_id, Location location) {
        location.setFk_user(user_id);
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocationPerLocationId(Long location_id, Location location) {
        location.setId(location_id);
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepository.delete(location);
    }

    public void deleteLocationSave(Long user_id, Long location_id) {
        locationRepository.deleteLocationSave(user_id, location_id);
    }
}
