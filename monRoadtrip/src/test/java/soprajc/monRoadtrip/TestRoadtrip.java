package soprajc.monRoadtrip;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import soprajc.monRoadtrip.model.Roadtrip;
import soprajc.monRoadtrip.repositories.RoadtripRepository;


@SpringBootTest
class TestRoadtrip {

	@Autowired
	RoadtripRepository roadtripRepo;
	
	@Test
	@Transactional
	@Commit
	void insertRoadtrip() {

		Roadtrip roadtrip = new Roadtrip("depart", "destination", LocalDate.of(2022, 9, 29), LocalDate.of(2022, 9, 29), null, null);
		roadtripRepo.save(roadtrip);
			}

	
	@Test
	@Transactional
	//@Commit
	@Disabled
	void deleteEtapeTest() {
		roadtripRepo.deleteById(1);
	}
	
	
	
}
