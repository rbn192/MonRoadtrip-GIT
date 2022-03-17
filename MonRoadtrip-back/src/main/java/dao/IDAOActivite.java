package dao;

import java.util.List;

import model.Activite;


public interface IDAOActivite extends IDAO<Activite,Integer>{

	public List<Activite> findAllDisponibles();


}
