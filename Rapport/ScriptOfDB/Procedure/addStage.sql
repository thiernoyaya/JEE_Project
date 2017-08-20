create or replace procedure addStage(
			tfe JEE_STAGE.TFETHEME%TYPE,
      dateB date,
      dateE date,
      idStu number,
      idSchoolM number,
      idE number
			) 
is
  vb_tfe JEE_STAGE.tfetheme%type;
  
begin
  
  INSERT INTO JEE_STAGE (TFETHEME, DATEBEGIN, DATEEND, IDSTUDENT, IDSCHMEMBER, IDENT) 
  VALUES (tfe, dateB, dateE, idStu, idSchoolM, idE)
  returning tfetheme into vb_tfe;
  
  DBMS_OUTPUT.PUT_LINE('Theme: ' || vb_tfe);
  
end addStage;