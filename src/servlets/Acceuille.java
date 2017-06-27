package Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PojoBean.SchoolMember;
import PojoBean.SchoolStudent;
import PojoBean.User;

/**
 * Servlet implementation class AcceuilleEtudiant
 */
@WebServlet("/Acceuille")
public class Acceuille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acceuille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// je vais récupere nom du user pour ensuite l'afficher et faire tous les text necessaire c'est à dire 
		//verification de champs vide et appel à la fonction de connexion pour verrifier si l'utilisateur est bien exacte
		
		boolean error = false;
		String msgError="";
		String userName = request.getParameter("txt_usn");
		String userPwd  = request.getParameter("txt_pwd");
		
		User user = new User();
		user.setUsn(userName);
		user.setPwd(userPwd);
		
		
		try{				
			Object obj = user.login(userName);
			if(obj != null){
				/*// creation d'un contexte pour l'application accessible durant toute la durée de l'application
				ServletContext sc = getServletContext();
				sc.setAttribute("USER", user);*/
				
				// crétion d'une session pour les users lorsqu'ils se connectent pour la 1er fois
				HttpSession session = request.getSession();
				//si la séssion est correctement créer alors on ajoute notre user
				session.setAttribute("Usersession", user );
				try{
					SchoolStudent ss = (SchoolStudent)obj;
					// creation d'un contexte pour l'application accessible durant toute la durée de l'application
					ServletContext scS = getServletContext();
					scS.setAttribute("UserStuent",  ss );
					obj = null;
					//pour l'étudiant
					this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/AcceuilleEtudiant.jsp").forward(request, response);						
				}
				catch(Exception e){
					SchoolMember sm = (SchoolMember)obj;
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
			} else
				throw new Exception("NULL");
		}
		catch(Exception ex){
			msgError = ex.getMessage();
			error = true;
		}
		//lorqu'on rencontre une erreur lors du login on signale le problème à l'u
		if(error){
			request.setAttribute("error", msgError);
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/login.jsp").forward(request, response);
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
