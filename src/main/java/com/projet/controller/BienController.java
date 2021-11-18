package com.projet.controller;

import com.projet.doa.IBien;
import com.projet.entities.Bien;
import com.projet.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BienController {

    @Autowired
    private IBien bienRepo;

    @GetMapping(path = "/biens/all")
    public @ResponseBody
    Iterable<Bien> getAllBien()
    {
        return bienRepo.findAll();
    }

    @PostMapping("/biens/add")
    public ResponseEntity<Void> addBien(@RequestBody Bien b){
        Bien bien = bienRepo.save(b);

        if(bien == null)
            return ResponseEntity.noContent().build();
        else
        {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{id}")
                    .buildAndExpand(bien.getIdbien())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
    }

//    @GetMapping("/biens/getBienByIdpers")
//    public List<Bien> getBienByIdpers(@RequestParam Long idpers){
//        return bienRepo.getAllByIdpers(idpers);
//    }

    @GetMapping("/biens/getBienByIdbiens")
    public Bien getBienByIdbiens(@RequestParam Long idbiens){
        return bienRepo.getBienByIdbiens(idbiens);
    }

    // Update a bien
    @PutMapping(value = "/biens/update/{id}")
    public ResponseEntity<Void> updateTrainee(@RequestBody Bien b, @PathVariable Long idbien){
        Bien bien = bienRepo.getBienByIdbiens(idbien);
        if (bien == null)
            return ResponseEntity.notFound().build();
        else {
            b.setIdbien(bien.getIdbien());
            bienRepo.save(b);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("{/id}")
                    .buildAndExpand(bien.getIdbien())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
    }

}