package monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monRoadtrip.exceptions.EtapeException;
import monRoadtrip.model.Etape;
import monRoadtrip.repositories.EtapeRepository;

@Service
public class EtapeService {

	@Autowired
	private EtapeRepository etapeRepo;
	
	public List<Etape> getAll() {
		return etapeRepo.findAll();
	}
	
	public Etape getById(Integer id) {
		return etapeRepo.findById(id).orElseThrow(EtapeException::new);
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
	
}
