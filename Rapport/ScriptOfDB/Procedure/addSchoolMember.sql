create or replace procedure addShoolMember(
			fnameSm varchar2,
      lnameSm varchar2,
      tel varchar2,
      email varchar2,
      login varchar2,
      pasword varchar2
			) 
as
begin
  INSERT INTO JEE_SCHOOLMEMBER (fname, lname, tel, mail, usn, pwd) 
  VALUES (fnameSm, lnameSm, tel, email, login, pasword );
end addShoolMember;