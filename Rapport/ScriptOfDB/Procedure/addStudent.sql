create or replace procedure addStudent(
			fnameS varchar2,
      lnameS varchar2,
      tel varchar2,
      email varchar2,
      login varchar2,
      pasword varchar2,
      section varchar2,
      catego varchar2,
      establissement varchar2,
      ville varchar2,
      roude varchar2,
      roudenb number,
      code number,
      idcoord number
			) 
as
begin
  INSERT INTO JEE_Student (fname, lname, tel, mail, usn, pwd, sect, cat, estb, city, street, streetnb,zipcode, IDCOORDINATOR) 
  VALUES (fnameS, lnameS, tel, email, login, pasword, section, catego, establissement, ville, roude, roudenb, code, idcoord );
end addStudent;