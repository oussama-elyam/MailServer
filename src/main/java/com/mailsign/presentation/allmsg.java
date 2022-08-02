package com.mailsign.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mailsign.entities.Utilisateur;
import com.sendmail.util.ReceivingMail;


/**
 * Servlet implementation class allmsg
 */
@WebServlet("/allmsg")
public class allmsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReceivingMail receivingMail = new ReceivingMail();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allmsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
	       
		Utilisateur user = (Utilisateur) httpSession.getAttribute("name");
        request.setAttribute("emails",receivingMail.receiving(user));
		RequestDispatcher rd = request.getRequestDispatcher("allmessage.jsp");
		rd.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
