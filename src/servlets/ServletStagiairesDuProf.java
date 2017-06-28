package Servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SchoolMemberModel;

/**
 * Servlet implementation class ServletStagiairesDuProf
 */
@WebServlet("/ServletStagiairesDuProf")
public class ServletStagiairesDuProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStagiairesDuProf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation du user par le contexte de l'application
		  ServletContext sc = getServletContext();
		  SchoolMemberModel user = (SchoolMemberModel) sc.getAttribute("UserMember");
		  request.setAttribute("u",user);
	  
	    	try {				    	     
	    	     // recuperation de la liste des étudiants du professeurs
	    		SchoolMemberModel sm = SchoolMemberModel.listeDesEtudiant(user.getUsn());
	    		// transmission de la liste à la jsp
	    		request.setAttribute("sm", sm);
	    		
				this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/listeDesStagiairesDuProfs.jsp").forward(request, response);		
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
