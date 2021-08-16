package com.example.projet_gestion_immobilier.dao;

import com.example.projet_gestion_immobilier.enties.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IImage extends JpaRepository<Image, Long> {

}
