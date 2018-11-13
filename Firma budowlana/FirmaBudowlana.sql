--------------------------------------------------------
--  File created - wtorek-czerwiec-12-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence CZAS_PRACY_AI
--------------------------------------------------------

   CREATE SEQUENCE  "PIOTR1"."CZAS_PRACY_AI"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 10 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence DZIAL_AI
--------------------------------------------------------

   CREATE SEQUENCE  "PIOTR1"."DZIAL_AI"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 10 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence KIEROWNICY_AI
--------------------------------------------------------

   CREATE SEQUENCE  "PIOTR1"."KIEROWNICY_AI"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 11 CACHE 10 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence PRACOWNICY_AI
--------------------------------------------------------

   CREATE SEQUENCE  "PIOTR1"."PRACOWNICY_AI"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 10 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence URLOP_AI
--------------------------------------------------------

   CREATE SEQUENCE  "PIOTR1"."URLOP_AI"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 10 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Table ADMINISTRATORZY
--------------------------------------------------------

  CREATE TABLE "PIOTR1"."ADMINISTRATORZY" 
   (	"LOGIN" VARCHAR2(255 BYTE), 
	"HASLO" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CZAS_PRACY
--------------------------------------------------------

  CREATE TABLE "PIOTR1"."CZAS_PRACY" 
   (	"ID_CZASU" NUMBER, 
	"DATA" DATE, 
	"LICZBA_GODZIN" NUMBER, 
	"ID_PRACOWNIKA" NUMBER, 
	"ID_KIEROWNIKA" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table DZIAL
--------------------------------------------------------

  CREATE TABLE "PIOTR1"."DZIAL" 
   (	"ID_DZIALU" NUMBER, 
	"NAZWA" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table KIEROWNICY
--------------------------------------------------------

  CREATE TABLE "PIOTR1"."KIEROWNICY" 
   (	"ID_KIEROWNIKA" NUMBER, 
	"IMIE" VARCHAR2(100 BYTE), 
	"NAZWISKO" VARCHAR2(200 BYTE), 
	"LOGIN" VARCHAR2(255 BYTE), 
	"HASLO" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRACOWNICY
--------------------------------------------------------

  CREATE TABLE "PIOTR1"."PRACOWNICY" 
   (	"ID_PRACOWNIKA" FLOAT(126), 
	"IMIE" VARCHAR2(100 BYTE), 
	"NAZWISKO" VARCHAR2(200 BYTE), 
	"STANOWISKO" VARCHAR2(255 BYTE), 
	"WYNAGRODZENIE" NUMBER, 
	"BONUS" NUMBER, 
	"ID_DZIALU" NUMBER, 
	"LOGIN" VARCHAR2(255 BYTE), 
	"HASLO" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table URLOP
--------------------------------------------------------

  CREATE TABLE "PIOTR1"."URLOP" 
   (	"ID_URLOPU" NUMBER, 
	"LICZBA_DNI" NUMBER, 
	"ID_PRACOWNIKA" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into PIOTR1.ADMINISTRATORZY
SET DEFINE OFF;
Insert into PIOTR1.ADMINISTRATORZY (LOGIN,HASLO) values ('piotr1','piotr1234');
REM INSERTING into PIOTR1.CZAS_PRACY
SET DEFINE OFF;
Insert into PIOTR1.CZAS_PRACY (ID_CZASU,DATA,LICZBA_GODZIN,ID_PRACOWNIKA,ID_KIEROWNIKA) values ('53',to_date('18/06/20','RR/MM/DD'),'195','11','1');
Insert into PIOTR1.CZAS_PRACY (ID_CZASU,DATA,LICZBA_GODZIN,ID_PRACOWNIKA,ID_KIEROWNIKA) values ('54',to_date('18/06/21','RR/MM/DD'),'40','11','1');
REM INSERTING into PIOTR1.DZIAL
SET DEFINE OFF;
Insert into PIOTR1.DZIAL (ID_DZIALU,NAZWA) values ('1','Obsluga Maszyn');
Insert into PIOTR1.DZIAL (ID_DZIALU,NAZWA) values ('2','Wykonczenia');
Insert into PIOTR1.DZIAL (ID_DZIALU,NAZWA) values ('3','Dekarze');
REM INSERTING into PIOTR1.KIEROWNICY
SET DEFINE OFF;
Insert into PIOTR1.KIEROWNICY (ID_KIEROWNIKA,IMIE,NAZWISKO,LOGIN,HASLO) values ('1','Jan','Kowalski','login','haslo');
REM INSERTING into PIOTR1.PRACOWNICY
SET DEFINE OFF;
Insert into PIOTR1.PRACOWNICY (ID_PRACOWNIKA,IMIE,NAZWISKO,STANOWISKO,WYNAGRODZENIE,BONUS,ID_DZIALU,LOGIN,HASLO) values ('3','Andrzej','Sabat','tynkarz','1900','95','3','login','haslo');
Insert into PIOTR1.PRACOWNICY (ID_PRACOWNIKA,IMIE,NAZWISKO,STANOWISKO,WYNAGRODZENIE,BONUS,ID_DZIALU,LOGIN,HASLO) values ('11','Mateusz','Chowaniec','malarz','2100','105','2','malarz','malarz');
Insert into PIOTR1.PRACOWNICY (ID_PRACOWNIKA,IMIE,NAZWISKO,STANOWISKO,WYNAGRODZENIE,BONUS,ID_DZIALU,LOGIN,HASLO) values ('2','Tomasz','Nowak','dekarz','2000','200','3','login1','haslo');
REM INSERTING into PIOTR1.URLOP
SET DEFINE OFF;
Insert into PIOTR1.URLOP (ID_URLOPU,LICZBA_DNI,ID_PRACOWNIKA) values ('12','4','11');
--------------------------------------------------------
--  DDL for Index PRACOWNICY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PIOTR1"."PRACOWNICY_PK" ON "PIOTR1"."PRACOWNICY" ("ID_PRACOWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index URLOP_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PIOTR1"."URLOP_PK" ON "PIOTR1"."URLOP" ("ID_URLOPU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index DZIAL_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PIOTR1"."DZIAL_PK" ON "PIOTR1"."DZIAL" ("ID_DZIALU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index CZAS_PRACY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PIOTR1"."CZAS_PRACY_PK" ON "PIOTR1"."CZAS_PRACY" ("ID_CZASU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KIEROWNICY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PIOTR1"."KIEROWNICY_PK" ON "PIOTR1"."KIEROWNICY" ("ID_KIEROWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PRACOWNICY
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("ID_PRACOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("IMIE" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("NAZWISKO" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("STANOWISKO" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("WYNAGRODZENIE" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("ID_DZIALU" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."PRACOWNICY" ADD CONSTRAINT "PRACOWNICY_PK" PRIMARY KEY ("ID_PRACOWNIKA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("HASLO" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."PRACOWNICY" MODIFY ("LOGIN" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DZIAL
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."DZIAL" MODIFY ("ID_DZIALU" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."DZIAL" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."DZIAL" ADD CONSTRAINT "DZIAL_PK" PRIMARY KEY ("ID_DZIALU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ADMINISTRATORZY
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."ADMINISTRATORZY" MODIFY ("LOGIN" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."ADMINISTRATORZY" MODIFY ("HASLO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table KIEROWNICY
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."KIEROWNICY" MODIFY ("ID_KIEROWNIKA" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."KIEROWNICY" MODIFY ("IMIE" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."KIEROWNICY" MODIFY ("NAZWISKO" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."KIEROWNICY" ADD CONSTRAINT "KIEROWNICY_PK" PRIMARY KEY ("ID_KIEROWNIKA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PIOTR1"."KIEROWNICY" MODIFY ("LOGIN" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."KIEROWNICY" MODIFY ("HASLO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table URLOP
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."URLOP" MODIFY ("ID_URLOPU" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."URLOP" MODIFY ("LICZBA_DNI" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."URLOP" MODIFY ("ID_PRACOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."URLOP" ADD CONSTRAINT "URLOP_PK" PRIMARY KEY ("ID_URLOPU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CZAS_PRACY
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."CZAS_PRACY" MODIFY ("ID_CZASU" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."CZAS_PRACY" MODIFY ("DATA" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."CZAS_PRACY" MODIFY ("LICZBA_GODZIN" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."CZAS_PRACY" MODIFY ("ID_PRACOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."CZAS_PRACY" MODIFY ("ID_KIEROWNIKA" NOT NULL ENABLE);
  ALTER TABLE "PIOTR1"."CZAS_PRACY" ADD CONSTRAINT "CZAS_PRACY_PK" PRIMARY KEY ("ID_CZASU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CZAS_PRACY
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."CZAS_PRACY" ADD CONSTRAINT "CZAS_PRACY_PRACOWNICY_FK1" FOREIGN KEY ("ID_KIEROWNIKA")
	  REFERENCES "PIOTR1"."KIEROWNICY" ("ID_KIEROWNIKA") ENABLE;
  ALTER TABLE "PIOTR1"."CZAS_PRACY" ADD CONSTRAINT "CZAS_PRACY_PRACOWNICY_FK2" FOREIGN KEY ("ID_PRACOWNIKA")
	  REFERENCES "PIOTR1"."PRACOWNICY" ("ID_PRACOWNIKA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRACOWNICY
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."PRACOWNICY" ADD CONSTRAINT "PRACOWNICY_DZIAL_FK1" FOREIGN KEY ("ID_DZIALU")
	  REFERENCES "PIOTR1"."DZIAL" ("ID_DZIALU") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table URLOP
--------------------------------------------------------

  ALTER TABLE "PIOTR1"."URLOP" ADD CONSTRAINT "URLOP_PRACOWNICY_FK1" FOREIGN KEY ("ID_PRACOWNIKA")
	  REFERENCES "PIOTR1"."PRACOWNICY" ("ID_PRACOWNIKA") ENABLE;
--------------------------------------------------------
--  DDL for Trigger CZAS_PRACY_AI_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "PIOTR1"."CZAS_PRACY_AI_TRIGGER" 
BEFORE INSERT ON CZAS_PRACY 
references new as new
FOR EACH ROW
BEGIN
 if(:new.ID_CZASU is null)then
 select CZAS_PRACY_ai.nextval
 into:new.ID_CZASU
 from dual;
 end if;
END;
/
ALTER TRIGGER "PIOTR1"."CZAS_PRACY_AI_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger DODAJ_URLOP_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "PIOTR1"."DODAJ_URLOP_TRIGGER" 
AFTER INSERT ON CZAS_PRACY
FOR EACH ROW 
DECLARE
PRAGMA AUTONOMOUS_TRANSACTION;
suma_godzin NUMBER;
suma NUMBER ;
BEGIN
 SELECT SUM(liczba_godzin)INTO suma_godzin  FROM czas_pracy 
 WHERE id_pracownika = :new.ID_PRACOWNIKA;
 suma := suma_godzin;
 

 IF INSERTING THEN 
  suma := suma_godzin + :new.liczba_godzin; 
 END IF;
 
 IF suma >= 210 THEN 
  DODAJ_URLOP(:new.ID_PRACOWNIKA, 4);
  END IF;
 IF suma >= 190 THEN 
  DODAJ_URLOP(:new.ID_PRACOWNIKA, 2);
END IF;

END;
/
ALTER TRIGGER "PIOTR1"."DODAJ_URLOP_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger DZIAL_AI_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "PIOTR1"."DZIAL_AI_TRIGGER" 
BEFORE INSERT ON DZIAL 
references new as new
FOR EACH ROW
BEGIN
 if(:new.ID_DZIALU is null)then
 select DZIAL_ai.nextval
 into:new.ID_DZIALU
 from dual;
 end if;
END;
/
ALTER TRIGGER "PIOTR1"."DZIAL_AI_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KIEROWNICY_AI_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "PIOTR1"."KIEROWNICY_AI_TRIGGER" 
BEFORE INSERT ON KIEROWNICY 
references new as new
FOR EACH ROW
BEGIN
 if(:new.ID_KIEROWNIKA is null)then
 select KIEROWNICY_ai.nextval
 into:new.ID_KIEROWNIKA
 from dual;
 end if;
END;
/
ALTER TRIGGER "PIOTR1"."KIEROWNICY_AI_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRACOWNICY_AI_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "PIOTR1"."PRACOWNICY_AI_TRIGGER" 
BEFORE INSERT ON PRACOWNICY 
references new as new
FOR EACH ROW
BEGIN
 if(:new.ID_PRACOWNIKA is null)then
 select PRACOWNICY_ai.nextval
 into:new.ID_PRACOWNIKA
 from dual;
 end if;
END;
/
ALTER TRIGGER "PIOTR1"."PRACOWNICY_AI_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PRACOWNICY_WYNAGRODZENIE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "PIOTR1"."PRACOWNICY_WYNAGRODZENIE" 
BEFORE INSERT ON PRACOWNICY 
FOR EACH ROW
BEGIN
  if(:new.stanowisko = 'operator')then :new.BONUS := :new.WYNAGRODZENIE*0.15;
  end if;
  if(:new.stanowisko = 'dekarz')then :new.BONUS := :new.WYNAGRODZENIE*0.10;
  end if;
  if(:new.stanowisko = 'tynkarz')then :new.BONUS := :new.WYNAGRODZENIE*0.05;
  end if;
  if(:new.stanowisko = 'malarz')then :new.BONUS := :new.WYNAGRODZENIE*0.05;
  end if;
  if(:new.stanowisko = 'murarz')then :new.BONUS := :new.WYNAGRODZENIE*0.05;
  end if;
  if(:new.stanowisko = 'dzwigowy')then :new.BONUS := :new.WYNAGRODZENIE*0.15;
  end if;
END;
/
ALTER TRIGGER "PIOTR1"."PRACOWNICY_WYNAGRODZENIE" ENABLE;
--------------------------------------------------------
--  DDL for Trigger URLOP_AI_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "PIOTR1"."URLOP_AI_TRIGGER" 
BEFORE INSERT ON URLOP
references new as new
FOR EACH ROW
BEGIN
 if(:new.ID_URLOPU is null)then
 select urlop_ai.nextval
 into:new.ID_URLOPU
 from dual;
 end if;
END;
/
ALTER TRIGGER "PIOTR1"."URLOP_AI_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Procedure DODAJ_GODZINY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "PIOTR1"."DODAJ_GODZINY" (
data in DATE,
liczba_godzin in number,
id_pracownika in number,
id_kierownika in number

)
IS
BEGIN
  INSERT INTO czas_pracy(data,liczba_godzin,id_pracownika,id_kierownika) 
  VALUES(data,liczba_godzin,id_pracownika,id_kierownika);
END DODAJ_GODZINY;

/
--------------------------------------------------------
--  DDL for Procedure DODAJ_KIEROWNIKA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "PIOTR1"."DODAJ_KIEROWNIKA" (
imie in varchar2,
nazwisko in varchar2,
login in varchar2,
haslo in varchar2)
IS
BEGIN
  INSERT INTO kierownicy(imie,nazwisko,login,haslo) 
  VALUES (imie,nazwisko,login,haslo);
END DODAJ_KIEROWNIKA;

/
--------------------------------------------------------
--  DDL for Procedure DODAJ_PRACOWNIKA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "PIOTR1"."DODAJ_PRACOWNIKA" (
imie in varchar2,
nazwisko in varchar2,
stanowisko in varchar2,
wynagrodzenie in number,
premia in number,
id_dzialu in number,
login in varchar2,
haslo in varchar2)
IS
BEGIN
  INSERT INTO pracownicy(imie,nazwisko,stanowisko,wynagrodzenie,id_dzialu,login,haslo) 
  VALUES (imie,nazwisko,stanowisko,wynagrodzenie,id_dzialu,login,haslo);
END DODAJ_PRACOWNIKA;

/
--------------------------------------------------------
--  DDL for Procedure DODAJ_URLOP
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "PIOTR1"."DODAJ_URLOP" (id_pracownika IN NUMBER, liczba_dni IN NUMBER) IS
exst NUMBER(1) := 0;
BEGIN
 SELECT CASE 
    WHEN EXISTS(
       SELECT ID_PRACOWNIKA FROM URLOP where ID_PRACOWNIKA = id_pracownika
       )
       THEN 1
       ELSE 0
       END INTO exst
    FROM DUAL;
IF exst = 0 THEN 
  INSERT INTO URLOP(ID_PRACOWNIKA,LICZBA_DNI)  VALUES(id_pracownika,liczba_dni); 
  commit;
END IF;
END DODAJ_URLOP;

/
--------------------------------------------------------
--  DDL for Procedure ZMIANA_HASLA_KIEROWNIK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "PIOTR1"."ZMIANA_HASLA_KIEROWNIK" (id in number, pass in varchar) is
BEGIN
  UPDATE kierownicy set haslo = pass where id_kierownika = id;
END ZMIANA_HASLA_KIEROWNIK;

/
--------------------------------------------------------
--  DDL for Procedure ZMIANA_HASLA_PRACOWNIK
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "PIOTR1"."ZMIANA_HASLA_PRACOWNIK" (id in number, pass in varchar) is 
BEGIN
  UPDATE pracownicy set haslo = pass where id_pracownika = id;
END ZMIANA_HASLA_PRACOWNIK;

/
