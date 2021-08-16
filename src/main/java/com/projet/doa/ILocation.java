package com.projet.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entities.Location;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ILocation extends JpaRepository<Location,String > {

}
