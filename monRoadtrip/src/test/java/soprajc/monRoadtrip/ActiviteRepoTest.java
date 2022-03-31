package soprajc.monRoadtrip;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import monRoadtrip.config.AppConfig;
import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.services.ActiviteService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class ActiviteRepoTest {

	@Autowired
	ActiviteService activiteService;	
	
	@Test
	@Transactional
//	@Commit
	@Rollback
	@Disabled
	void creationActiviteTest() {
		Adresse adresse = new Adresse("1", "rue", "11000", "Ville");
		Activite a = new Activite(LocalDate.of(2022, 03, 30), LocalTime.of(14, 0), 150, adresse, "visite", 4, null);
		activiteService.save(a);
		assertNotNull(a.getNbPlaces());
	}
	
	@Test
	@Transactional
//	@Commit
	@Rollback
	void deleteActiviteTest() {
		activiteService.deleteById(2);
	}
}