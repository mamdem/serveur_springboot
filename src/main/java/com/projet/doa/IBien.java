package com.projet.doa;
import com.projet.entities.Bien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
@Repository
public interface IBien extends CrudRepository<Bien,Long > {
    List<Bien> getAllByIdpers(Long idpers);
    Bien getBienByIdbiens(Long idbiens);
}
