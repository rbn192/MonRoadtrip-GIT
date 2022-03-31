package soprajc.monRoadtrip.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.monRoadtrip.model.Hote;
import soprajc.monRoadtrip.model.Logement;

public interface LogementRepository extends JpaRepository<Logement, Integer>{
	
	@Modifying
	@Transactional
	@Query("delete from Logement l where l.hote=:hote")
	void deleteByHote(@Param("hote") Hote hote);
	
	@Query("select l from Logement l where l.hote=:hote")
	void getAllByHote(@Param("hote") Hote hote);

}
