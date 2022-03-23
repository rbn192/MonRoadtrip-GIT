package monRoadtrip.dao;

import java.util.List;

import monRoadtrip.model.Activite;


public interface IDAOActivite extends IDAO<Activite,Integer>{

	public List<Activite> findAllDisponibles();


}
