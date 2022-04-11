package soprajc.monRoadtrip.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.monRoadtrip.model.Compte;
import soprajc.monRoadtrip.model.Hote;



public interface CompteRepository extends JpaRepository<Compte, Integer>{
	Optional<Compte> findByMail(String mail);
	
	@Query("select c from Compte c where c.mail=:mail")
	Compte getCompteByMail(@Param("mail") String mail);
}
