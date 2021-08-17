package com.projet.controller;

import java.io.IOException;
import java.util.Base64;

import com.projet.entities.Bien;
import com.projet.service.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.projet.doa.IImage;
import com.projet.entities.Image;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
	@Autowired
    IImage imageRepository;

    @PostMapping(path ="/images/add")
    public Image addImage(@RequestParam("file")MultipartFile file, @RequestParam("bien")Bien bien) throws IOException {
        Image img = new Image();

        String uploadDir = "images/";

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        img.setUrl(fileName);
        img.setBien(bien);

        imageRepository.save(img);

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        return img;
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
