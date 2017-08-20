CREATE OR REPLACE FUNCTION connexionSchoolMember(login varchar2, pasword varchar2)
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
END;
/
/*declare
 var_c boolean;
 begin
  var_c := connexionSchoolMember('guilhem.wetteren', 'tst');
  DBMS_OUTPUT.PUT_LINE('result: ' ||  sys.diutil.bool_to_int(var_c));
  end;
  /*/