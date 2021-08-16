package com.projet.controller;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.projet.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.doa.IImage;
import com.projet.entities.Image;

@RestController
public class ImageController {
	@Autowired
    IImage imageRepository;

    @PostMapping(path ="/images/add")
    public Image addImage(@RequestBody Image img)
    {
    	ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(img.getUrl()).getFile());
        try {
			if (file.createNewFile()) {
			    System.out.println("File is created!");
			} else {
			    System.out.println("File already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageRepository.save(img);
    }

    

    @GetMapping(path = "/images/all")
    public @ResponseBody Iterable<Image> getAllImage()
    {
        return imageRepository.findAll();
    }

    @PostMapping("/addImage")
    public Image addEtudiant(@RequestBody Image i){
        return imageRepository.save(i);
    }

}
