package monRoadtrip.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import monRoadtrip.dao.IDAOParticipant;
import monRoadtrip.model.Participant;
import util.Context;

public class DAOParticipant implements IDAOParticipant {

	@Override
	public Participant findById(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		Participant p = em.find(Participant.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Participant> findAll() {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		List<Participant> Participants = em.createQuery("SELECT p from Participant p").getResultList();
		em.close();
		return Participants;
	}

	@Override
	public Participant save(Participant p) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		p = em.merge(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em  = Context.getSingleton().getEmf().createEntityManager();
		em.getTransaction().begin();
		Participant p = em.find(Participant.class, id);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}


}
