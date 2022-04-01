package soprajc.monRoadtrip;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.Client;
import soprajc.monRoadtrip.model.Hote;
import soprajc.monRoadtrip.model.Logement;
import soprajc.monRoadtrip.repositories.LogementRepository;
import soprajc.monRoadtrip.services.CompteService;
import soprajc.monRoadtrip.services.LogementService;

@SpringBootTest
class LogementRepositoryTest {
	
	@Autowired
	LogementRepository logementRepository;
	
	@Autowired
	LogementService logementService;
	
	@Autowired
	CompteService compteService;

	@Test
	@Transactional
	@Commit
	void insertTest() {
		
		
		Adresse adresse = new Adresse("13","rue des peupliers","44000","Nantes");
		Hote hote = new Hote("Pierson","Robin2","robin@gmail.com","hote",LocalDate.parse("1997-03-17"));
		Hote hote2 = new Hote("Pierson","Robin3","robin","hote",LocalDate.parse("1997-03-17"));

		Client client = new Client("Test","test","test","test",LocalDate.parse("1996-12-05"));
		compteService.save(hote);
		compteService.save(client);
		compteService.save(hote2);
		System.out.println(hote.getId());
		
		Logement logement = new Logement(LocalDate.parse("2022-07-26"), 100, adresse, 0, hote);
		
		logementService.save(logement);
	}
//	
//	@Test
//	@Transactional
//	void insertServiceTest() {
//		
//		Adresse adresse = new Adresse("13","rue des peupliers","44000","Nantes");
//		Hote hote = new Hote("Pierson","Robin","robin@gmail.com","hote",LocalDate.parse("1997-03-17"));
//		Logement logement = new Logement(LocalDate.parse("2022-07-26"), 100, adresse, 0, hote);
//		
//		logementService.save(logement);
//	}
//	
//	@Test
//	@Transactional
//	void deleteServiceTest() {
//		
//		Adresse adresse = new Adresse("13","rue des peupliers","44000","Nantes");
//		Hote hote = new Hote("Pierson","Robin","robin@gmail.com","hote",LocalDate.parse("1997-03-17"));
//		Logement logement = new Logement(LocalDate.parse("2022-07-26"), 100, adresse, 0, hote);
//		
//		logementService.save(logement);
//		
//		logementService.delete(logement);
//	}
//	
//	@Test
//	void testGetAll() {
//		List<Logement> logements = logementService.getAll();
//		System.out.println(logements);
//	}

}
