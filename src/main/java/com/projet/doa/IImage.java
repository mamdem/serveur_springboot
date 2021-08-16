package com.projet.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entities.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface IImage extends JpaRepository<Image, Long>{
	//public Image findById(int idImage);
}
