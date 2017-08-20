create or replace procedure updateEntreprise(
			idE number,
			eName varchar2,
      spvName varchar2,
      spvTel varchar2,
      spvMail varchar2,
      eCountry varchar2,
      eCity varchar2,
      eStreet varchar2,
      eSreetnb number,
      eZipcode number
			) 
as
begin
  UPDATE JEE_CORPORATE
	SET ENTNAME = eName,
      ENTSPVNAME = spvName,
      ENTSPVTEL = spvTel,
      ENTSPVMAIL = spvMail,
      ENTCOUNTRY = eCountry,
      ENTCITY   = eCity,
      ENTSTREET = eStreet,
      ENTSTREETNB = eSreetnb,
      ENTZIPCODE = eZipcode
		WHERE IDENT = idE;
    
    if SQL%found then
      DBMS_OUTPUT.PUT_LINE('The Data updated successfully and the number of lignes updated are: ' || SQL%ROWCOUNT);
    end if;
    
end updateEntreprise;