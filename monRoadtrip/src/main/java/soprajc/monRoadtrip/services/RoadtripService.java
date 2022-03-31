package soprajc.monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.monRoadtrip.exceptions.RoadtripException;
import soprajc.monRoadtrip.model.Roadtrip;
import soprajc.monRoadtrip.repositories.RoadtripRepository;

@Service
public class RoadtripService {
	
	@Autowired
	private RoadtripRepository roadtripRepo;

	public List<Roadtrip> getAll() {
		return roadtripRepo.findAll();
	}

	public Roadtrip getById(Integer id) {
		return roadtripRepo.findById(id).orElseThrow(RoadtripException::new);
	}
	
	public Roadtrip save(Roadtrip roadtrip) {
		if (roadtrip.getId() != null) {
			Roadtrip roadtripEnBase = getById(roadtrip.getId());
			roadtrip.setVersion(roadtripEnBase.getVersion());
		}
		return roadtripRepo.save(roadtrip);
	}

	public void delete(Roadtrip roadtrip) {
		delete(roadtrip.getId());
	}

	public void delete(Integer id) {
		roadtripRepo.deleteById(id);
	}
	

}
