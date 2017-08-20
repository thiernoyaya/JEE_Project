CREATE OR REPLACE FUNCTION connexionCoordinator(login varchar2, pasword varchar2)
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
    
    if connexion then
      return true;
    else 
      RAISE error_connexion;
    end if;
    
    Exception 
      when error_connexion then
        DBMS_OUTPUT.PUT_LINE('ERROR LOGIN OR PASSWORD!');
        return false;    
END;
/