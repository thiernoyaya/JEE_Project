create or replace procedure deleteStage(
      id_student number       
			) 
as
  cursor delete_Stage is select IDSTAGE , TFETHEME  from JEE_STAGE
  where IDSTUDENT = id_student
  for UPDATE;
  
begin
  for c in delete_Stage
    loop
       DELETE  JEE_STAGE
       WHERE  current of delete_Stage;
       commit;
    end loop;
    
    if SQL%found then
      DBMS_OUTPUT.PUT_LINE('The Data deleted successfully and the number of lignes updated are: ' || SQL%ROWCOUNT);
    end if;
    Exception 
      When NO_DATA_FOUND then
              DBMS_OUTPUT.PUT_LINE('The data doesn''t exist !');
end deleteStage;
/*set SERVEROUTPUT ON;
declare
begin 
  deleteStage(23);
end;*/