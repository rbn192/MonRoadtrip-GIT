package monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monRoadtrip.exceptions.CompteException;
import monRoadtrip.model.Client;
import monRoadtrip.model.Compte;
import monRoadtrip.model.Hote;
import monRoadtrip.model.Organisateur;
import monRoadtrip.repositories.ActiviteRepository;
import monRoadtrip.repositories.ClientRepository;
import monRoadtrip.repositories.CompteRepository;
import monRoadtrip.repositories.HoteRepository;
import monRoadtrip.repositories.LogementRepository;
import monRoadtrip.repositories.OrganisateurRepository;
import monRoadtrip.repositories.ReservationRepository;

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
