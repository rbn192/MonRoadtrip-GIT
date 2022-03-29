package monRoadtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import monRoadtrip.model.Logement;

public interface LogementRepository extends JpaRepository<Logement, Integer>{

}
