package Servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SchoolMemberModel;
import Models.SchoolStudentModel;


@WebServlet("/ServletStageCoordinatrice")
public class ServletStageCoordinatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletStageCoordinatrice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			SchoolMemberModel sm = new SchoolMemberModel();
			Set<SchoolStudentModel> lisOfStudent =  sm.listStudent();
			request.setAttribute("lisOfStudent", lisOfStudent);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/listeDesStagiaires.jsp").forward(request, response);
			 
		} catch (Exception e) {		
			e.printStackTrace();
		}			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
