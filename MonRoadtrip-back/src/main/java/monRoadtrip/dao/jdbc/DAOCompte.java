package monRoadtrip.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import monRoadtrip.dao.IDAO;
import monRoadtrip.model.Client;
import monRoadtrip.model.Compte;
import monRoadtrip.model.Hote;
import monRoadtrip.model.Organisateur;


public class DAOCompte implements IDAO<Compte, Integer> {

	@Override
	public Compte findById(Integer id) {
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id_compte=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("client")) 
				{
					c = new Client(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("password"),LocalDate.parse(rs.getString("date_naissance")));

	
				}
				else if (rs.getString("type_compte").equals("Organisateur"))
				{
					c = new Organisateur(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("password"),LocalDate.parse(rs.getString("date_naissance")));
					
				}
				else if (rs.getString("type_compte").equals("Hote"))
				{
					c = new Hote(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("password"),LocalDate.parse(rs.getString("date_naissance")));
					
				}
			}
			

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Compte> findAll() {
		Compte c = null;
		List<Compte> comptes = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				if(rs.getString("type_compte").equals("client")) 
				{
					c = new Client(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("password"),LocalDate.parse(rs.getString("date_naissance")));

				}
				else if (rs.getString("type_compte").equals("Organisateur"))
				{
					c = new Organisateur(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("password"),LocalDate.parse(rs.getString("date_naissance")));
					
				}
				else if (rs.getString("type_compte").equals("Hote"))
				{
					c = new Hote(rs.getInt("id_compte"),rs.getString("nom"),rs.getString("prenom"),rs.getString("mail"),rs.getString("password"),LocalDate.parse(rs.getString("date_naissance")));
					
				}
				comptes.add(c);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comptes;	}

	@Override
	public Compte insert(Compte c) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);

			if (c instanceof Hote) {
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (mail, password, nom, prenom, date_naissance, type_compte) VALUES (?,?,?,?,?,?)");
				ps.setString(1, c.getMail());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setString(5, c.getDateNaissance().toString());
				ps.setString(6, "Hote");

				ps.executeUpdate();

				ps.close();
				
			} else if (c instanceof Organisateur) {				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (mail, password, nom, prenom, date_naissance, type_compte) VALUES (?,?,?,?,?,?)");
				ps.setString(1, c.getMail());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setString(5, c.getDateNaissance().toString());
				ps.setString(6, "Organisateur");

				ps.executeUpdate();

				ps.close();
				
			} else if (c instanceof Client) {				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (mail, password, nom, prenom, date_naissance, type_compte) VALUES (?,?,?,?,?,?)");
				ps.setString(1, c.getMail());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setString(5, c.getDateNaissance().toString());
				ps.setString(6, "Client");

				ps.executeUpdate();

				ps.close();
			}
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void update(Compte c) {

		
	}

	@Override
	public void delete(Integer id) {

		
	}
	
	public Compte seConnecter(String login, String password) {
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd, loginBdd, passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where mail=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("type_compte").equals("client")) {
					c = new Client(rs.getString("nom"),rs.getString("prenom"), rs.getString("mail"), rs.getString("password"), LocalDate.parse(rs.getString("date_naissance")));
				} else if (rs.getString("type_compte").equals("hote")) {
					c = new Hote(rs.getString("nom"),rs.getString("prenom"), rs.getString("mail"), rs.getString("password"), LocalDate.parse(rs.getString("date_naissance")));
				} else if (rs.getString("type_compte").equals("organisateur")) {
					c = new Organisateur(rs.getString("nom"),rs.getString("prenom"), rs.getString("mail"), rs.getString("password"), LocalDate.parse(rs.getString("date_naissance")));
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
