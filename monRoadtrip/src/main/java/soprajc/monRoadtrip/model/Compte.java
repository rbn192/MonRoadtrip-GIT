package soprajc.monRoadtrip.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seqCompteJPA",sequenceName = "seqCompte")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({
	@Type(value=Client.class,name="client"),
	@Type(value=Hote.class,name="Hote"),
	@Type(value=Organisateur.class,name="Organisateur")
})
public abstract class Compte implements UserDetails{

	@JsonView(JsonViews.Common.class)
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqCompteJPA")
	@GeneratedValue(strategy = GenerationType.TABLE)
    protected Integer id;

	@JsonView(JsonViews.Common.class)
    protected String nom;
	@JsonView(JsonViews.Common.class)
	protected String prenom;
    @NotEmpty
	@Column(name = "mail", nullable = false, unique = true, length = 200)	
	@JsonView(JsonViews.Common.class)
    protected String mail;
    @NotEmpty
	@Column(name = "password", nullable = false, length = 255)
    protected String password;
    @Column(name="date_naissance")
    @Past
	@JsonView(JsonViews.Common.class)
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		GrantedAuthority authority = null;
		if (getClass().getSimpleName().equals("Client")) {
			authority = new SimpleGrantedAuthority("ROLE_CLIENT");
		} else if (getClass().getSimpleName().equals("Hote")) {
			authority = new SimpleGrantedAuthority("ROLE_HOTE");
		}
		else if (getClass().getSimpleName().equals("Organisateur")) {
			authority = new SimpleGrantedAuthority("ROLE_ORGANISATEUR");
		}
		return Arrays.asList(authority);
	}

	@Override
	public String getUsername() {
		return mail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

    

}
