package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.Compte;
import model.Hote;
import model.Organisateur;
import util.Context;

@WebServlet("/connexion")
public class ConnexionController extends HttpServlet {
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
			
		Compte connected=Context.getSingleton().getDaoCompte().seConnecter(mail,password);
		
		request.getSession().setAttribute("connected", connected);
		
		if(connected instanceof Hote) {response.sendRedirect("gestionLogement");}

		else if(connected instanceof Organisateur) {response.sendRedirect("gestionActivite");}
		
		else if(connected instanceof Client) {response.sendRedirect("gestionRoadtrip.html");}

		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		}
		
		
	}

}
