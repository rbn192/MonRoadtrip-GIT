package monRoadtrip.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import monRoadtrip.model.Compte;



public interface CompteRepository extends JpaRepository<Compte, Integer>{
	Optional<Compte> findByMail(String mail);
}
