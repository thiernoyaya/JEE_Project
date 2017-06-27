package Model;

import java.util.Set;

import DAO.AbstractDAOFactory;
import DAO.DAO_JEE;
import DAO.DAO_SchoolMember;
import PojoBean.SchoolMember;

public abstract class DB_SchoolMember {
		
	public static boolean connexionMember(String usn){
		try {
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();
			DAO_JEE<SchoolMember> MemberDAO = adf.getDAO_SchoolMember();		
			return ((DAO_SchoolMember) MemberDAO).SchoolMemberExist(usn);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	
	}
	
	public static SchoolMember createMember(String usn) throws Exception{		
		try{
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
			DAO_JEE<SchoolMember> MemberDAO = adf.getDAO_SchoolMember();
			return ((DAO_SchoolMember) MemberDAO).find(usn);
		
		} catch(Exception ex) 
		{
			throw ex;
		}
	}
		
		// fonction qui retourne la liste des étudiants du profs

		public static SchoolMember listOfStudent(String usn) throws Exception{		
			try{
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
				DAO_JEE<SchoolMember> MemberDAO = adf.getDAO_SchoolMember();
				return ((DAO_SchoolMember) MemberDAO).findList(usn);
			
			} catch(Exception ex) {
				throw ex;
			}		
	}
		
	// liste des différents memmbres de l'école 
	public static Set<SchoolMember> memberOfschool( boolean spv) throws Exception{
		try{
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
			DAO_JEE<SchoolMember> MemberDAO = adf.getDAO_SchoolMember();
			return ((DAO_SchoolMember) MemberDAO).findListMembreOfschool(spv);
		
		} catch(Exception ex) {
			throw ex;
		}			
	}
	
	// fonction qui retourne un objet schoolmember 
	public static SchoolMember findSchoolMember(String usn) throws Exception{
		try{
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory();		
			DAO_JEE<SchoolMember> MemberDAO = adf.getDAO_SchoolMember();
			return ((DAO_SchoolMember) MemberDAO).find(usn);
		
		} catch(Exception ex) 
		{
			throw ex;
		}
	}
}
