package com.mailsign.presentation;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mailsign.entities.Email;
import com.mailsign.entities.Utilisateur;
import com.sendmail.util.SendMail;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final SendMail mail = new SendMail();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("\n servlet send mail");

            Email email = new Email();
            HttpSession httpSession = request.getSession();
            Utilisateur user = (Utilisateur) httpSession.getAttribute("name");
            System.out.println("\n user info ::  from: "+user.getEmail());
            email.setFrom(user.getEmail());
            email.setMessage(request.getParameter("message"));
            email.setTo(request.getParameter("to"));
            email.setSubject(request.getParameter("subject"));
            email.setCreatedAt(new Date());
            System.out.println("\n email info ::  from: "+email.getFrom()+"\t to: "+email.getTo()+"\t subject: "+email.getSubject()+"\t msg : "+email.getMessage());


            mail.send(email,user);
            response.sendRedirect(getServletContext().getContextPath());
        }catch (Exception e){
            response.sendRedirect(getServletContext().getContextPath()+"/mail?message="+e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
