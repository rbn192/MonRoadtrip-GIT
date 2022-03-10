package dao;

import java.util.List;

import model.Activite;


public interface IDAOActivite extends IDAO<Activite,Integer>{

	List<Activite> findAllDisponibles();


}
