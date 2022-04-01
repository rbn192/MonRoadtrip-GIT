package soprajc.monRoadtrip;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.Client;
import soprajc.monRoadtrip.model.Hote;
import soprajc.monRoadtrip.model.TypeDePaiement;
import soprajc.monRoadtrip.services.CompteService;

@SpringBootTest
public class CompteServiceTest {

	@Autowired
	CompteService compteService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void injectionTest() {
		assertNotNull(compteService);
	}
	@Test
	@Transactional
	@Commit
	
	void insertTest() {
		Client c = new Client("Bob","Bob", "bob", passwordEncoder.encode("123"), LocalDate.of(2022, 3, 30), null, 50, TypeDePaiement.Carte, new Adresse("33","rue Wesh","75000","Paris"));
		Hote h = new Hote("Bob","Bob", "bob@bob", passwordEncoder.encode("1234"), LocalDate.of(2022, 3, 30));
		compteService.save(c);
		compteService.save(h);
		//System.out.println(c.getId());
		//System.out.println(c.getAdresse());
		//System.out.println(clientService.getAll());

	}
	
//	@Test
//	@Transactional
//	@Rollback
//	void deleteTest() {
//		Client c = new Client("Pierson","Robin", "r@r", "123", LocalDate.of(2022, 3, 29), null, 20, TypeDePaiement.Carte, new Adresse("1","rue Jean","91180","Arpajon"));
//		compteService.save(c);
//		compteService.delete(c);
//		//		long nbreLigne = activiteRepository.count();
////		assertEquals(3, nbreLigne);
////		activiteRepository.deleteById(2);
////		assertNotEquals(3, activiteRepository.count());
//	}
}
