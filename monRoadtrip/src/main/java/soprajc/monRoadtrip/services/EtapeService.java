package soprajc.monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.monRoadtrip.exceptions.ClientException;
import soprajc.monRoadtrip.exceptions.EtapeException;
import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.Etape;
import soprajc.monRoadtrip.model.Logement;
import soprajc.monRoadtrip.repositories.EtapeRepository;

@Service
public class EtapeService {

	@Autowired
	private EtapeRepository etapeRepo;
	
	@Autowired
	private LogementService logementService;
	
	@Autowired
	private ActiviteService activiteService;

	
	public List<Etape> getAll() {
		return etapeRepo.findAll();
	}
	
	public List<Etape> getAllByClient(String mail) {
		return etapeRepo.getAllByClient(mail);
	}
	
	public Etape getById(Integer id) {
		return etapeRepo.findById(id).orElseThrow(EtapeException::new);
	}
	
	public List<Etape> getByIdResa(Integer id) {
		return etapeRepo.getByIdResa(id);
	}

	public Etape save(Etape etape) {
		if (etape.getId() != null) {
			Etape etapeEnBase = getById(etape.getId());
			etape.setVersion(etapeEnBase.getVersion());
		}
		return etapeRepo.save(etape);
	}

	public void delete(Etape etape) {
		etapeRepo.delete(etape);
	}

	public void deleteById(Integer id) {
		etapeRepo.deleteById(id);
	}
	
	public Etape addLogement(Etape etape, Integer id) {
		Logement logement = logementService.getById(id);
		etape.setLogement(logement);
		return etapeRepo.save(etape);
	}
	
	public Etape addActivite(Etape etape, Integer id) {
		Activite activite = activiteService.getById(id);
		etape.getActivites().add(activite);
		return etapeRepo.save(etape);
	}	
	
	public Etape removeLogement(Etape etape) {
		etape.setLogement(null);
		return etapeRepo.save(etape);
	}
	
	public Etape removeActivite(Etape etape, Integer id) {
		Activite activite = activiteService.getById(id);
		etape.getActivites().remove(activite);
		return etapeRepo.save(etape);
	}
	
}
