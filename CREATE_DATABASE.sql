DROP DATABASE IF EXISTS STUDENTREGISTRATION; 
CREATE DATABASE STUDENTREGISTRATION; 
USE STUDENTREGISTRATION; 

-- Create and populate student table --
DROP TABLE IF EXISTS STUDENTS;
CREATE TABLE STUDENTS (
	username		varchar(30)		not null,
	UPassword		varchar(36)		not null,
	FName			varchar(30)		not null,
    LName			varchar(30)		not null,
    StudentID		varchar(8)		not null,
    Major			varchar(15)		not null,
	primary key (username)
);

INSERT INTO STUDENTS (username, UPassword, FName, LName, StudentID, Major)
VALUES
("garnet.crookes", "1234", "Garnet", "Crookes", "00000001", "ENGINEERING"),
("derek.walz", "pass", "Derek", "Walz", "00000002", "ENGINEERING"),
("ben.kaminski", "8080", "Ben", "Kaminski", "00000003", "ENGINEERING");

SELECT * FROM STUDENTS;



-- Create and populate teacher table --
DROP TABLE IF EXISTS TEACHERS;
CREATE TABLE TEACHERS (
	username		varchar(30)		not null,
	UPassword		varchar(36)		not null,
	FName			varchar(30)		not null,
    LName			varchar(30)		not null,
	primary key (username)
);

INSERT INTO TEACHERS (username, UPassword, FName, LName)
VALUES
("jakaur", "1234", "Jaspreet", "Kaur"),
("mmoshirpour", "pass", "Mohammad", "Moshipour");

SELECT * FROM TEACHERS;


-- Create and populate course table --

DROP TABLE IF EXISTS COURSES;
CREATE TABLE COURSES (
	CName		varchar(4)	not null,
	CNumber 	integer		not null,
	primary key (CName, CNumber)
);

INSERT INTO COURSES (CName, CNumber)
VALUES
("ENSF", "607"),
("ENSF", "608"),
("ENSF", "611"),
("ENSF", "612"),
("ENSF", "614"),
("ENEL", "645"),
("ENGG", "683"),
("ENSF", "609"),
("ENSF", "610"),
("SENG", "637");

SELECT * FROM COURSES;




-- Create and populate pre-requisite table --

DROP TABLE IF EXISTS PREREQUISITES;
CREATE TABLE PREREQUISITES (
	CourseName				varchar(4)	not null,
    CourseNumber 			integer		not null,
    PreRequisiteName		varchar(4)	not null,
    PreRequisiteNumber 		integer		not null,
    
    primary key (CourseNumber, CourseName, PreRequisiteNumber, PreRequisiteName)
);

ALTER TABLE PREREQUISITES
	ADD CONSTRAINT foreign key (CourseName, CourseNumber) references COURSES (CName, CNumber);
    
ALTER TABLE PREREQUISITES
	ADD CONSTRAINT foreign key (PreRequisiteName, PreRequisiteNumber) references COURSES (CName, CNumber);
    

DROP TABLE IF EXISTS SECTIONS;
CREATE TABLE SECTIONS (
	CourseName		varchar(4)	not null,
	CourseNumber 	integer		not null,
    SectionNumber	integer		not null,
    SectionYear		integer		not null,
    Teacher			varchar(30),

	primary key (CourseName, CourseNumber, SectionNumber, SectionYear),
    foreign key (CourseName, CourseNumber) references COURSES (CName, CNumber),
	foreign key (Teacher) references TEACHERS (username) 
);


INSERT INTO SECTIONS (CourseName, CourseNumber, SectionNumber, SectionYear, Teacher)
VALUES
("ENSF", "607", 1, 2022, "mmoshirpour"),
("ENSF", "608", 1, 2022, "jakaur"),
("ENSF", "611", 1, 2022, "jakaur"),
("ENSF", "612", 1, 2022, "jakaur"),
("ENSF", "614", 1, 2022, "jakaur"),
("ENSF", "607", 2, 2022, "mmoshirpour"),
("ENSF", "608", 2, 2022, "jakaur"),
("ENSF", "611", 2, 2022, "jakaur"),
("ENSF", "612", 2, 2022, "jakaur"),
("ENSF", "614", 2, 2022, "jakaur"),
("ENSF", "612", 3, 2022, "jakaur"),
("ENSF", "614", 3, 2022, "jakaur"),
("ENEL", "645", 1, 2022, "jakaur"),
("ENGG", "683", 1, 2022, "jakaur"),
("ENSF", "609", 1, 2022, "jakaur"),
("ENSF", "610", 1, 2022, "jakaur"),
("SENG", "637", 1, 2022, "jakaur");

Select * from SECTIONS;


DROP TABLE IF EXISTS REGISTRATIONS;
CREATE TABLE REGISTRATIONS (
	StudentUsername		varchar(30)	not null,
	CourseName			varchar(4)	not null,
	CourseNumber 		integer		not null,
    SectionNumber		integer		not null,
    SectionYear			integer		not null,
    Grade				varchar(2),

	primary key (StudentUsername, CourseName, CourseNumber, SectionNumber, SectionYear),
    foreign key (CourseName, CourseNumber, SectionNumber, SectionYear) references SECTIONS (CourseName, CourseNumber, SectionNumber, SectionYear),
	foreign key (StudentUsername) references STUDENTS (Username)
);


INSERT INTO REGISTRATIONS (StudentUsername, CourseName, CourseNumber, SectionNumber, SectionYear, Grade)
VALUES
("garnet.crookes", "ENSF", "607", 1, 2022, "B"),
("garnet.crookes", "ENSF", "608", 1, 2022, "B+"),
("garnet.crookes", "ENSF", "611", 1, 2022, "A-"),
("garnet.crookes", "ENSF", "612", 1, 2022, "A"),
("garnet.crookes", "ENSF", "614", 1, 2022, "A+"),
("derek.walz", "ENSF", "607", 1, 2022, "B"),
("derek.walz", "ENSF", "608", 1, 2022, "B+"),
("derek.walz", "ENSF", "611", 1, 2022, "A-"),
("derek.walz", "ENSF", "612", 1, 2022, "A"),
("derek.walz", "ENSF", "614", 1, 2022, "A+"),
("ben.kaminski", "ENSF", "607", 1, 2022, "B"),
("ben.kaminski", "ENSF", "608", 1, 2022, "B+"),
("ben.kaminski", "ENSF", "611", 1, 2022, "A-"),
("ben.kaminski", "ENSF", "612", 1, 2022, "A"),
("ben.kaminski", "ENSF", "614", 1, 2022, "A+");


Select * from REGISTRATIONS;