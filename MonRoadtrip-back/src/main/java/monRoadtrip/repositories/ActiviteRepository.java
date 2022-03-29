package monRoadtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import monRoadtrip.model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Integer> {

}
