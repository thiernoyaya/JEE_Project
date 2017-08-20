package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Stage;
import Models.SchoolMemberModel;
import Models.SchoolStudentModel;


@WebServlet("/ServeletDisplayStage")
public class ServeletDisplayStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServeletDisplayStage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		try{
			ServletContext ss = getServletContext();
			Object  user =   ss.getAttribute("UserStudent");
			SchoolStudentModel studentModel = new SchoolStudentModel();

			if(user instanceof SchoolStudentModel){	
				SchoolStudentModel ssOfStudent = studentModel.getStudent( ((SchoolStudentModel)user).getUsn());
				Stage stge  = ssOfStudent.TrainingOfStudent(ssOfStudent);
				request.setAttribute("stage",stge);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/affichageDesInfoStageParStudent.jsp").forward(request, response);				
			}
			else{
				ServletContext serveletContext = getServletContext();		 
				SchoolMemberModel  schoolMemberModel = (SchoolMemberModel) serveletContext.getAttribute("UserMember");
				
				// recuperation du paramètre étudiant
				String studentName = request.getParameter("createStage");
				request.setAttribute("etudiant", studentName);
				
				//appel de la fonction pour afficher les infos de stage de l'étudiant 
				 SchoolStudentModel schoolStudentModel = studentModel.getStudent(studentName);
				 Stage stage = schoolStudentModel.TrainingOfStudent(schoolStudentModel);
				 request.setAttribute("stage",stage);
				 
				 SchoolMemberModel sm = (SchoolMemberModel)schoolMemberModel;					
				 if(!sm.getFlagCoordinator()){
					//pour le superviseur
					this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/affichageDesInfoStage.jsp").forward(request, response);	
				 }
				 else{
					//pour le coordinatrice
					this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/affichageDesInfoStage2_coordinatrice.jsp").forward(request, response);		
			    }
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
