package soprajc.monRoadtrip;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import soprajc.monRoadtrip.model.Activite;
import soprajc.monRoadtrip.model.Adresse;
import soprajc.monRoadtrip.model.Categorie;
import soprajc.monRoadtrip.model.Organisateur;
import soprajc.monRoadtrip.services.ActiviteService;
import soprajc.monRoadtrip.services.CompteService;

@SpringBootTest
class ActiviteRepoTest {

	@Autowired
	ActiviteService activiteService;	
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	
	@Test
	@Transactional
	@Commit
//	@Disabled
	void creationActiviteTest() {		
		
		Organisateur o2 = new Organisateur("Guitton","Lucie","lucie@orga.com",passwordEncoder.encode("123"), LocalDate.of(1997, 7, 5));
		compteService.save(o2);
		
		Adresse adresse = new Adresse("Parc des Chantiers", "bd Léon Bureau", "44002", "Nantes");
		Activite a = new Activite(LocalDate.of(2022, 9, 2), LocalTime.of(14, 30), 30, adresse, Categorie.Insolite, 10, o2, "Visite des Machines de l'île");
		activiteService.save(a);
		
		Adresse adresse2 = new Adresse("19", "rue de la Juiverie", "44000", "Nantes");
		Activite a2 = new Activite(LocalDate.of(2022, 8, 28), LocalTime.of(20, 0), 20, adresse2, Categorie.Restaurant, 4, o2, "Le renard et la galette");
		activiteService.save(a2);
		
		Organisateur o3 = new Organisateur("Sati","Chaymae","chaymae@orga.com",passwordEncoder.encode("123"), LocalDate.of(1997, 7, 5));
		compteService.save(o3);
		
		Adresse adresse3 = new Adresse("", "avenue Jean Gonord", "31500", "Toulouse");
		Activite a3 = new Activite(LocalDate.of(2022, 9, 5), LocalTime.of(10, 30), 25, adresse3, Categorie.Insolite, 40, o3, "Visite de la Cité de l'espace");
		activiteService.save(a3);
		
		Adresse adresse4 = new Adresse("", "Place Saint Pierre", "31500", "Toulouse");
		Activite a4 = new Activite(LocalDate.of(2022, 8, 6), LocalTime.of(9, 0), 0, adresse4, Categorie.Randonnée, 10, o3, "Berge de la Garonne et Amidonniers");
		activiteService.save(a4);
		
		
	}
	
	
	
	
	
	

}