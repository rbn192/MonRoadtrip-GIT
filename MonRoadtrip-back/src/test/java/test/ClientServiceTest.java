package test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;


import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import monRoadtrip.config.AppConfig;
import monRoadtrip.model.Adresse;
import monRoadtrip.model.Client;
import monRoadtrip.model.TypeDePaiement;
import monRoadtrip.services.ClientService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
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
		Client c = new Client("Pierson","Robin", "r@r", "123", LocalDate.of(2022, 3, 29), null, 20, TypeDePaiement.Carte, new Adresse("1","rue Jean","91180","Arpajon"));
		clientService.create(c);
		System.out.println(c.getId());
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
