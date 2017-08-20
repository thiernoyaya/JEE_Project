create or replace procedure addCoordinator(
			nameC varchar2,
			login varchar2,
			pwd varchar2
			) 
as
begin
  INSERT INTO JEE_COORDINATOR (fname, usn, PWD) 
  VALUES (nameC, login, pwd);
end addCoordinator;