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
    student_flag		bool,
    teacher_flag		bool,
    admin_flag		bool,
	primary key (Username)
);

SELECT * FROM USERS;
INSERT INTO USERS (Username, user_password, FName, LName, StudentID, StudentFlag, TeacherFlag, AdminFlag)
VALUES
("garnet.crookes", "1234", "Garnet", "Crookes", "00000001", "1", "0", "0"),
("derek.walz", "pass", "Derek", "Walz", "00000002", "1", "0", "0"),
("ben.kaminski", "8080", "Ben", "Kaminski", "00000003", "1", "0", "0");

select * from users;

DROP TABLE IF EXISTS COURSE;
CREATE TABLE COURSE (
	CName		varchar(4)	not null,
	CNumber 	integer		not null,

	primary key (CName, CNumber)
);

INSERT INTO COURSE (CName, CNumber)
VALUES
("ENSF", "607"),
("ENSF", "608"),
("ENSF", "611"),
("ENSF", "612"),
("ENSF", "614");

SELECT * FROM COURSE;

-- DROP TABLE IF EXISTS SECTIONS;
-- CREATE TABLE SECTIONS (
-- 	CourseName		varchar(4)	not null,
-- 	CourseNumber 	integer		not null,
--     SectionNumber	integer		not null,
--     OfferingYear	integer 	not null,
--     Teacher			varchar(30),

-- 	primary key (CourseName, CourseNumber, SectionNumber)
-- );

-- ALTER TABLE SECTIONS
-- -- ADD foreign key (CourseName) references COURSE(CName) 
-- ADD foreign key (CourseNumber) references COURSE(CNumber),
-- ADD foreign key (Teacher) references USERS(Username); 


