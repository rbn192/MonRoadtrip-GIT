package soprajc.monRoadtrip.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.monRoadtrip.exceptions.ReservationException;
import soprajc.monRoadtrip.model.Etape;
import soprajc.monRoadtrip.model.Reservation;
import soprajc.monRoadtrip.repositories.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ParticipantService participantService;
	
	@Autowired
	private EtapeService etapeService;
	

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
		Reservation reservation2 =  reservationRepository.save(reservation);
		List<Etape> etapes = etapeService.getAllByClient(reservation.getClient().getMail());
		reservation.setEtapes(etapes);
		for(Etape etape : etapes) {
			Etape etapeBase =etapeService.getById(etape.getId());
			etapeBase.setReservation(reservation);
			etapeService.save(etapeBase);
		}
		
		
		return reservation2;
		
	}

	public void delete(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	public void delete(Integer id) {
		delete(getById(id));
	}		
	
	public Reservation getByParticipant(Integer id) {
		return reservationRepository.findByParticipant(participantService.getById(id)).orElseThrow();
	}
	
	public List<Reservation> getReservationByClient(String mail) {
		return reservationRepository.getAllByClientMail(mail);
	}

}
