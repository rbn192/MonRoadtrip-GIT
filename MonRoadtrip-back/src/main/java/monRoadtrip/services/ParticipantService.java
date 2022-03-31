package monRoadtrip.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monRoadtrip.exceptions.ParticipantException;
import monRoadtrip.model.Participant;
import monRoadtrip.repositories.ParticipantRepository;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepo;
	
	@Autowired
	private Validator validator;
	
	public List<Participant> getAll() {
		return participantRepo.findAll();
	}
	
	public Participant getById(Integer id) {
		return participantRepo.findById(id).orElseThrow(ParticipantException::new);
	}
	
	
	public Participant save(Participant participant) {
		Set<ConstraintViolation<Participant>> constraints = validator.validate(participant);
		if (!constraints.isEmpty()) {
			throw new ParticipantException("erreur de validation");
		}

		if (participant.getId() != null) {
			Participant participantEnBase = getById(participant.getId());
			participant.setVersion(participantEnBase.getVersion());
		}
		return participantRepo.save(participant);
	}

	public void delete(Participant participant) {
		delete(participant.getId());
	}

	public void delete(Integer id) {
		participantRepo.deleteById(id);
	}
	
	
	
	
	
}
