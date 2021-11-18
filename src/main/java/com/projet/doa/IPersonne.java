package com.projet.doa;
import com.projet.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonne extends JpaRepository<Personne, Long> {

    @Query(value = "select * from personne where login = ? and pwd= ?", nativeQuery = true)
    Personne findPersonneByLoginAndPwd(String login, String pwd);
    @Query(value = "select * from personne where idpers = ?", nativeQuery = true)
    Personne findPersonneById(Long idpers);
}
