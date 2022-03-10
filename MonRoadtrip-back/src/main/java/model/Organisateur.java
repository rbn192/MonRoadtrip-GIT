package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Organisateur extends Compte {
	
	@OneToMany
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

	@Override
	public String toString() {
		return "Organisateur [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", password=" + password
				+ ", id=" + id + ", dateNaissance=" + dateNaissance + ", activites=" + activites + "]";
	}

	
}
