package com.projet.controller;

import com.projet.doa.IPersonne;
import com.projet.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonneController {
    @Autowired
    private IPersonne personneRepo;

    @GetMapping(path = "/personne/all")
    public @ResponseBody
    Iterable<Personne> getAllImage()
    {
        return personneRepo.findAll();
    }

    @PostMapping("/personne/add")
    public Personne addEtudiant(@RequestBody Personne p){
        return personneRepo.save(p);
    }

    @GetMapping(path = "/personne/{idpers}")
    public Optional<Personne> getPersonneById (@PathVariable("idpers") Long idpers){
        return personneRepo.findById(idpers);
    }

    @GetMapping("/personne/findByLogin")
    public Personne getPersonneByLogin (@RequestParam String login, @RequestParam String pwd){
        return personneRepo.findPersonneByLoginAndPwd(login, pwd);
    }
}
