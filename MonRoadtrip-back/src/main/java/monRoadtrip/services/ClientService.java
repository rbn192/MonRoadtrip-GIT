package monRoadtrip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import monRoadtrip.exceptions.ClientException;
import monRoadtrip.model.Client;
import monRoadtrip.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
//	@Autowired
//	ReservationRepository reservationRepository;
	
	public void create(Client c) {
		if (c.getId() != null) {
			throw new ClientException("l'id ne doit pas etre defini");
		}
		if (c.getMail() == null || c.getMail().isEmpty()) {
			throw new ClientException("le mail doit etre defini");
		}
		if (c.getPassword() == null || c.getPassword().isEmpty()) {
			throw new ClientException("le mdp doit etre defini");
		}
		clientRepository.save(c);
	}
	
	public void update(Client c) {
		if (c.getId() == null) {
			throw new ClientException("le numero doit etre defini");
		}
		if (c.getMail() == null || c.getMail().isEmpty()) {
			throw new ClientException("le mail doit etre defini");
		}
		if (c.getPassword() == null || c.getPassword().isEmpty()) {
			throw new ClientException("le mdp doit etre defini");
		}
		Client clientEnBase = getById(c.getId());
		clientEnBase.setAdresse(c.getAdresse());
		clientEnBase.setMail(c.getMail());
		clientEnBase.setTypeDePaiement(c.getTypeDePaiement());
		clientEnBase.setNom(c.getNom());
		clientEnBase.setPrenom(c.getPrenom());
		clientEnBase.setSolde(c.getSolde());
		clientRepository.save(clientEnBase);
	}
	public Client getById(Integer id) {
		return clientRepository.findById(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}
	
	public List<Client> getAll() {
		return clientRepository.findAll();
	}
	
	public Client getByNumeroWithReservation(Integer id) {
		return clientRepository.findByIdWithReservations(id).orElseThrow(() -> {
			throw new ClientException("id inconnu");
		});
	}
	
	public void delete(Client c) {

		Client clientEnBase = getById(c.getId());
		//reservationRepository.deleteByClient(clientEnBase);
		clientRepository.delete(clientEnBase);
	}

	public void deleteByNumero(Integer id) {
		Client client = new Client();
		client.setId(id);
		delete(client);
	}
}
