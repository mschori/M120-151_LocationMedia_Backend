package com.ch.schori.locationapp.locationapp.services;

import com.ch.schori.locationapp.locationapp.entities.Location;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();

    Location saveLocation(Location location);

    Location updateLocation(Location location);

    void deleteLocation(Location location);
}
