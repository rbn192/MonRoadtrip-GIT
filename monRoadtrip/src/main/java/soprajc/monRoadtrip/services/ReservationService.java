package soprajc.monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.monRoadtrip.exceptions.ReservationException;
import soprajc.monRoadtrip.model.Reservation;
import soprajc.monRoadtrip.repositories.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public List<Reservation> getAll() {
		return reservationRepository.findAll();
	}

	public Reservation getById(Integer id) {
		return reservationRepository.findById(id).orElseThrow(ReservationException::new);
	}

	public Reservation save(Reservation reservation) {
		if (reservation.getId() != null) {
			Reservation reservationEnBase = getById(reservation.getId());
			reservation.setVersion(reservationEnBase.getVersion());
		}
		return reservationRepository.save(reservation);
	}

	public void delete(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	public void delete(Integer id) {
		delete(getById(id));
	}		

}
