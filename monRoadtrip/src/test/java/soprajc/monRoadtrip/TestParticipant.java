package soprajc.monRoadtrip;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import soprajc.monRoadtrip.model.Participant;
import soprajc.monRoadtrip.repositories.ParticipantRepository;

@SpringBootTest
class TestParticipant {

	@Autowired
	ParticipantRepository participantRepo;
	
	@Test
	@Transactional
	@Commit
	void insertParticipant() {
		
		Participant participant = new Participant("nom", "prenom", 10);
		participantRepo.save(participant);
		
			}

	@Test
	@Transactional
	//@Commit
	@Disabled
	void deleteEtapeTest() {
		participantRepo.deleteById(1);
	}
	
	
}
