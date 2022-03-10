package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.IDAO;
import model.Activite;
import model.Adresse;

public class DAOActivite implements IDAO<Activite, Integer> {

	@Override
	public Activite findById(Integer id) {

		Activite a = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/monRoadTrip","root","");
			PreparedStatement ps = conn.prepareStatement("SELECT * from activite where id_activite = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("cp"),rs.getString("ville"));
				//definir une Adresse
				//definir un Organisateur
				a = new Activite(id,LocalDate.parse(rs.getString("date")),LocalTime.parse(rs.getString("heure")),rs.getDouble("prix"), adresse, "Musee", 3, 1, null);


			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public List<Activite> findAll() {

		return null;
	}

	@Override
	public Activite insert(Activite a) {

		return null;
	}

	@Override
	public void update(Activite a) {

		
	}

	@Override
	public void delete(Integer id) {

		
	}

}
