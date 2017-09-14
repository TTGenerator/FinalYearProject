# DROP DATABASE TTGenerator;
# CREATE DATABASE TTGenerator;
# drop user admin@localhost;
# flush privileges;
# create user admin@localhost identified by 'admin123';
# grant all on TTGenerator.* to 'admin'@'localhost';
# flush privileges;

DROP TABLE IF EXISTS lecturer_preferences ;
DROP TABLE IF EXISTS role ;
DROP TABLE IF EXISTS RoomFacility ;
DROP TABLE IF EXISTS Students ;
DROP TABLE IF EXISTS Admin ;
DROP TABLE IF EXISTS Courses ;
DROP TABLE IF EXISTS Lecturers ;
DROP TABLE IF EXISTS classroom ;
DROP TABLE IF EXISTS Departments ;
DROP TABLE IF EXISTS timeslots ;
DROP TABLE IF EXISTS CourseLecturerMap ;
DROP TABLE IF EXISTS Groups ;
DROP TABLE IF EXISTS GroupCourseMap ; 

CREATE TABLE Departments (
  dept_id int NOT NULL,
	dept_name VARCHAR(50),
	PRIMARY KEY(dept_id)
);

CREATE TABLE Students (
  student_id int NOT NULL,
  student_name VARCHAR(50),
  batch_id VARCHAR(10),
  dept_id_std int,
	student_email VARCHAR(40),
	PRIMARY KEY(student_id),
	FOREIGN KEY (dept_id_std) REFERENCES Departments(dept_id)
);

CREATE TABLE Admin (
  admin_id int NOT NULL,
	admin_email VARCHAR(40),
	PRIMARY KEY(admin_id)
);

CREATE TABLE Lecturers (
  lecturer_id int NOT NULL,
	lecturer_name VARCHAR(100),
	lecturer_email VARCHAR(40),
	dept_id int,
	has_preferences BOOLEAN,
	PRIMARY KEY(lecturer_id),
	FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

CREATE TABLE Courses (
  course_id int NOT NULL,
  course_code VARCHAR(10)NOT NULL,
	course_name VARCHAR(25),
	duration NUMERIC(10) ,
	is_deleted BOOLEAN,
	max_students INTEGER(10),
  PRIMARY KEY(course_id)
);

CREATE TABLE classroom (
  roomid INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	roomname VARCHAR(50),
	room_category VARCHAR(50),
	capacity NUMERIC(50),
	is_deleted BOOLEAN

);

CREATE TABLE lecturer_preferences (
  lecturer_id int NOT NULL,
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
  roomid int NOT NULL,
	is_ac BOOLEAN,
	has_multimedia BOOLEAN,
	has_whiteboard BOOLEAN,
	PRIMARY KEY(roomid)
);

CREATE TABLE timeslots (
  timeslot_id int NOT NULL,
	timeslot VARCHAR(50),
	PRIMARY KEY(timeslot_id)
);

CREATE TABLE CourseLecturerMap (
	id int NOT NULL,
  course_id int NOT NULL,
  lecturer_id int NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE GroupCourseMap (
	id int NOT NULL,
  group_id int NOT NULL,
  course_id int NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Groups (
	group_id int NOT NULL,
  group_size int NOT NULL,
  PRIMARY KEY(group_id)
);

