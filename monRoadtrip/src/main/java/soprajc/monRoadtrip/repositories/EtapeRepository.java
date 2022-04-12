package soprajc.monRoadtrip.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.monRoadtrip.model.Etape;
import soprajc.monRoadtrip.model.Reservation;

public interface EtapeRepository extends JpaRepository<Etape, Integer> {
	
	@Modifying
	@Transactional
	@Query("delete from Etape e where e.reservation=:reservation")
	void deleteByReservation(@Param("reservation") Reservation reservation);
	
	@Query("select e from Etape e where e.reservation.client.mail=:mail")
	List<Etape> getAllByClient(@Param("mail") String mail);
	
	@Query("select e from Etape e where e.reservation.id=:id")
	List<Etape> getByIdResa(@Param("id") Integer id);
}
