package monRoadtrip.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@PrimaryKeyJoinColumn(name="id_compte_fk")
public class Client extends Compte {
	
    private double solde;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Carte','Paypal')", name="type_de_paiement")
    private TypeDePaiement typeDePaiement;
	
	@OneToMany (mappedBy = "client")
	private List<Reservation> reservations;
    
	public Client() {
		
	}
	
	public Client(String nom, String prenom, String mail, String password, LocalDate dateNaissance, List<Reservation> reservations, double solde,
			TypeDePaiement typeDePaiement) {
		super(nom, prenom, mail, password, dateNaissance);
		this.reservations = reservations;
		this.solde = solde;
		this.typeDePaiement = typeDePaiement;
	}
	
	public Client(Integer id, String nom, String prenom, String mail, String password, LocalDate dateNaissance, List<Reservation> reservations, double solde,
			TypeDePaiement typeDePaiement) {
		super(id, nom, prenom, mail, password, dateNaissance);
		this.reservations = reservations;
		this.solde = solde;
		this.typeDePaiement = typeDePaiement;
	}
	
	public Client(String nom, String prenom, String mail, String password, LocalDate dateNaissance) {
		super(nom, prenom, mail, password, dateNaissance);
	}
	
	public Client(Integer id, String nom, String prenom, String mail, String password, LocalDate dateNaissance) {
		super(id, nom, prenom, mail, password, dateNaissance);
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public double getSolde() {
		return solde;
	}

	public TypeDePaiement getTypeDePaiement() {
		return typeDePaiement;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public void setTypeDePaiement(TypeDePaiement typeDePaiement) {
		this.typeDePaiement = typeDePaiement;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", password=" + password + ", id=" + id
				+ ", dateNaissance=" + dateNaissance + ", solde=" + solde
				+ ", typeDePaiement=" + typeDePaiement + "]";
	}

	    
}
