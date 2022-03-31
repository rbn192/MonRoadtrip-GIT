package soprajc.monRoadtrip;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import soprajc.monRoadtrip.model.Client;
import soprajc.monRoadtrip.model.Participant;
import soprajc.monRoadtrip.model.Reservation;
import soprajc.monRoadtrip.model.Roadtrip;
import soprajc.monRoadtrip.model.Statut;
import soprajc.monRoadtrip.repositories.ReservationRepository;
import soprajc.monRoadtrip.services.ClientService;

@SpringBootTest
class ReservationRepositoryTest {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ClientService clientService;
	
	@Test
	@Transactional
	void insertTest() {
		Participant participant = new Participant("Sati", "Chaymae", 26);
		Roadtrip roadtrip = new Roadtrip("Nantes", "Strasbourg", LocalDate.parse("2022-06-25"), LocalDate.parse("2022-07-18"), null, null);
		Client client = new Client("Sati","Chaymae","chaymae@gmail.com","client",LocalDate.parse("1996-07-13"));
		clientService.create(client);
		
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
