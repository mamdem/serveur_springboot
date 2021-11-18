package com.projet.doa;
import com.projet.entities.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBien extends JpaRepository<Bien,Long > {
    //List<Bien> getAllByIdpers(Long idpers);
    @Query(value = "select * from bien where idbien = ?",nativeQuery = true)
    Bien getBienByIdbiens(Long idbiens);
}
