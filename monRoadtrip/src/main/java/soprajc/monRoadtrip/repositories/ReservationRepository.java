package soprajc.monRoadtrip.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.Client;
import soprajc.monRoadtrip.model.Participant;
import soprajc.monRoadtrip.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.client=:client")
	void deleteByClient(@Param("client") Client client);

	@Modifying
	@Transactional
	@Query("delete from Reservation r where r.participant=:participant")
	void deleteByParticipant(@Param("participant") Participant participant);
	
	@Query("select r from Reservation r where r.client=:client")
	Optional<Reservation> getAllByClient(@Param("client") Client client);
	
	@Query("select r from Reservation r where r.participant=:participant")
	Optional<Reservation> findByParticipant(@Param("participant") Participant participant);
	
	@Query("select r from Reservation r where r.client.mail=:mail")
	List<Reservation> getAllByClientMail(@Param("mail") String mail);
	
}
