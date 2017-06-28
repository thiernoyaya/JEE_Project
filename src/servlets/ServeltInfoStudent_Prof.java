package Servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SchoolMemberModel;

/**
 * Servlet implementation class ServeltInfoStudent_Prof
 */
@WebServlet("/ServeltInfoStudent_Prof")
public class ServeltInfoStudent_Prof extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeltInfoStudent_Prof() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// pour les superviseur
			Set<SchoolMemberModel> listOfSpv = SchoolMemberModel.listOfSchoolMember(true);
			request.setAttribute("listSpv", listOfSpv);
			
			//pour la coordinatrice
			Set<SchoolMemberModel> listOfCoord = SchoolMemberModel.listOfSchoolMember(false);
			request.setAttribute("listCoord", listOfCoord);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/InfoStudent&ProfSuperviseur.jsp").forward(request, response);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
