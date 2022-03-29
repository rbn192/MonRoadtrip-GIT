package monRoadtrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import monRoadtrip.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
