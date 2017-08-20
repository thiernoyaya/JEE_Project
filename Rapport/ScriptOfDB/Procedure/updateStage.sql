create or replace procedure updateStage(
			id_stage number,
      tfe varchar2,
      dateB date,
      dateE date,
      id_student number,
      id_schoolMember number,
      id_ent number       
			) 
as
  vb_tfe JEE_STAGE.TFETHEME%type;
begin
  UPDATE JEE_STAGE
	SET TFETHEME = tfe,
		  DATEBEGIN = dateB,
		  DATEEND = dateE,
      IDSTUDENT = id_student,
      IDSCHMEMBER = id_schoolMember, 
      IDENT = id_ent       
		WHERE IDSTAGE = id_stage
    returning TFETHEME into vb_tfe;
    
    if SQL%found then
      DBMS_OUTPUT.PUT_LINE('The Data updated successfully and the number of lignes updated are: ' || SQL%ROWCOUNT);
      DBMS_OUTPUT.PUT_LINE('THEME: ' || vb_tfe);
    end if;
end updateStage;