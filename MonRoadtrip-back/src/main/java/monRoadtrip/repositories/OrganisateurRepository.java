package monRoadtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import monRoadtrip.model.Organisateur;

public interface OrganisateurRepository extends JpaRepository<Organisateur, Integer> {
	
}
