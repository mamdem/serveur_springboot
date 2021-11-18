package com.projet.doa;
import com.projet.entities.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface IBien extends JpaRepository<Bien,Long > {
    @RestResource
    @Query(value = "SELECT * FROM `bien` WHERE idpers=:id", nativeQuery = true)
    List<Bien> getBienByIdpers (@Param("id") Long id);

    Bien getBienByIdbiens(Long idbien);
}
