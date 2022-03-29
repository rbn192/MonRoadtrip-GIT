package test.monRoadtrip;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
import monRoadtrip.model.Activite;
import monRoadtrip.model.Adresse;
import monRoadtrip.model.Etape;
import monRoadtrip.services.EtapeService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class EtapeRepoTest {

	@Autowired
	EtapeService etapeService;	
	
	@Test
	@Transactional
//	@Commit
	@Rollback
	void creationEtapeTest() {
		Adresse adresse = new Adresse("1", "rue", "11000", "Ville");
		Activite a1 = new Activite(LocalDate.of(2022, 03, 30), LocalTime.of(14, 0), 150, adresse, "visite", 4, null);
		Activite a2 = new Activite(LocalDate.of(2022, 03, 31), LocalTime.of(15, 0), 10, adresse, "rando", 2, null);
		List<Activite> activites = new ArrayList();
		activites.add(a1);
		activites.add(a2);
		Etape e = new Etape(3, LocalDate.of(2022, 03, 30), activites, null, null, "Ville");
		etapeService.save(e);
		assertNotNull(e.getDuree());
	}
	
	@Test
	@Transactional
//	@Commit
	@Rollback
	@Disabled
	void deleteEtapeTest() {
		etapeService.deleteById(1);
	}
}