package com.projet.controller;

import com.projet.doa.ILocation;
import com.projet.doa.IPersonne;
import com.projet.entities.Location;
import com.projet.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {
    @Autowired
    private ILocation locationRepo;

    @GetMapping(path = "/location/all")
    public @ResponseBody
    Iterable<Location> getAllLocation()
    {
        return locationRepo.findAll();
    }

    @PostMapping("/addLocation")

    public Location addLocation(@RequestBody Location l){
        return locationRepo.save(l);
    }
}
