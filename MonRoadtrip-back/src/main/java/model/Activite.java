package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Activite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	private double prix;
	@Embedded
	private Adresse adresse;
	private String categorie;
	@Column(name = "nb_places")
	private int nbPlaces;
	private int note; //1-10

	@ManyToOne
	@JoinColumn(name="id_organisateur_fk")
	private Organisateur organisateur;

	// étape ?

	public Activite() {
	}

	public Activite(LocalDate date, LocalTime heure, double prix, Adresse adresse, String categorie, int nbPlaces, int note,
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


	public Activite(Integer id, LocalDate date, LocalTime heure, double prix, Adresse adresse, String categorie,
			int nbPlaces, int note, Organisateur organisateur) {
		super();
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
	public String getCategorie() {
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
	public void setCategorie(String categorie) {
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

	@Override
	public String toString() {
		return "Activite [id=" + id + ", date=" + date + ", heure=" + heure + ", prix=" + prix + ", adresse=" + adresse
				+ ", categorie=" + categorie + ", nbPlaces=" + nbPlaces + ", note=" + note + ", organisateur="
				+ organisateur + "]";
	}



}
