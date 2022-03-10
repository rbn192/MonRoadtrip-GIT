package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOEtape;
import model.Etape;
import util.Context;


public class DAOEtape implements IDAOEtape {

	@Override
	public Etape findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Etape e = em.find(Etape.class, id);
		em.close();
		return e;
	}

	@Override
	public List<Etape> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Etape> etapes = em.createQuery("SELECT e from Etape e").getResultList();
		em.close();
		return etapes;
	}

	@Override
	public Etape save(Etape e) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		e = em.merge(e);
		em.getTransaction().commit();
		em.close();
		return e;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Etape e = em.find(Etape.class, id);
		em.remove(e);
		em.getTransaction().commit();
		em.close();	
	}


}
