package Servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SchoolMemberModel;

@WebServlet("/ServletStagiairesDuProf")
public class ServletStagiairesDuProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletStagiairesDuProf() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		SchoolMemberModel user = (SchoolMemberModel) sc.getAttribute("UserMember");
		request.setAttribute("u",user);	  
    	try {
    		SchoolMemberModel sm = new SchoolMemberModel(); 
    		request.setAttribute("sm", sm.listOfProfStudent(user.getUsn()));
    		
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/listeDesStagiairesDuProfs.jsp").forward(request, response);		
    	}catch (Exception e) {
			e.printStackTrace();
		}    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
