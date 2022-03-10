package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import model.Adresse;
import model.Hote;
import model.Logement;


public class DAOLogement implements IDAO<Logement, Integer> {

	DAOCompte daoCompte = new DAOCompte();
	
	@Override
	public Logement findById(Integer id) {

		Logement l = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from logement where numero=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Adresse a = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("cp"), rs.getString("ville"));
				Hote h = (Hote)daoCompte.findById(rs.getInt("id_hote_fk"));
				
				l = new Logement(id, LocalDate.parse(rs.getString("date")), rs.getDouble("prix"), a, rs.getInt("nb_places"), rs.getInt("note"), h);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Logement> findAll() {

		List<Logement> logements = new ArrayList();
		
		//� compl�ter
		
		return logements;
	}

	@Override
	public Logement insert(Logement l) {

		return null;
	}

	@Override
	public void update(Logement l) {

		
	}

	@Override
	public void delete(Integer id) {

		
	}

}
