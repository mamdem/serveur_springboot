package com.projet.controller;

import com.projet.doa.ILocation;
import com.projet.doa.IPersonne;
import com.projet.entities.Bien;
import com.projet.entities.Location;
import com.projet.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class LocationController {
    @Autowired
    private ILocation locationRepo;

    @GetMapping(path = "/locations/all")
    public @ResponseBody
    Iterable<Location> getAllLocation()
    {
        return locationRepo.findAll();
    }

    @PostMapping("/locations/add")
    public ResponseEntity<Void> addLocation(@RequestBody Location l){
        Location location1 = locationRepo.save(l);
        if (location1 == null)
            return ResponseEntity.noContent().build();
        else
        {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{/id}")
                    .buildAndExpand(location1.getIdLocation())
                    .toUri();
            return ResponseEntity.created(location).build();

        }
    }

    // Update a location
    @PutMapping(value = "/locations/update/{id}")
    public ResponseEntity<Void> updateTrainee(@RequestBody Location l, @PathVariable String idLocation){
        Location location1 = locationRepo.getById(idLocation);
        if (location1 == null)
            return ResponseEntity.notFound().build();
        else {
            l.setIdLocation(location1.getIdLocation());
            locationRepo.save(l);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{/id}")
                    .buildAndExpand(location1.getIdLocation())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
    }
}
