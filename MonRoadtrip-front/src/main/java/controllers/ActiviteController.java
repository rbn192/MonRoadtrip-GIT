package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import monRoadtrip.model.Activite;
import monRoadtrip.model.Adresse;
import monRoadtrip.model.Compte;
import monRoadtrip.model.Organisateur;
import util.Context;

@WebServlet("/gestionActivite")
public class ActiviteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//findAll
		if(request.getParameter("id")==null) 
		{
			List<Activite> activites = Context.getSingleton().getDaoActivite().findAll();

			request.setAttribute("activites", activites);
			
			getServletContext().getRequestDispatcher("/gestionActivite.jsp").forward(request, response);
		}

		//findById
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Activite a = Context.getSingleton().getDaoActivite().findById(id);
			request.setAttribute("activite", a);
			getServletContext().getRequestDispatcher("/updateActivite.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("tache").equals("insert")) 
		{

			Compte connected =(Compte) request.getSession().getAttribute("connected");

			Organisateur organisateur = (Organisateur) Context.getSingleton().getDaoCompte().findById(connected.getId());

			Adresse adresse = new Adresse(request.getParameter("numero"),request.getParameter("voie"),request.getParameter("cp"),request.getParameter("ville"));

			Activite activite = new Activite(LocalDate.parse(request.getParameter("date")),LocalTime.parse(request.getParameter("heure")),Double.parseDouble(request.getParameter("prix")),adresse,request.getParameter("categorie"),Integer.parseInt(request.getParameter("nbPlaces")),organisateur);

			Context.getSingleton().getDaoActivite().save(activite);
			response.sendRedirect("gestionActivite");

		}

		else if(request.getParameter("tache").equals("update")) 

		{
			int id = Integer.parseInt(request.getParameter("id"));

			Organisateur organisateur = (Organisateur) Context.getSingleton().getDaoCompte().findById(3);
			Adresse adresse = new Adresse(request.getParameter("numero"),request.getParameter("voie"),request.getParameter("cp"),request.getParameter("ville"));

			Activite activite = new Activite(id,LocalDate.parse(request.getParameter("date")),LocalTime.parse(request.getParameter("heure")),Double.parseDouble(request.getParameter("prix")),adresse,request.getParameter("categorie"),Integer.parseInt(request.getParameter("nbPlaces")),organisateur);

			Context.getSingleton().getDaoActivite().save(activite);
			response.sendRedirect("gestionActivite");

		}

		else if(request.getParameter("tache").equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Context.getSingleton().getDaoActivite().delete(id);
			response.sendRedirect("gestionActivite");
		}


	}
}

