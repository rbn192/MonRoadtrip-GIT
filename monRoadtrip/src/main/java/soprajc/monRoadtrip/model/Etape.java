package soprajc.monRoadtrip.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Etape {

	@JsonView(JsonViews.Common.class)
	private int duree;
	@JsonView(JsonViews.Common.class)
	private LocalDate date;
	@JsonView(JsonViews.Common.class)
	private String ville;
	
	@OneToMany
	@JoinTable(
			name="activite_etape",
			joinColumns = @JoinColumn(name="etape"),
			inverseJoinColumns = @JoinColumn(name="activite")
			)
	private List<Activite> activites;
	
	@ManyToOne
	@JoinColumn(name = "id_logement")
	@JsonView(JsonViews.Common.class)
	private Logement logement;
	
	@ManyToOne
	@JoinColumn(name="id_reservation_fk")
	private Reservation reservation;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@Version
	private int version;
	
	public Etape() {}
	
	public Etape(Integer id, int duree, LocalDate date, List<Activite> activites, Logement logement, Reservation reservation, String ville) {
		this.id=id;
		this.duree = duree;
		this.date = date;
		this.activites = activites; //obligatoire dans le constructeur ? 0 � * activite
		this.logement = logement;
		this.reservation = reservation;
		this.ville=ville;
	}
	
	public Etape(int duree, LocalDate date, List<Activite> activites, Logement logement, Reservation reservation, String ville) {
		this.duree = duree;
		this.date = date;
		this.activites = activites; //obligatoire dans le constructeur ? 0 � * activite
		this.logement = logement;
		this.reservation = reservation;
		this.ville=ville;
	}

	public int getDuree() {
		return duree;
	}

	public LocalDate getDate() {
		return date;
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public Logement getLogement() {
		return logement;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Etape [id=" + id + ", duree=" + duree + ", date=" + date + ", activites=" + activites + ", logement="
				+ logement + ", ville=" + ville+ "]";
	}
	
	
	
	
	
}
