package monRoadtrip.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqCompteJPA",sequenceName = "seqCompte")
public abstract class Compte {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqCompteJPA")
	@GeneratedValue(strategy = GenerationType.TABLE)
    protected Integer id;

    protected String nom;
    protected String prenom;
	protected String mail;
    protected String password;
    @Column(name="date_naissance")
    protected LocalDate dateNaissance;
    
    @Version
    protected int version;
    
    public Compte() {
	}
    
	public Compte(Integer id,String nom, String prenom, String mail, String password, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.id=id;
		this.dateNaissance = dateNaissance;
	}
	
	public Compte(String nom, String prenom, String mail, String password, LocalDate dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
		this.dateNaissance = dateNaissance;
	}
			
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	

    

}
