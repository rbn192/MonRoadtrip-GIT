package soprajc.monRoadtrip.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.Organisateur;

public interface ActiviteRepository extends JpaRepository<Activite, Integer> {
	
	@Modifying
	@Transactional
	@Query("delete from Activite a where a.organisateur=:organisateur")
	void deleteByOrganisateur(@Param("organisateur") Organisateur organisateur);
	
	@Query("select a from Activite a where a.organisateur=:organisateur")
	void getAllByOrganisateur(@Param("organisateur") Organisateur organisateur);

}
