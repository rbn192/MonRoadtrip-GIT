package monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monRoadtrip.exceptions.LogementException;
import monRoadtrip.model.Logement;
import monRoadtrip.repositories.LogementRepository;

@Service
public class LogementService {
	
	@Autowired
	LogementRepository logementRepository;
	
	public List<Logement> getAll() {
		return logementRepository.findAll();
	}

	public Logement getById(Integer id) {
		return logementRepository.findById(id).orElseThrow(LogementException::new);
	}

	public Logement save(Logement logement) {
		if (logement.getId() != null) {
			Logement logementEnBase = getById(logement.getId());
			logement.setVersion(logementEnBase.getVersion());
		}
		return logementRepository.save(logement);
	}

	public void delete(Logement logement) {
		logementRepository.delete(logement);
	}

	public void delete(Integer id) {
		delete(getById(id));
	}

}
