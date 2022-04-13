package soprajc.monRoadtrip.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
import javax.persistence.Version;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="date_reservation")
	private LocalDate dateReservation;
	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('En_cours','A_venir','Termine')")
	private Statut statut;
	
	@ManyToOne
	@JoinColumn(name="id_participant_fk")
	@JsonView(JsonViews.Common.class)
	private Participant participant;
	
	@OneToMany(mappedBy = "reservation")
	@JsonView(JsonViews.Common.class)

	private List<Etape> etapes;
	
	@ManyToOne
	@JoinColumn(name="id_roadtrip_fk")
	@JsonView(JsonViews.Common.class)
	private Roadtrip roadtrip;
	
	@ManyToOne
	@JoinColumn(name="id_client_fk")
	@JsonView(JsonViews.Common.class)
	private Client client;
	
	@Version
	private int version;

	public Reservation() {}
	
	public Reservation(LocalDate dateReservation, Statut statut, Participant participant, Roadtrip roadTrip, Client client) {
		this.dateReservation = dateReservation;
		this.statut = statut;
		this.participant = participant;
		this.roadtrip = roadTrip;
		this.client = client;
	}
	
	public Reservation(Integer id, LocalDate dateReservation, Statut statut, Participant participant, List<Etape> etapes,
			Roadtrip roadTrip, Client client) {
		this.dateReservation = dateReservation;
		this.statut = statut;
		this.participant = participant;
		this.roadtrip = roadTrip;
		this.client = client;
		this.id=id;
		this.etapes=etapes;
	}
	
	public Reservation(LocalDate dateReservation, Statut statut, Participant participant, List<Etape> etapes,
			Roadtrip roadTrip, Client client) {
		this.dateReservation = dateReservation;
		this.statut = statut;
		this.participant = participant;
		this.roadtrip = roadTrip;
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
		return roadtrip;
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
		this.roadtrip = roadTrip;
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
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateReservation=" + dateReservation + ", statut=" + statut + ", participant=" + participant
				+ ", etapes=" + etapes + ", client=" + client + "]";
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}

	
	

}
