package monRoadtrip.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_reservation")
	private LocalDate dateReservation;
	
	@Enumerated(EnumType.STRING)
	private Statut statut;
	
	@ManyToOne
	@JoinColumn(name="id_participant_fk")
	private Participant participant;
	
	@OneToMany(mappedBy = "reservation")
	private List<Etape> etapes;
	
	@ManyToOne
	@JoinColumn(name="id_roadtrip_fk")
	private Roadtrip roadTrip;
	
	@ManyToOne
	@JoinColumn(name="id_client_fk")
	private Client client;

	public Reservation() {}
	
	public Reservation(LocalDate dateReservation, Statut statut, Participant participant, Roadtrip roadTrip, Client client) {
		this.dateReservation = dateReservation;
		this.statut = statut;
		this.participant = participant;
		this.roadTrip = roadTrip;
		this.client = client;
	}
	
	public Reservation(Integer id, LocalDate dateReservation, Statut statut, Participant participant, List<Etape> etapes,
			Roadtrip roadTrip, Client client) {
		this.dateReservation = dateReservation;
		this.statut = statut;
		this.participant = participant;
		this.roadTrip = roadTrip;
		this.client = client;
		this.id=id;
		this.etapes=etapes;
	}
	
	public Reservation(LocalDate dateReservation, Statut statut, Participant participant, List<Etape> etapes,
			Roadtrip roadTrip, Client client) {
		this.dateReservation = dateReservation;
		this.statut = statut;
		this.participant = participant;
		this.roadTrip = roadTrip;
		this.client = client;
		this.etapes=etapes;
	}

	public LocalDate getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}
	

	public Statut getStatut() {
		return statut;
	}

	public Participant getParticipant() {
		return participant;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public Roadtrip getRoadTrip() {
		return roadTrip;
	}

	public Client getClient() {
		return client;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}

	public void setRoadTrip(Roadtrip roadTrip) {
		this.roadTrip = roadTrip;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateReservation=" + dateReservation + ", statut=" + statut + ", participant=" + participant
				+ ", etapes=" + etapes + ", client=" + client + "]";
	}


	
	

}
