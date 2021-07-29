package com.example.projet_gestion_immobilier.dao;

import com.example.projet_gestion_immobilier.enties.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IBien extends JpaRepository<Bien,String >{

}
