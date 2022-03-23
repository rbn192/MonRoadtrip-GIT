package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Activite;
import model.Adresse;
import model.Client;
import model.Compte;
import model.Hote;
import model.Logement;
import util.Context;

@WebServlet("/gestionLogement")
public class LogementController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("bjr");
		//findAll
		if(request.getParameter("id")==null) 
		{
			List<Logement> logements = Context.getSingleton().getDaoLogement().findAll();

			request.setAttribute("logements", logements);
			for(Logement l : logements) {
				System.out.println(l.getPrix());
			}
			getServletContext().getRequestDispatcher("/gestionLogement.jsp").forward(request, response);
		}

		//findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Logement l = Context.getSingleton().getDaoLogement().findById(id);
			request.setAttribute("logement", l);
			getServletContext().getRequestDispatcher("/updateLogement.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("tache").equals("insert")) 
		{


			//Compte connected =(Compte) request.getSession().getAttribute("connected");

			//Hote hote = (Hote) Context.getSingleton().getDaoCompte().findById(connected.getId());

			Hote hote = (Hote) Context.getSingleton().getDaoCompte().findById(2);
			Adresse adresse = new Adresse(request.getParameter("numero"),request.getParameter("voie"),request.getParameter("cp"),request.getParameter("ville"));

			Logement logement = new Logement(LocalDate.parse(request.getParameter("date")),Double.parseDouble(request.getParameter("prix")),adresse,Integer.parseInt(request.getParameter("nbPlaces")),hote);




			Context.getSingleton().getDaoLogement().save(logement);
			response.sendRedirect("gestionLogement");

		}

		else if(request.getParameter("tache").equals("update")) 

		{
			System.out.println("update test");
			int id = Integer.parseInt(request.getParameter("id"));
			//int version = Integer.parseInt(request.getParameter("version"));

			Hote hote = (Hote) Context.getSingleton().getDaoCompte().findById(2);

			Adresse adresse = new Adresse(request.getParameter("numero"),request.getParameter("voie"),request.getParameter("cp"),request.getParameter("ville"));

			Logement logement = new Logement(id,LocalDate.parse(request.getParameter("date")),Double.parseDouble(request.getParameter("prix")),adresse,Integer.parseInt(request.getParameter("nbPlaces")),hote);
			//logement.setVersion(version);
			Context.getSingleton().getDaoLogement().save(logement);

			System.out.println(logement);
			System.out.println(id);


			response.sendRedirect("gestionLogement");
		}

		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoLogement().delete(id);
			response.sendRedirect("gestionLogement");
		}


	}
}

