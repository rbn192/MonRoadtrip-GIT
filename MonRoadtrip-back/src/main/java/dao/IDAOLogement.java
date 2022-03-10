package dao;

import java.util.List;

import model.Logement;

public interface IDAOLogement extends IDAO<Logement,Integer>{

	public List<Logement> findAllDisponibles();	
}
