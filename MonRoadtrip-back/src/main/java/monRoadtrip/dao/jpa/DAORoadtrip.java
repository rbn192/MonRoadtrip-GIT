package monRoadtrip.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import monRoadtrip.dao.IDAORoadtrip;
import monRoadtrip.model.Compte;
import monRoadtrip.model.Roadtrip;
import util.Context;

public class DAORoadtrip implements IDAORoadtrip {

	@Override
	public Roadtrip findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Roadtrip r = em.find(Roadtrip.class, id);
		em.close();
		return r;
	}

	@Override
	public List<Roadtrip> findAll() {
		EntityManager em = Context.getSingleton().getEmf().createEntityManager();
		List<Roadtrip> roadtrips = em.createQuery("SELECT r from Roadtrip r").getResultList();
		em.close();
		return roadtrips;
	}

	@Override
	public Roadtrip save(Roadtrip r) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		r = em.merge(r);
		em.getTransaction().commit();
		em.close();
		return r;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Roadtrip r = em.find(Roadtrip.class, id);
		em.remove(r);
		em.getTransaction().commit();
		em.close();	
		
	}

}
