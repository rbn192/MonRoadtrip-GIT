package soprajc.monRoadtrip.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Organisateur extends Compte {
	
	@OneToMany(mappedBy="organisateur")
	@JsonView(JsonViews.OrganisateurWithActivites.class)
	private List<Activite> activites;
	
	public Organisateur() {
	}

	public Organisateur(Integer id, String nom, String prenom, String mail, String password, LocalDate dateNaissance) {
		super(id, nom, prenom, mail, password, dateNaissance);
	}
	
	public Organisateur(String nom, String prenom, String mail, String password, LocalDate dateNaissance) {
		super(nom, prenom, mail, password, dateNaissance);
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	
}
