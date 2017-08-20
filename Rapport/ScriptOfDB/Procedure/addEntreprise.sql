create or replace procedure addEntreprise(
			nameE varchar2,
      spvName varchar2,
      spvTel varchar2,
      spvMail varchar2,
      countryE varchar2,
      cityE  varchar2,
      streetE varchar2,
      streetNbE varchar2,
      codeE varchar2
			) 
as
begin
  INSERT INTO JEE_CORPORATE (ENTNAME, ENTSPVNAME, ENTSPVTEL, ENTSPVMAIL, ENTCOUNTRY, ENTCITY, ENTSTREET, ENTSTREETNB, ENTZIPCODE) 
  VALUES (nameE, spvName, spvTel, spvMail, countryE, cityE, streetE, streetNbE, codeE );
end addEntreprise;