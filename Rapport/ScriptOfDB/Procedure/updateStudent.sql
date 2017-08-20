create or replace procedure updateStudent(
			idS number,
      telS varchar2,
      email varchar2,
      section varchar2,
      catego varchar2,
      establissement varchar2,
      ville varchar2,
      roude varchar2,
      roudenb number,
      code number
			) 
as
begin
  UPDATE JEE_STUDENT
	SET tel = telS,
		  mail = email,
		  sect = section,
      cat = catego,
      estb = establissement, 
      city = ville,
      street = roude,
      streetnb = roudenb,
      zipcode = code
      WHERE IDSTUDENT = idS;
    
    if SQL%found then
      DBMS_OUTPUT.PUT_LINE('The Data updated successfully and the number of lignes updated are: ' || SQL%ROWCOUNT);
    end if;
    
    Exception 
      when NO_DATA_FOUND then
          DBMS_OUTPUT.PUT_LINE('Please the data you are looking for doesn''t exist!');
end updateStudent;