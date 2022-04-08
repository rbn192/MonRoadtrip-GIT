package soprajc.monRoadtrip.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Activite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	@Future
	private LocalDate date;
	@JsonView(JsonViews.Common.class)
	private LocalTime heure;
	@JsonView(JsonViews.Common.class)
	private double prix;
	@JsonView(JsonViews.Common.class)
	@Embedded
	private Adresse adresse;
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Musée','Concert','Randonnée','Monument','Restaurant', 'Insolite')")
	private Categorie categorie;
	@JsonView(JsonViews.Common.class)
	@Column(name = "nb_places")
	private int nbPlaces;
	private int note; //1-10

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn(name="id_organisateur_fk")
	private Organisateur organisateur;
	
	@JsonView(JsonViews.Common.class)
	private String intitule;

	@Version
	private int version;

	public Activite(@Future LocalDate date, LocalTime heure, double prix, Adresse adresse, Categorie categorie,
			int nbPlaces, Organisateur organisateur, String intitule) {
		this.date = date;
		this.heure = heure;
		this.prix = prix;
		this.adresse = adresse;
		this.categorie = categorie;
		this.nbPlaces = nbPlaces;
		this.organisateur = organisateur;
		this.intitule = intitule;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Activite() {
	}

	public Activite(LocalDate date, LocalTime heure, double prix, Adresse adresse, Categorie categorie, int nbPlaces, int note,
			Organisateur organisateur) {
		this.date = date;
		this.heure = heure;
		this.prix = prix;
		this.adresse = adresse;
		this.categorie = categorie;
		this.nbPlaces = nbPlaces;
		this.note = note;
		this.organisateur = organisateur;
	}


	public Activite(Integer id, LocalDate date, LocalTime heure, double prix, Adresse adresse, Categorie categorie,
			int nbPlaces, int note, Organisateur organisateur) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.prix = prix;
		this.adresse = adresse;
		this.categorie = categorie;
		this.nbPlaces = nbPlaces;
		this.note = note;
		this.organisateur = organisateur;
	}

	public Activite(LocalDate date, LocalTime heure, double prix, Adresse adresse, Categorie categorie, int nbPlaces,
			Organisateur organisateur) {
		this.date = date;
		this.heure = heure;
		this.prix = prix;
		this.adresse = adresse;
		this.categorie = categorie;
		this.nbPlaces = nbPlaces;
		this.organisateur = organisateur;
	}


	public Activite(Integer id, LocalDate date, LocalTime heure, double prix, Adresse adresse, Categorie categorie,
			int nbPlaces, Organisateur organisateur) {
		this.id = id;
		this.date = date;
		this.heure = heure;
		this.prix = prix;
		this.adresse = adresse;
		this.categorie = categorie;
		this.nbPlaces = nbPlaces;
		this.organisateur = organisateur;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}
	public LocalTime getHeure() {
		return heure;
	}
	public double getPrix() {
		return prix;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public int getNote() {
		return note;
	}
	public Organisateur getOrganisateur() {
		return organisateur;
	}	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public void setOrganisateur(Organisateur organisateur) {
		this.organisateur = organisateur;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", date=" + date + ", heure=" + heure + ", prix=" + prix + ", adresse=" + adresse
				+ ", categorie=" + categorie + ", nbPlaces=" + nbPlaces + ", note=" + note + ", organisateur="
				+ organisateur + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activite other = (Activite) obj;
		return Objects.equals(id, other.id);
	}

}
