package soprajc.monRoadtrip;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.Etape;
import soprajc.monRoadtrip.services.EtapeService;

@SpringBootTest
class EtapeRepoTest {

	@Autowired
	EtapeService etapeService;	
	
	@Test
	@Transactional
	@Commit
//	@Rollback
	void creationEtapeTest() {
		Adresse adresse = new Adresse("3", "rue", "11000", "City");
		List<Activite> activites = new ArrayList();
		Etape e = new Etape(3, LocalDate.of(2022, 7, 30), activites, null, null, "City");
		etapeService.save(e);
		assertNotNull(e.getDuree());
	}
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void deleteEtapeTest() {
		etapeService.deleteById(1);
	}
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void addActiviteTest() {
		etapeService.addActivite(etapeService.getById(2), 1);
		System.out.println(etapeService.getById(2));
	}
}