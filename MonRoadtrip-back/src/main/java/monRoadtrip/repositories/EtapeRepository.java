package monRoadtrip.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import monRoadtrip.model.Reservation;
import monRoadtrip.model.Etape;

public interface EtapeRepository extends JpaRepository<Etape, Integer> {
	
	@Modifying
	@Transactional
	@Query("delete from Etape e where e.reservation=:reservation")
	void deleteByReservation(@Param("reservation") Reservation reservation);

}
