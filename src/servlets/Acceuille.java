package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.User;
import Models.SchoolMemberModel;
import Models.SchoolStudentModel;
import Models.UserModel;

@WebServlet("/Acceuille")
public class Acceuille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Acceuille() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 		
		boolean error = false;
		String msgError="";
		String userName = request.getParameter("txt_usn");
		String userPwd  = request.getParameter("txt_pwd");
		
		UserModel userModel = new UserModel();
		userModel.setUsn(userName);
		userModel.setPwd(userPwd);
				
		try{				
			Object obj = userModel.login(userName, userPwd);
			if(obj != null){
							
				// crétion d'une session pour les users lorsqu'ils se connectent pour la 1er fois
				HttpSession session = request.getSession();
				//si la séssion est correctement créer alors on ajoute notre user
				User user = new User();
				user.setUsn(userName);
				
				session.setAttribute("Usersession", user );
				
				if(obj instanceof SchoolStudentModel ){
					SchoolStudentModel ss = (SchoolStudentModel)obj;
					ServletContext scS = getServletContext();
					scS.setAttribute("UserStudent",  ss );
					obj = null;
					//pour l'étudiant
					this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/AcceuilleEtudiant.jsp").forward(request, response);		
				}
				else {
					SchoolMemberModel sm = (SchoolMemberModel)obj;
					ServletContext ssm = getServletContext();
					ssm.setAttribute("UserMember",  sm );
					obj = null;					
					if(!sm.getFlagCoordinator()){
						//pour le superviseur
						this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/AcceuilleSchooMember.jsp").forward(request, response);		
					}
					else
						//pour le coordinatrice
			    		request.setAttribute("sm", sm);
						this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/AcceuilleCoordinatrice.jsp").forward(request, response);		
					}					
			}
			else{
				throw new Exception("The user is not initialized");
			}
		}
		catch(Exception ex){
			msgError = ex.getMessage();
			error = true;
		}
		if(error){
			request.setAttribute("error", msgError);
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/login.jsp").forward(request, response);
		}
		
	}
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
