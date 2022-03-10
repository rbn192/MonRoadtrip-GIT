package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOLogement;
import model.Activite;
import model.Logement;
import util.Context;


public class DAOLogement implements IDAOLogement{

	@Override
	public Logement findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Logement l = em.find(Logement.class, id);
		em.close();
		return l;
	}

	@Override
	public List<Logement> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Logement> logements = em.createQuery("SELECT l from Logement l").getResultList();
		em.close();
		return logements;
	}

	@Override
	public Logement save(Logement l) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		l = em.merge(l);
		em.getTransaction().commit();
		em.close();
		return l;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Logement l = em.find(Logement.class, id);
		em.remove(l);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public List<Logement> findAllDisponibles() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Logement> logements = em.createQuery("SELECT l from Logement l WHERE l.date > now() ").getResultList();
		em.close();
		return logements;
	}

	

}
