package Model;

import DAO.AbstractDAOFactory;
import DAO.DAO_JEE;
import DAO.DAO_Stage;
import PojoBean.SchoolStudent;
import PojoBean.Stage;

public abstract class DB_Stage {
	
	public static boolean createStage(Stage obj) throws Exception{		
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
		DAO_JEE<Stage> StageDAO = adf.getDAO_Stage() ;
		return ((DAO_Stage) StageDAO).create(obj);
	}
	
	// le stage d'un étudiant 
	public static Stage studentStage(SchoolStudent stu) throws Exception{		
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
		DAO_JEE<Stage> StageDAO = adf.getDAO_Stage() ;
		return ((DAO_Stage) StageDAO).findStudentStage(stu);
	}

}
