CREATE OR REPLACE FUNCTION connexionStudent(login varchar2, pasword varchar2)
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
END;
/
/*declare
 var_c boolean;
 begin
  var_c := connexionStudent('thierno.diallo', 'rauma');
  DBMS_OUTPUT.PUT_LINE('result: ' ||  sys.diutil.bool_to_int(var_c));
  end;
  /*/