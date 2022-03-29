package test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import monRoadtrip.config.AppConfig;
import monRoadtrip.model.Participant;
import monRoadtrip.repositories.ParticipantRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
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
