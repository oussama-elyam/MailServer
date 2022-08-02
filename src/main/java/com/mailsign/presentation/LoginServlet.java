package com.mailsign.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mailsign.dao.imp.UtilisateurDao;
import com.mailsign.entities.Utilisateur;
import com.mailsign.service.inter.IUtilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		IUtilisateur service = new UtilisateurDao();
		RequestDispatcher rd = null;
		String passcry;
		passcry = service.findOne(email,password);
		System.out.print("pass in db : "+passcry);

		 if(passcry == null) {
				request.setAttribute("status", "failed");
				rd = request.getRequestDispatcher("login.jsp");
				System.out.print("login not done");
			}
		
		else  {
			HttpSession session = request.getSession();
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setEmail(email);
			utilisateur.setPassword(passcry);
			session.setAttribute("name", utilisateur);
			rd = request.getRequestDispatcher("index.jsp");

			System.out.print("\n login done");
		}
		rd.forward(request,response);
	}

}
