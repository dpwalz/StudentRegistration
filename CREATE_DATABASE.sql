DROP DATABASE IF EXISTS STUDENTREGISTRATION; 
CREATE DATABASE STUDENTREGISTRATION; 
USE STUDENTREGISTRATION; 

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
	Username		varchar(30)	not null,
	user_password	varchar(36)	not null,
	FName			varchar(30)	not null,
    LName			varchar(30)	not null,
    StudentID		varchar(8)	not null,
    StudentFlag		bool,
    TeacherFlag		bool,
    AdminFlag		bool,
	primary key (Username)
);

INSERT INTO USERS (Username, user_password, FName, LName, StudentID, StudentFlag, TeacherFlag, AdminFlag)
VALUES
("garnet.crookes", "1234", "Garnet", "Crookes", "00000001", "1", "0", "0"),
("derek.walz", "pass", "Derek", "Walz", "00000002", "1", "0", "0"),
("ben.kaminski", "8080", "Ben", "Kaminski", "00000003", "1", "0", "0");


DROP TABLE IF EXISTS COURSE;
CREATE TABLE COURSE (
	CName		varchar(4)	not null,
	CNumber 	varchar(3)	not null,

	primary key (CName, CNumber)
);

INSERT INTO COURSE (CName, CNumber)
VALUES
("ENSF", "607"),
("ENSF", "608"),
("ENSF", "611"),
("ENSF", "612"),
("ENSF", "614");

SELECT * FROM COURSE

