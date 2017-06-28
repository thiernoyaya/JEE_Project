package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.SchoolStudentModel;
import Models.StageModel;

/**
 * Servlet implementation class ServletStageInfo
 */
@WebServlet("/ServletStageInfo")
public class ServletStageInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStageInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation du user par le contexte de l'application
		 ServletContext sc = getServletContext();
		 SchoolStudentModel  user = (SchoolStudentModel) sc.getAttribute("UserStuent");	
		 
		 String entname = request.getParameter("entname");
		 String entspvname = request.getParameter("entspvname");
		 String entspvmail = request.getParameter("entspvmail");
		 String entspvtel = request.getParameter("entspvtel");
		 String entcountry = request.getParameter("entcountry");
		 String entcity = request.getParameter("entcity");
		 String entstreet = request.getParameter("entstreet");
		 String entstreetnb = request.getParameter("entstreetnb");
		 String entzipcode = request.getParameter("entzipcode");
		 String datebeg = request.getParameter("datebeg");
		 String dateend = request.getParameter("dateend");
		 String tfetheme = request.getParameter("tfetheme");
		 
		 // convertion des string en date		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 
		 try {
			Date datedeb = new Date(01/02/2016);
			Date datefin = new Date(26/05/2016);
			
			// creation de l'objet stage
			StageModel stage = new StageModel(user, entname, entspvname,entspvmail, entspvtel, entcountry, entzipcode, entcity, entstreet, entstreetnb, datedeb, datefin,tfetheme );
			
			StageModel.createStage(stage);
			this.getServletContext().getRequestDispatcher("/WEB-INF/VIEW/validationInfoStage.jsp").forward(request, response);		
			
		} 
		 /*catch (ParseException e) {			
			e.printStackTrace();
		}*/ catch (Exception e) {
			e.printStackTrace();
		}
			 

		
	}

}




















