package test;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import monRoadtrip.config.AppConfig;
import monRoadtrip.model.Roadtrip;
import monRoadtrip.repositories.RoadtripRepository;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class TestRoadtrip {

	@Autowired
	RoadtripRepository roadtripRepo;
	
	@Test
	@Transactional
	@Commit
	void insertRoadtrip() {

		Roadtrip roadtrip = new Roadtrip("depart", "destination", LocalDate.of(2022, 03, 29), LocalDate.of(2022, 03, 29), null, null);
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
