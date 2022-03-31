package soprajc.monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soprajc.monRoadtrip.exceptions.CompteException;
import soprajc.monRoadtrip.model.Client;
import soprajc.monRoadtrip.model.Compte;
import soprajc.monRoadtrip.model.Hote;
import soprajc.monRoadtrip.model.Organisateur;
import soprajc.monRoadtrip.repositories.ActiviteRepository;
import soprajc.monRoadtrip.repositories.ClientRepository;
import soprajc.monRoadtrip.repositories.CompteRepository;
import soprajc.monRoadtrip.repositories.HoteRepository;
import soprajc.monRoadtrip.repositories.LogementRepository;
import soprajc.monRoadtrip.repositories.OrganisateurRepository;
import soprajc.monRoadtrip.repositories.ReservationRepository;

@Service
public class CompteService {
	
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	HoteRepository hoteRepository;
	@Autowired
	OrganisateurRepository organisateurRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ActiviteRepository activiteRepository;
	@Autowired
	LogementRepository logementRepository;
	
	public List<Compte> getAll() {
		return compteRepository.findAll();
	}

	public Compte getById(Integer id) {
		return compteRepository.findById(id).orElseThrow(CompteException::new);
	}

	public Compte save(Compte compte) {
		if (compte.getId() != null) {
			Compte compteEnBase = getById(compte.getId());
			compte.setVersion(compteEnBase.getVersion());
		}
		return compteRepository.save(compte);
	}

	public void delete(Compte compte) {
		if(compte instanceof Client) {
			reservationRepository.deleteByClient((Client) compte);
			
		}if(compte instanceof Organisateur) {
			activiteRepository.deleteByOrganisateur((Organisateur) compte);
			
		}if(compte instanceof Hote) {
			logementRepository.deleteByHote((Hote) compte);
			
		}
		compteRepository.delete(compte);
	}

	public void delete(Integer id) {
		delete(getById(id));
	}

	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	public List<Organisateur> getAllOrganisateur() {
		return organisateurRepository.findAll();
	}
	public List<Hote> getAllHote() {
		return hoteRepository.findAll();
	}
}
