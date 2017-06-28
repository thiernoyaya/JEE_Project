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

/**
 * Servlet implementation class ServletStageCoordinatrice
 */
@WebServlet("/ServletStageCoordinatrice")
public class ServletStageCoordinatrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStageCoordinatrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*R�cup�ration de l'ensemble des etudiants*/
		
		 try {			
			 SchoolMemberModel sm = new SchoolMemberModel();
			 Set<SchoolStudentModel> lisOfStudent =  sm.listStudent();
			// Set<SchoolStudent> lisOfStudent   =  SchoolStudent.listOfALLStudent(); 
			 //Set<SchoolStudent> lisOfStudent= sm.
			
			
			//transmission de la liste � la jsp
			request.setAttribute("lisOfStudent", lisOfStudent);
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/listeDesStagiaires.jsp").forward(request, response);
			 
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
