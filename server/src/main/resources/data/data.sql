INSERT INTO admin VALUES ('admin1', 'admin1@pdn.ac.lk');
INSERT INTO admin VALUES ('admin2', 'admin2@pdn.ac.lk');
INSERT INTO admin VALUES ('admin3', 'admin3@pdn.ac.lk');
INSERT INTO admin VALUES ('admin4', 'admin4@pdn.ac.lk');
INSERT INTO admin VALUES ('admin5', 'admin5@pdn.ac.lk');

INSERT INTO classroom VALUES ('r2', 'room02', 'lecturehall', 150, false);
INSERT INTO classroom VALUES ('r3', 'room03', 'lecturehall', 150, false);
INSERT INTO classroom VALUES ('r7', 'room07', 'lecturehall', 300, false);
INSERT INTO classroom VALUES ('r8', 'room08', 'lecturehall', 300, false);
INSERT INTO classroom VALUES ('r9', 'room09', 'lecturehall', 320, false);
INSERT INTO classroom VALUES ('r10', 'room10', 'lecturehall', 320, false);
INSERT INTO classroom VALUES ('r11', 'room11', 'lecturehall', 320, false);
INSERT INTO classroom VALUES ('r12', 'room12', 'lecturehall', 105, false);
INSERT INTO classroom VALUES ('r13', 'room13', 'lecturehall', 44, false);
INSERT INTO classroom VALUES ('r14', 'room14', 'lecturehall', 80, false);
INSERT INTO classroom VALUES ('r15', 'room15', 'lecturehall', 45, false);
INSERT INTO classroom VALUES ('r16', 'room16', 'lecturehall', 45, false);
INSERT INTO classroom VALUES ('r17', 'room17', 'lecturehall', 45, false);
INSERT INTO classroom VALUES ('r18', 'room18', 'lecturehall', 62, false);
INSERT INTO classroom VALUES ('r19', 'room19', 'lecturehall', 105, false);
INSERT INTO classroom VALUES ('r20', 'room20', 'lecturehall', 37, false);
INSERT INTO classroom VALUES ('r21', 'room21', 'lecturehall', 104, false);
INSERT INTO classroom VALUES ('r23', 'room23', 'lecturehall', 150, false);
INSERT INTO classroom VALUES ('do1', 'drawing1', 'drawingoffice', 200, false);
INSERT INTO classroom VALUES ('do2', 'drawing2', 'drawingoffice', 200, false);

INSERT INTO departments VALUES ('d1', 'Chemical and Process Engineering');
INSERT INTO departments VALUES ('d2', 'Civil Engineering');
INSERT INTO departments VALUES ('d3', 'Computer Engineering');
INSERT INTO departments VALUES ('d4', 'Electrical and Electronic Engineering');
INSERT INTO departments VALUES ('d5', 'Engineering Management');
INSERT INTO departments VALUES ('d6', 'Engineering Mathematics');
INSERT INTO departments VALUES ('d7', 'Mechanical Engineering');
INSERT INTO departments VALUES ('d8', 'Production and Manufacturing Engineering');

INSERT INTO role VALUES ('admin', 'ADMIN', 'admin123');
INSERT INTO role VALUES ('staff', 'STAFF', 'staff123');
INSERT INTO role VALUES ('e12333', 'STUDENT', 'e12333');
INSERT INTO role VALUES ('e12132', 'STUDENT', 'e12132');
INSERT INTO role VALUES ('e12117', 'STUDENT', 'e12117');

INSERT INTO room_facility VALUES ('r2', false, true, false);
INSERT INTO room_facility VALUES ('r3', false, true, false);

INSERT INTO lecturers VALUES ('lecturer1', 'lecturer1', 'lecturer1@pdn.ac.lk', 'd1', true);
INSERT INTO lecturers VALUES ('lecturer2', 'lecturer2', 'lecturer2@pdn.ac.lk', 'd2', true);
INSERT INTO lecturers VALUES ('lecturer3', 'lecturer3', 'lecturer3@pdn.ac.lk', 'd1', true);
INSERT INTO lecturers VALUES ('lecturer4', 'lecturer4', 'lecturer4@pdn.ac.lk', 'd1', true);
INSERT INTO lecturers VALUES ('lecturer5', 'lecturer5', 'lecturer5@pdn.ac.lk', 'd1', true);
INSERT INTO lecturers VALUES ('lecturer6', 'lecturer6', 'lecturer6@pdn.ac.lk', 'd1', true);

INSERT INTO lecturer_preferences VALUES('lecturer1',true,true,false);
INSERT INTO lecturer_preferences VALUES('lecturer2',true,true,false);

INSERT INTO courses VALUES ('GP101', 'English1', '2', false, 'lecturer1', 400);
INSERT INTO courses VALUES ('GP103', 'Mathematics1', '2',false, 'lecturer2', 400);
INSERT INTO courses VALUES ('GP109', 'Material Science', '2',  false, 'lecturer3', 400);
INSERT INTO courses VALUES ('GP110', 'Engineering Mechanics', '2', false, 'lecturer4', 400);
INSERT INTO courses VALUES ('GP112', 'Engineering Measurements', '2', false, 'lecturer5', 400);
INSERT INTO courses VALUES ('GP114', 'Engineering Drawing', '2',  false, 'lecturer6', 400);