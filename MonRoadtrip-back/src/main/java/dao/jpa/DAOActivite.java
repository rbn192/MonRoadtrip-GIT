package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.IDAOActivite;
import model.Activite;
import util.Context;


public class DAOActivite implements IDAOActivite {

	@Override
	public Activite findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Activite a = em.find(Activite.class, id);
		em.close();
		return a;
	}

	@Override
	public List<Activite> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Activite> activites = em.createQuery("SELECT a from Activite a").getResultList();
		em.close();
		return activites;
	}

	@Override
	public Activite save(Activite a) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		a = em.merge(a);
		em.getTransaction().commit();
		em.close();
		return a;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Activite a = em.find(Activite.class, id);
		em.remove(a);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public List<Activite> findAllDisponibles() {

		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Activite> activites = em.createQuery("SELECT a from Activite a WHERE a.date > now() ").getResultList();
		em.close();
		return activites;

	}

}
