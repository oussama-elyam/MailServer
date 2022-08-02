package com.mailsign.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mailsign.dao.imp.UtilisateurDao;
import com.mailsign.entities.Utilisateur;
import com.mailsign.service.inter.IUtilisateur;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//PrintWriter out = response.getWriter();
	//out.print("Working");
		String nom = request.getParameter("name");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		Utilisateur user = new Utilisateur(nom,prenom, email, password);
		IUtilisateur service = new UtilisateurDao();
		RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");

		if(service.add(user)==1) {
			request.setAttribute("status", "success");
			System.out.print("done");
		}
		else {
			request.setAttribute("status", "failed");
			System.out.print("not done");
		}
		rd.forward(request,response);
	}

}
