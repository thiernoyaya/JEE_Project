/*==============================================================*/
/*          PROJET JEE vs PL/SQL                                */
/*NOM  SGBD        :  ORACLE Version 11g              					*/
/*NOM DE LA DB     :  Gestion de stage    	           					*/
/*DATE DE CREATION :  12/07/2017 09:00:00             					*/
/*==============================================================*/

/*DROP USER Yaya_JEE CASCADE;
CREATE USER Yaya_JEE IDENTIFIED BY rama;
GRANT CONNECT, RESOURCE, DBA to STAGE;

CONNECT Yaya_JEE/rama*/


/*==============================================================*/
/* Table : JEE_Coordinator                               			 	*/
/*==============================================================*/
create table JEE_Coordinator (
   idcoordinator 			INTEGER 			not null,
   fname 			VARCHAR2(100),
   usn 		    VARCHAR2(100) 		not null,      
   pwd 			  VARCHAR2(100) not null,
   constraint PK_JEE_Coordinator primary key (idcoordinator)
);

/*==============================================================*/
/* Table : JEE_Student                                					*/
/*==============================================================*/
create table JEE_Student (
   idstudent 			INTEGER   not null,
   fname 		VARCHAR2(100)		not null,
   lname  	VARCHAR2(100) 	not null,      
   tel      VARCHAR2(50) 		not null,
   mail     VARCHAR2(100) 	not null,
   usn      VARCHAR2(100)   not null,
   pwd      VARCHAR2(100)   not null,
   sect     VARCHAR2(50),
   cat      varchar2(50),
   estb     varchar2(100),
   city     VARCHAR2(100),
   street   VARCHAR2(60),
   streetnb INTEGER,
   zipcode  INTEGER,
   idcoordinator 			INTEGER	not null,
   constraint PK_JEE_Student primary key (idstudent)
);

/*==============================================================*/
/* Index : Coordinates_FK                             					*/
/*==============================================================*/
create index Coordinates_FK on JEE_Student (
   idcoordinator ASC
);

/*==============================================================*/
/* Table : JEE_SchoolMember                            					*/
/*==============================================================*/
create table JEE_SchoolMember (
   idschmember 			INTEGER   not null,
   fname 		VARCHAR2(100)		not null,
   lname  	VARCHAR2(100) 	not null,      
   tel      VARCHAR2(50) 		not null,
   mail     VARCHAR2(100) 	not null,
   usn      VARCHAR2(100)   not null,
   pwd      VARCHAR2(100)   not null,
   constraint PK_JEE_SchoolMember primary key (idschmember)
);

/*==============================================================*/
/* Table : JEE_Corporate                               					*/
/*==============================================================*/
create table JEE_Corporate (
   ident 			      INTEGER 			not null,
   entname		   		VARCHAR2(100) 			not null,
   entspvname     	VARCHAR2(100) 			not null,      
   entspvtel    		VARCHAR2(100)				not null,
   entspvmail 			VARCHAR2(100)				not null,
   entcountry 			VARCHAR2(100)				not null,
   entcity          VARCHAR2(100)       not null,
   entstreet        VARCHAR2(100)       not null,
   entstreetnb      VARCHAR2(100)       not null,
   entzipcode       VARCHAR2(100)       not null,
   constraint PK_JEE_Corporate primary key (ident)   
);

/*==============================================================*/
/* Table : JEE_Stage                        					*/
/*==============================================================*/
create table JEE_Stage (
   idstage      INTEGER 			not null,
   tfetheme     VARCHAR2(100)	not null,
   datebegin		date,      
   dateend 			date,
   idstudent 			INTEGER   not null,
   idschmember 			INTEGER   not null,
   ident 			      INTEGER 			not null,
   constraint PK_JEE_Stage primary key (idstage)
);

/*==============================================================*/
/* Index : PERFORM_FK                          					*/
/*==============================================================*/
create index PERFORM_FK on JEE_Stage (
   idstudent ASC
);

/*==============================================================*/
/* Index : OVERSEES_FK                          					*/
/*==============================================================*/
create index OVERSEES_FK on JEE_Stage (
   idschmember ASC
);

/*==============================================================*/
/* Index : TAKE_PLACE_FK                          					*/
/*==============================================================*/
create index TAKE_PLACE_FK on JEE_Stage (
   ident ASC
);

/*==============================================================*/
/* CONSTRAINTS FOREIGN KEY                    					*/
/*==============================================================*/

alter table JEE_Student
   add constraint FK_Student_COORDINATES_COORDINATOR foreign key (idcoordinator)
      references JEE_Coordinator (idcoordinator) on delete cascade;

alter table JEE_Stage
   add constraint FK_Stage_PERFORM_Student foreign key (idstudent)
      references JEE_Student (idstudent) on delete cascade;
	  
alter table JEE_Stage
   add constraint FK_Stage_OVERSEES_SchoolMember foreign key (idschmember)
      references JEE_SchoolMember (idschmember) on delete cascade;
      
alter table JEE_Stage
   add constraint FK_Stage_TAKEPLACE_Corporate foreign key (ident)
      references JEE_Corporate (ident) on delete cascade;
      
	  
/*==============================================================*/
/* AUTO INCREMENT			                  		               			*/
/*==============================================================*/
create sequence JEE_Coordinator_SEQ start with 1;

create or replace trigger JEE_Coordinator_T
before insert on JEE_Coordinator
for each row

begin
  select JEE_Coordinator_SEQ.nextval
  into   :new.idcoordinator
  from   dual;
end;
/

create sequence JEE_Student_SEQ start with 1;

create or replace trigger JEE_Student_T
before insert on JEE_Student
for each row

begin
  select JEE_Student_SEQ.nextval
  into   :new.idstudent
  from   dual;
end;
/

create sequence JEE_SchoolMember_SEQ START with 1;

create or replace trigger JEE_SchoolMember_T
before insert on JEE_SchoolMember
for each row

begin
  select JEE_SchoolMember_SEQ.nextval
  into   :new.idschmember
  from   dual;
end;
/

create sequence JEE_Corporate_SEQ START with 1;

create or replace trigger JEE_Corporate_T
before insert on JEE_Corporate
for each row

begin
  select JEE_Corporate_SEQ.nextval
  into   :new.ident
  from   dual;
end;
/

create sequence JEE_Stage_SEQ START with 1;

create or replace trigger JEE_Stage_T
before insert on JEE_Stage
for each row

begin
  select JEE_Stage_SEQ.nextval
  into   :new.idstage
  from   dual;
end;
/