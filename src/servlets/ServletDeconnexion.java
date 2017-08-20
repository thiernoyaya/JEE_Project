package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletDeconnexion")
public class ServletDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDeconnexion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();
        
        //suppréssion des élements du context de l'application
        ServletContext ss = getServletContext();
		ss.removeAttribute("UserStudent"); 
		ss.removeAttribute("UserMember");
		
        /* Redirection vers la page d'acceuille ! */	
        this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
