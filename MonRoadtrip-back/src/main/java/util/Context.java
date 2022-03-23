package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import monRoadtrip.dao.IDAOActivite;
import monRoadtrip.dao.IDAOCompte;
import monRoadtrip.dao.IDAOEtape;
import monRoadtrip.dao.IDAOLogement;
import monRoadtrip.dao.IDAOParticipant;
import monRoadtrip.dao.IDAOReservation;
import monRoadtrip.dao.IDAORoadtrip;
import monRoadtrip.dao.jpa.DAOActivite;
import monRoadtrip.dao.jpa.DAOCompte;
import monRoadtrip.dao.jpa.DAOEtape;
import monRoadtrip.dao.jpa.DAOLogement;
import monRoadtrip.dao.jpa.DAOParticipant;
import monRoadtrip.dao.jpa.DAOReservation;
import monRoadtrip.dao.jpa.DAORoadtrip;


public class Context {
	
private EntityManagerFactory emf  = Persistence.createEntityManagerFactory("monroadtripUnit");

private static Context _singleton=null;	

private IDAOCompte daoCompte = new DAOCompte();
private IDAOActivite daoActivite = new DAOActivite();
private IDAOEtape daoEtape = new DAOEtape();
private IDAOReservation daoReservation = new DAOReservation();
private IDAOParticipant daoParticipant = new DAOParticipant();
private IDAOLogement daoLogement = new DAOLogement();
private IDAORoadtrip daoRoadtrip = new DAORoadtrip();




//Obligatoire
private Context() {}

//Obligatoire
public static Context getSingleton() 
{
	if(_singleton==null) 
	{
		_singleton=new Context();
	}
	
	return _singleton;
}




public IDAOCompte getDaoCompte() {
	return daoCompte;
}

public void setDaoCompte(IDAOCompte daoCompte) {
	this.daoCompte = daoCompte;
}

public IDAOActivite getDaoActivite() {
	return daoActivite;
}

public void setDaoActivite(IDAOActivite daoActivite) {
	this.daoActivite = daoActivite;
}

public IDAOEtape getDaoEtape() {
	return daoEtape;
}

public void setDaoEtape(IDAOEtape daoEtape) {
	this.daoEtape = daoEtape;
}

public IDAOReservation getDaoReservation() {
	return daoReservation;
}

public void setDaoReservation(IDAOReservation daoReservation) {
	this.daoReservation = daoReservation;
}

public IDAOParticipant getDaoParticipant() {
	return daoParticipant;
}

public void setDaoParticipant(IDAOParticipant daoParticipant) {
	this.daoParticipant = daoParticipant;
}

public IDAOLogement getDaoLogement() {
	return daoLogement;
}

public void setDaoLogement(IDAOLogement daoLogement) {
	this.daoLogement = daoLogement;
}

public IDAORoadtrip getDaoRoadtrip() {
	return daoRoadtrip;
}

public void setDaoRoadtrip(IDAORoadtrip daoRoadtrip) {
	this.daoRoadtrip = daoRoadtrip;
}

public EntityManagerFactory getEmf() {
	return emf;
}

public void close() {emf.close();}


	

}
