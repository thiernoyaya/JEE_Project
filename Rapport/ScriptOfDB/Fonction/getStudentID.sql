create or replace FUNCTION getStudentID(inUsn varchar2)
RETURN number
IS
  var_id JEE_Student.idStudent%type;
   
BEGIN
  select IDSTUDENT  into var_id from JEE_STUDENT
  where usn = inUsn;
  return var_id;
  
  Exception 
    when NO_DATA_FOUND THEN
         DBMS_OUTPUT.PUT_LINE('pas d''etudiant trouvé avec ce login!');
         return 0;    
END;
/

set SERVEROUTPUT ON;
declare
 var_i number;
begin
  var_i := getStudentID('thiernfo.diallo');
  DBMS_OUTPUT.PUT_LINE('number: ' || var_i);
end;
/