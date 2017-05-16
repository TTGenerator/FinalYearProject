CREATE DATABASE TTGenerator; 

CREATE TABLE Students (
    student_id VARCHAR(10)NOT NULL,
    student_name VARCHAR(50),
    batch_id VARCHAR(10),
    dept_id VARCHAR(10),
	student_email VARCHAR(40),
	courses_codes SET('a', 'b', 'c', 'd'),
	PRIMARY KEY(student_id),
	FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);





CREATE TABLE Admin (
    admin_id VARCHAR(10)NOT NULL,
	admin_email VARCHAR(40),
	PRIMARY KEY(admin_id)
);

INSERT INTO Admin VALUES ('admin1', 'admin1@pdn.ac.lk');
INSERT INTO Admin VALUES ('admin2', 'admin2@pdn.ac.lk');
INSERT INTO Admin VALUES ('admin3', 'admin3@pdn.ac.lk');
INSERT INTO Admin VALUES ('admin4', 'admin4@pdn.ac.lk');
INSERT INTO Admin VALUES ('admin5', 'admin5@pdn.ac.lk');





CREATE TABLE Lecturers (
    lecturer_id VARCHAR(50)NOT NULL,
	lecturer_name VARCHAR(100),
	lecturer_email VARCHAR(40),
	dept_id VARCHAR(50),
	has_preferences BOOLEAN,
	courses_codes SET('a', 'b', 'c', 'd'),
	PRIMARY KEY(lecturer_id),
	FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);






CREATE TABLE Courses (
    course_code VARCHAR(10)NOT NULL,
	course_name VARCHAR(25),
	duration TIME(6),
	is_active BOOLEAN,
	is_deleted BOOLEAN,
	lecturer_id VARCHAR(50),
	max_students INTEGER(10),
    PRIMARY KEY(course_code),
	FOREIGN KEY (lecturer_id) REFERENCES Lecturers(lecturer_id)
);
INSERT INTO Courses VALUES ('GP101', 'English1', '0100', true, false, 'lecturer1', 400);
INSERT INTO Courses VALUES ('GP103', 'Mathematics1', '0100', true, false, 'lecturer2', 400);
INSERT INTO Courses VALUES ('GP109', 'Material Science', '0100', true, false, 'lecturer3', 400);
INSERT INTO Courses VALUES ('GP110', 'Engineering Mechanics', '0100', true, false, 'lecturer4', 400);
INSERT INTO Courses VALUES ('GP112', 'Engineering Measurements', '0100', true, false, 'lecturer5', 400);
INSERT INTO Courses VALUES ('GP114', 'Engineering Drawing', '0100', true, false, 'lecturer6', 400);





CREATE TABLE Classrooms (
    room_id VARCHAR(50)NOT NULL,
	room_name VARCHAR(50),
	room_category VARCHAR(50),
	capacity NUMERIC(50),
	is_active BOOLEAN,
	is_deleted BOOLEAN,
	PRIMARY KEY(room_id)
);
INSERT INTO Classrooms VALUES ('r2', 'room02', 'lecturehall', 150, true, false);
INSERT INTO Classrooms VALUES ('r3', 'room03', 'lecturehall', 150, true, false);
INSERT INTO Classrooms VALUES ('r7', 'room07', 'lecturehall', 300, true, false);
INSERT INTO Classrooms VALUES ('r8', 'room08', 'lecturehall', 300, true, false);
INSERT INTO Classrooms VALUES ('r9', 'room09', 'lecturehall', 320, true, false);
INSERT INTO Classrooms VALUES ('r10', 'room10', 'lecturehall', 320, true, false);
INSERT INTO Classrooms VALUES ('r11', 'room11', 'lecturehall', 320, true, false);
INSERT INTO Classrooms VALUES ('r12', 'room12', 'lecturehall', 105, true, false);
INSERT INTO Classrooms VALUES ('r13', 'room13', 'lecturehall', 44, true, false);
INSERT INTO Classrooms VALUES ('r14', 'room14', 'lecturehall', 80, true, false);
INSERT INTO Classrooms VALUES ('r15', 'room15', 'lecturehall', 45, true, false);
INSERT INTO Classrooms VALUES ('r16', 'room16', 'lecturehall', 45, true, false);
INSERT INTO Classrooms VALUES ('r17', 'room17', 'lecturehall', 45, true, false);
INSERT INTO Classrooms VALUES ('r18', 'room18', 'lecturehall', 62, true, false);
INSERT INTO Classrooms VALUES ('r19', 'room19', 'lecturehall', 105, true, false);
INSERT INTO Classrooms VALUES ('r20', 'room20', 'lecturehall', 37, true, false);
INSERT INTO Classrooms VALUES ('r21', 'room21', 'lecturehall', 104, true, false);
INSERT INTO Classrooms VALUES ('r23', 'room23', 'lecturehall', 150, false, false);
INSERT INTO Classrooms VALUES ('do1', 'drawing1', 'drawingoffice', 200, true, false);
INSERT INTO Classrooms VALUES ('do2', 'drawing2', 'drawingoffice', 200, true, false);





CREATE TABLE Departments (
    dept_id VARCHAR(50)NOT NULL,
	dept_name VARCHAR(50),
	PRIMARY KEY(dept_id)
);

INSERT INTO Departments VALUES ('d1', 'Chemical and Process Engineering');
INSERT INTO Departments VALUES ('d2', 'Civil Engineering');
INSERT INTO Departments VALUES ('d3', 'Computer Engineering');
INSERT INTO Departments VALUES ('d4', 'Electrical and Electronic Engineering');
INSERT INTO Departments VALUES ('d5', 'Engineering Management');
INSERT INTO Departments VALUES ('d6', 'Engineering Mathematics');
INSERT INTO Departments VALUES ('d7', 'Mechanical Engineering');
INSERT INTO Departments VALUES ('d8', 'Production and Manufacturing Engineering');






CREATE TABLE LecturerPreferences (
    lecturer_id VARCHAR(50)NOT NULL,
	prefered_dayid SET('d1', 'd2', 'd3', 'd4', 'd5'),
	prefered_timeid SET('t1', 't2', 't3', 't4'),
	is_ac BOOLEAN,
	has_multimedia BOOLEAN,
	has_whiteboard BOOLEAN,
	PRIMARY KEY(lecturer_id)
);





CREATE TABLE Role (
	user_name VARCHAR(50)NOT NULL,
    role VARCHAR(50),
	password VARCHAR(50),
	PRIMARY KEY(user_name)
);

INSERT INTO Role VALUES ('admin1', 'admin', 'admin1');
INSERT INTO Role VALUES ('lecturer1', 'lecturer', 'lecturer1');
INSERT INTO Role VALUES ('student1', 'student', 'student1');





CREATE TABLE RoomFacility (
    room_id VARCHAR(50)NOT NULL,
	is_ac BOOLEAN,
	has_multimedia BOOLEAN,
	has_whiteboard BOOLEAN,
	PRIMARY KEY(room_id)
);

INSERT INTO RoomFacility VALUES ('r2', false, true, false);
INSERT INTO RoomFacility VALUES ('r3', false, true, false);


