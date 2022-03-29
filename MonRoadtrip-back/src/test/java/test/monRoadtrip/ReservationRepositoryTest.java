package test.monRoadtrip;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import monRoadtrip.config.AppConfig;
import monRoadtrip.model.Client;
import monRoadtrip.model.Participant;
import monRoadtrip.model.Reservation;
import monRoadtrip.model.Roadtrip;
import monRoadtrip.model.Statut;
import monRoadtrip.repositories.ReservationRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class ReservationRepositoryTest {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Test
	@Transactional
	void insertTest() {
		Participant participant = new Participant("Sati", "Chaymae", 26);
		Roadtrip roadtrip = new Roadtrip("Nantes", "Strasbourg", LocalDate.parse("2022-06-25"), LocalDate.parse("2022-07-18"), null, null);
		Client client = new Client("Sati","Chaymae",null, null, null);
		System.out.println(client);
		
		Reservation reservation = new Reservation(LocalDate.parse("2022-03-29"),Statut.A_venir,participant, roadtrip, client);
		reservationRepository.save(reservation);
		
		List<Reservation> reservations = Arrays.asList(new Reservation());
		reservationRepository.saveAll(reservations);
	}
	
	@Test
	@Transactional
	void deleteTest() {
		Participant participant = new Participant("Sati", "Chaymae", 26);
		Roadtrip roadtrip = new Roadtrip("Nantes", "Strasbourg", LocalDate.parse("2022-06-25"), LocalDate.parse("2022-07-18"), null, null);
		Client client = new Client("Sati","Chaymae",null, null, null);
		System.out.println(client);
		
		Reservation reservation = new Reservation(LocalDate.parse("2022-03-29"),Statut.A_venir,participant, roadtrip, client);
		reservationRepository.save(reservation);
		
		reservationRepository.deleteById(reservation.getId());
	}

}
