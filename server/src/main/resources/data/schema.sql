--  DROP DATABASE TTGenerator;
--  CREATE DATABASE TTGenerator;
--  drop user admin@localhost;
--  flush privileges;
--  create user admin@localhost identified by 'admin123';
--  grant all on TTGenerator.* to 'admin'@'localhost';
--  flush privileges;

DROP TABLE IF EXISTS LecturerPreferences ;
DROP TABLE IF EXISTS role ;
DROP TABLE IF EXISTS Role ;
DROP TABLE IF EXISTS RoomFacility ;
DROP TABLE IF EXISTS Students ;
DROP TABLE IF EXISTS Admin ;
DROP TABLE IF EXISTS Courses ;
DROP TABLE IF EXISTS Lecturers ;
DROP TABLE IF EXISTS Classroom ;
DROP TABLE IF EXISTS Departments ;

CREATE TABLE Departments (
  dept_id VARCHAR(50)NOT NULL,
	dept_name VARCHAR(50),
	PRIMARY KEY(dept_id)
);

CREATE TABLE Students (
  student_id VARCHAR(10)NOT NULL,
  student_name VARCHAR(50),
  batch_id VARCHAR(10),
  dept_id VARCHAR(10),
	student_email VARCHAR(40),
	PRIMARY KEY(student_id),
	FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

CREATE TABLE Admin (
  admin_id VARCHAR(10)NOT NULL,
	admin_email VARCHAR(40),
	PRIMARY KEY(admin_id)
);

CREATE TABLE Lecturers (
  lecturer_id VARCHAR(50)NOT NULL,
	lecturer_name VARCHAR(100),
	lecturer_email VARCHAR(40),
	dept_id VARCHAR(50),
	has_preferences BOOLEAN,
	PRIMARY KEY(lecturer_id),
	FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

CREATE TABLE Courses (
  course_code VARCHAR(10)NOT NULL,
	course_name VARCHAR(25),
	duration NUMERIC(10) ,
	is_deleted BOOLEAN,
	lecturer_id VARCHAR(50),
	max_students INTEGER(10),
  PRIMARY KEY(course_code),
	FOREIGN KEY (lecturer_id) REFERENCES Lecturers(lecturer_id)
);

CREATE TABLE Classroom (
  room_id VARCHAR(50)NOT NULL,
	room_name VARCHAR(50),
	room_category VARCHAR(50),
	capacity NUMERIC(50),
	is_deleted BOOLEAN,
	PRIMARY KEY(room_id)
);

CREATE TABLE LecturerPreferences (
  lecturer_id VARCHAR(50)NOT NULL,
	is_ac BOOLEAN,
	has_multimedia BOOLEAN,
	has_whiteboard BOOLEAN,
	PRIMARY KEY(lecturer_id)
);

CREATE TABLE role (
	name VARCHAR(50)NOT NULL,
  role VARCHAR(50),
	password VARCHAR(50),
	PRIMARY KEY(name)
);

CREATE TABLE RoomFacility (
  room_id VARCHAR(50)NOT NULL,
	is_ac BOOLEAN,
	has_multimedia BOOLEAN,
	has_whiteboard BOOLEAN,
	PRIMARY KEY(room_id)
);
