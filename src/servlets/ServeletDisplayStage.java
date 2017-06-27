package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PojoBean.SchoolMember;
import PojoBean.SchoolStudent;
import PojoBean.Stage;

/**
 * Servlet implementation class ServeletDisplayStage
 */
@WebServlet("/ServeletDisplayStage")
public class ServeletDisplayStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletDisplayStage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 
		 try{
			 // r�cuperation du contexte afin de savoir qui se connecte pour afficher la page coorespondante
			 ServletContext sc = getServletContext();		 
			 SchoolMember  obj = (SchoolMember) sc.getAttribute("UserMember");
			 
			 // recuperation du param�tre 
			 String studentName = request.getParameter("createStage");
			 request.setAttribute("etudiant", studentName);
			 
			 //appel de la fonction pour afficher les infos de stage de l'�tudiant via un objet �tudiant
			 SchoolStudent ss = SchoolStudent.student(studentName);
			 Stage stage = ss.TrainingOfStudent(ss);
			 request.setAttribute("stage",stage);
			 
			 if(obj != null){ 
				try{ 
					SchoolMember sm = (SchoolMember)obj;					
					if(!sm.getFlagCoordinator()){
						//pour le superviseur
						this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/affichageDesInfoStage.jsp").forward(request, response);	
					}
					else{
						//pour le coordinatrice
						this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/affichageDesInfoStage2_coordinatrice.jsp").forward(request, response);		
				   }
				}			 
				catch(Exception e){
					e.getMessage();	
			   }
			 }
			 else{
				throw new Exception("null");		  
			 }
		 }
		 catch(Exception ex){
			 ServletContext ss = getServletContext();
			 SchoolStudent  user = (SchoolStudent) ss.getAttribute("UserStuent");
			try {
				SchoolStudent ssofStudent = SchoolStudent.student(user.getUsn());
				Stage stge  = ssofStudent.TrainingOfStudent(ssofStudent);
				request.setAttribute("stage",stge);
				//  appel � la page de l'�tudiant pour afficher ses propres infos de stage
				this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/affichageDesInfoStageParStudent.jsp").forward(request, response);	
				
			} catch (Exception e) {
				e.printStackTrace();
			}				
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}