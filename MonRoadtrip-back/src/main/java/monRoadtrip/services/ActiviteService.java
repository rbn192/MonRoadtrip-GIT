package monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monRoadtrip.exceptions.ActiviteException;
import monRoadtrip.model.Activite;
import monRoadtrip.repositories.ActiviteRepository;

@Service
public class ActiviteService {
	
	@Autowired
	private ActiviteRepository activiteRepo;
	
	public List<Activite> getAll() {
		return activiteRepo.findAll();
	}
	
	public Activite getById(Integer id) {
		return activiteRepo.findById(id).orElseThrow(ActiviteException::new);
	}

	public Activite save(Activite activite) {
		if (activite.getId() != null) {
			Activite activiteEnBase = getById(activite.getId());
			activite.setVersion(activiteEnBase.getVersion());
		}
		return activiteRepo.save(activite);
	}

	public void delete(Activite activite) {
		activiteRepo.delete(activite);
	}

	public void deleteById(Integer id) {
		activiteRepo.deleteById(id);
	}
	
}
