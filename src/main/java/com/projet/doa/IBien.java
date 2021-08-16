package com.projet.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entities.Bien;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IBien extends JpaRepository<Bien,String >{

}
