package com.projet.controller;

import com.projet.doa.IPersonne;
import com.projet.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PersonneController {
    @Autowired
    private IPersonne personneRepo;

    @GetMapping(path = "personnes/all")
    public @ResponseBody
    Iterable<Personne> getAllImage()
    {
        return personneRepo.findAll();
    }

    @PostMapping("/personnes/add")
    public ResponseEntity<Void> addEtudiant(@RequestBody Personne p){
        Personne personne = personneRepo.save(p);
        if (personne == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(personne.getIdpers())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/personnes/{idpers}")
    public Personne getPersonneById (@PathVariable("idpers") Long idpers){
        return personneRepo.findPersonneById(idpers);
    }

    @GetMapping("/personnes/findByLogin")
    public Personne getPersonneByLogin (@RequestParam String login, @RequestParam String pwd){
        return personneRepo.findPersonneByLoginAndPwd(login, pwd);
    }

    // Update a personne
    @PutMapping(value = "/personnes/update/{id}")
    public ResponseEntity<Void> updateTrainee(@RequestBody Personne p, @PathVariable Long idpers){
        Personne personne = personneRepo.findPersonneById(idpers);
        if (personne == null)
            return ResponseEntity.notFound().build();
        else {
            p.setIdpers(personne.getIdpers());
            personneRepo.save(p);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{/id}")
                    .buildAndExpand(personne.getIdpers())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
    }
}
