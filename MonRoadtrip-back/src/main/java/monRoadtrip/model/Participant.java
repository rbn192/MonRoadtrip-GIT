package monRoadtrip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participant {

	private String nom;
	private String prenom;
	private int age;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	public Participant() {
		
	}
	
	public Participant(Integer id, String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.id=id;
	}
	
	public Participant(String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getAge() {
		return age;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	

}
