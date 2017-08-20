CREATE OR REPLACE PACKAGE connexionDB
IS
  FUNCTION connexionCoordinator(login varchar2, pasword varchar2)
  RETURN BOOLEAN;
  
  FUNCTION connexionSchoolMember(login varchar2, pasword varchar2)
  RETURN BOOLEAN;
  
  FUNCTION connexionStudent(login varchar2, pasword varchar2)
  RETURN BOOLEAN ;
END connexionDB;
/

CREATE OR REPLACE PACKAGE BODY connexionDB
IS
--------------- CONNECTION COORDINATOR---------------------------
  FUNCTION connexionCoordinator(login varchar2, pasword varchar2)
  RETURN BOOLEAN 
  IS
    type coordinator is record(loginC JEE_COORDINATOR.USN%TYPE , pwdC JEE_COORDINATOR.PWD%type);
    type tab_coordinator is table of coordinator not null index by binary_integer;
  
    connexion boolean := false;
    t_coord tab_coordinator;
   error_connexion EXCEPTION;   
   
  BEGIN
    select usn, pwd bulk collect into t_coord from JEE_COORDINATOR;
    for i IN 1..t_coord.count
      LOOP
       if t_coord(i).loginC = login and t_coord(i).pwdC = pasword then
          connexion := true;
       end if;
      END LOOP;
    
    if connexion = true then
      return true;
    else 
      RAISE error_connexion;
    end if;
    
    Exception 
      when error_connexion then
        DBMS_OUTPUT.PUT_LINE('ERROR LOGIN OR PASSWORD!');
        return false;    
  END connexionCoordinator;
-------------------------CONNECTION SChoolMemeber-----------------
  FUNCTION connexionSchoolMember(login varchar2, pasword varchar2)
  RETURN BOOLEAN 
  IS
    type schoolMemeber is record(loginC JEE_SCHOOLMEMBER.USN%TYPE , pwdC JEE_SCHOOLMEMBER.PWD%type);
   type tab_sm is table of schoolMemeber not null index by binary_integer;
  
   connexion boolean := false;
    t_sm tab_sm;
    error_connexion EXCEPTION;   
   
  BEGIN
    select usn, pwd bulk collect into t_sm from JEE_SCHOOLMEMBER;
    for i IN 1..t_sm.count
      LOOP
       if t_sm(i).loginC = login and t_sm(i).pwdC = pasword then
         connexion := true;
       end if;
      END LOOP;
    
    if connexion = true then
      return true;
    else 
      RAISE error_connexion;
    end if;
    
    Exception 
      when error_connexion then
        DBMS_OUTPUT.PUT_LINE('ERROR LOGIN OR PASSWORD!');
        return false;    
   END connexionSchoolMember;
 ---------------------------- CONNECTION STUDENT--------------
   FUNCTION connexionStudent(login varchar2, pasword varchar2)
   RETURN BOOLEAN 
  IS
    type student is record(loginC JEE_STUDENT.USN%TYPE , pwdC JEE_STUDENT.PWD%type);
    type tab_student is table of student not null index by binary_integer;
  
    connexion boolean := false;
    t_sm tab_student;
     error_connexion EXCEPTION;   
   
  BEGIN
    select usn, pwd bulk collect into t_sm from JEE_STUDENT;
    for i IN 1..t_sm.count
     LOOP
        if t_sm(i).loginC = login and t_sm(i).pwdC = pasword then
         connexion := true;
        end if;
     END LOOP;
    
    if connexion = true then
      return true;
    else 
      RAISE error_connexion;
    end if;
    
    Exception 
      when error_connexion then
        DBMS_OUTPUT.PUT_LINE('ERROR LOGIN OR PASSWORD!');
        return false;    
  END connexionStudent;
  
END connexionDB;
/

/*BEGIN
IF connexionDB.connexionStudent('thierno.diallo', 'rama') THEN
  DBMS_OUTPUT.PUT_LINE('trouvé');
ELSE
  DBMS_OUTPUT.PUT_LINE('pas trouvé');
END IF;
END;
/*/