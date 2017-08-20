package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SchoolMemberModel;
import Models.SchoolStudentModel;


@WebServlet("/CreateStage")
public class CreateStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public CreateStage() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		boolean error = false;
		String msgError="";
		
		try {
			
			// recuperation du user par le contexte de l'application
			ServletContext sc = getServletContext();
			SchoolStudentModel  user = (SchoolStudentModel) sc.getAttribute("UserStuent");		 
			
			// recupperation des paramètres 
			String email  = request.getParameter("email");
			String tel  = request.getParameter("tel");
			String rue  = request.getParameter("rue");
			String nrue  = request.getParameter("nrue");
			String ville  = request.getParameter("ville");			
			String spv = request.getParameter("professeur"); 
			String coord  = request.getParameter("coordinatrice");	
			
			request.setAttribute("spv", coord);
			
			SchoolMemberModel memberModel = new SchoolMemberModel();
			
			SchoolMemberModel smspv = memberModel.findMember(spv);
			SchoolMemberModel smCord = memberModel.findMember(coord);			
			
			//à traver nos setters on place des éléments dans notre objet
			user.setMail(email);
			user.setTel(tel);
			user.setStreet(rue);
			user.setStreetNB(nrue);
			user.setCity(ville);
			user.setCoordinator(smCord);
			user.setSupervisor(smspv);
			user.setTel(tel);
	         
			SchoolStudentModel studentModel =  new SchoolStudentModel();
			studentModel.createStage(user);	    

			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/createStage.jsp").forward(request, response);
			
		} catch (Exception ex) {
			msgError = ex.getMessage();
			error = true;
		}
		if(error){
			request.setAttribute("error", msgError);
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/InfoStudent&ProfSuperviseur.jsp").forward(request, response);
		}
	
  }
		
		
		
	

}
