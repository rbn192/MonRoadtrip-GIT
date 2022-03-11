package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Activite;
import model.Adresse;
import model.Client;
import model.Etape;
import model.Hote;
import model.Logement;
import model.Organisateur;
import model.Participant;
import model.Reservation;
import model.Roadtrip;
import model.Statut;
import model.Transport;
import model.TypeDePaiement;
import util.Context;

public class Test {

	public static void main(String[] args) {
		
		Client client = new Client("Vincent","Emilie","emilie@gmail.com","password",LocalDate.parse("1997-06-13"),null,500,TypeDePaiement.Carte);
		
		client = (Client) Context.getSingleton().getDaoCompte().save(client);

		Hote hote = new Hote("Guitton","Lucie","lucie@gmail.com","password",LocalDate.parse("1997-06-16"));
		hote = (Hote) Context.getSingleton().getDaoCompte().save(hote);
		Organisateur organisateur = new Organisateur("Pierson","Robin","robin@gmail.com","password",LocalDate.parse("1997-03-18"));
		
		Adresse adresse = new Adresse("13","rue des peupliers","44000","Nantes");

		Hote hote2 = (Hote) Context.getSingleton().getDaoCompte().findById(2);
		Logement l1 = new Logement(LocalDate.now(),130,adresse,4,10,hote2);

		System.out.println(l1);
		l1 = Context.getSingleton().getDaoLogement().save(l1);
		
		
		organisateur = (Organisateur) Context.getSingleton().getDaoCompte().save(organisateur);

		Organisateur o = (Organisateur) Context.getSingleton().getDaoCompte().findById(3);
		Activite a1 = new Activite(LocalDate.now(),LocalTime.now(),25,adresse,"rando",3,8,o);
		
		a1 = Context.getSingleton().getDaoActivite().save(a1);
		
		List<Activite> activites = new ArrayList();
		activites.add(a1);
		
		Participant p1 = new Participant("Titi","Toto",12);
		p1 = Context.getSingleton().getDaoParticipant().save(p1);
		
		Roadtrip roadtrip = new Roadtrip("Paris","Toulouse",LocalDate.now(),LocalDate.parse("2022-03-18"),700.0,Transport.Train);
		roadtrip = Context.getSingleton().getDaoRoadtrip().save(roadtrip);
		
		
		Reservation resa = new Reservation(LocalDate.now(),Statut.En_cours,p1,roadtrip,client);
		
		resa = Context.getSingleton().getDaoReservation().save(resa);


		Etape etape = new Etape(3,LocalDate.now(),activites,l1,resa,"Paris");
		
		etape = Context.getSingleton().getDaoEtape().save(etape);
		List<Etape> etapes = new ArrayList();
		etapes.add(etape);
		
		
		
		
		Context.getSingleton().close();

		

	}

}
