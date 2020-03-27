package com.doubledigit.solutions.rsvp.app.service;

import com.doubledigit.solutions.rsvp.app.model.Location;
import com.doubledigit.solutions.rsvp.app.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> getAllMarketLocation() {
        return locationRepository.findAll();
    }

    public void addMarketLoc(Location loc) {
        locationRepository.save(loc);
    }

    public void updateMarketLoc(Location loc) {
        //perform business logic
        locationRepository.save(loc);
    }

    public void deleteMarketLoc(Long id) {
        locationRepository.deleteById(id);
    }
}
