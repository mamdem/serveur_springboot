package com.projet.doa;
import com.projet.entities.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
@Repository
public interface IPersonne extends CrudRepository<Personne, Long> {

    Personne findPersonneByLoginAndPwd(String login, String pwd);

}
