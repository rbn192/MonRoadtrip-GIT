package monRoadtrip.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import monRoadtrip.model.Client;
import monRoadtrip.model.Participant;
import monRoadtrip.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.client=:client")
	void deleteByClient(@Param("client") Client client);

	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.participant=:participant")
	void deleteByParticipant(@Param("participant") Participant participant);
}
