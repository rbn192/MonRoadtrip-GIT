package monRoadTrip.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import monRoadtrip.config.AppConfig;
import monRoadtrip.model.Adresse;
import monRoadtrip.model.Hote;
import monRoadtrip.model.Logement;
import monRoadtrip.repositories.LogementRepository;
import monRoadtrip.services.LogementService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class LogementRepositoryTest {
	
	@Autowired
	LogementRepository logementRepository;
	
	@Autowired
	LogementService logementService;

	@Test
	@Transactional
	void insertTest() {
		
		Adresse adresse = new Adresse("13","rue des peupliers","44000","Nantes");
		Hote hote = new Hote("Pierson","Robin","robin@gmail.com","hote",LocalDate.parse("1997-03-17"));
		Logement logement = new Logement(LocalDate.parse("2022-07-26"), 100, adresse, 0, hote);
		
		logementRepository.save(logement);
	}
	
	@Test
	@Transactional
	void insertServiceTest() {
		
		Adresse adresse = new Adresse("13","rue des peupliers","44000","Nantes");
		Hote hote = new Hote("Pierson","Robin","robin@gmail.com","hote",LocalDate.parse("1997-03-17"));
		Logement logement = new Logement(LocalDate.parse("2022-07-26"), 100, adresse, 0, hote);
		
		logementService.save(logement);
	}
	
	@Test
	@Transactional
	void deleteServiceTest() {
		
		Adresse adresse = new Adresse("13","rue des peupliers","44000","Nantes");
		Hote hote = new Hote("Pierson","Robin","robin@gmail.com","hote",LocalDate.parse("1997-03-17"));
		Logement logement = new Logement(LocalDate.parse("2022-07-26"), 100, adresse, 0, hote);
		
		logementService.save(logement);
		
		logementService.delete(logement);
	}

}
