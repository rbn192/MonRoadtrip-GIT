package soprajc.monRoadtrip;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.Client;
import soprajc.monRoadtrip.model.TypeDePaiement;
import soprajc.monRoadtrip.services.ClientService;


@SpringBootTest
public class ClientServiceTest {

	@Autowired
	ClientService clientService;

	
	@Test
	void injectionTest() {
		assertNotNull(clientService);
	}
	
	@Test
	@Transactional
	@Rollback
	
	void insertTest() {
		Client c = new Client("Toto","Titi", "toto@toto", "123", LocalDate.of(2022, 3, 30), null, 50, TypeDePaiement.Carte, new Adresse("51","rue Carotte","75000","Paris"));
		clientService.create(c);
		System.out.println(c.getId());
		System.out.println(c.getAdresse());
		//System.out.println(clientService.getAll());

	}
	
	@Test
	@Transactional
	@Rollback
	void deleteTest() {
		Client c = new Client("Pierson","Robin", "r@r", "123", LocalDate.of(2022, 3, 29), null, 20, TypeDePaiement.Carte, new Adresse("1","rue Jean","91180","Arpajon"));
		clientService.create(c);
		clientService.delete(c);
		//		long nbreLigne = activiteRepository.count();
//		assertEquals(3, nbreLigne);
//		activiteRepository.deleteById(2);
//		assertNotEquals(3, activiteRepository.count());
	}
	
}
