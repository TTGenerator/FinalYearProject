INSERT INTO Admin VALUES (1, 'admin1@pdn.ac.lk');
INSERT INTO Admin VALUES (2, 'admin2@pdn.ac.lk');
INSERT INTO Admin VALUES (3, 'admin3@pdn.ac.lk');
INSERT INTO Admin VALUES (4, 'admin4@pdn.ac.lk');
INSERT INTO Admin VALUES (5, 'admin5@pdn.ac.lk');

INSERT INTO classroom VALUES (1, 'room02', 'lecturehall', 150, false);
INSERT INTO classroom VALUES (2, 'room03', 'lecturehall', 150, false);
INSERT INTO classroom VALUES (3, 'room07', 'lecturehall', 300, false);
INSERT INTO classroom VALUES (4, 'room08', 'lecturehall', 300, false);
INSERT INTO classroom VALUES (5, 'room09', 'lecturehall', 320, false);
INSERT INTO classroom VALUES (6, 'room10', 'lecturehall', 320, false);
INSERT INTO classroom VALUES (7, 'room11', 'lecturehall', 320, false);
INSERT INTO classroom VALUES (8, 'room12', 'lecturehall', 105, false);
INSERT INTO classroom VALUES (9, 'room13', 'lecturehall', 44, false);
INSERT INTO classroom VALUES (10, 'room14', 'lecturehall', 80, false);
INSERT INTO classroom VALUES (11, 'room15', 'lecturehall', 45, false);
INSERT INTO classroom VALUES (12, 'room16', 'lecturehall', 45, false);
INSERT INTO classroom VALUES (13, 'room17', 'lecturehall', 45, false);
INSERT INTO classroom VALUES (14, 'room18', 'lecturehall', 62, false);
INSERT INTO classroom VALUES (15, 'room19', 'lecturehall', 105, false);
INSERT INTO classroom VALUES (16, 'room20', 'lecturehall', 37, false);
INSERT INTO classroom VALUES (17, 'room21', 'lecturehall', 104, false);
INSERT INTO classroom VALUES (18, 'room23', 'lecturehall', 150, false);
INSERT INTO classroom VALUES (19, 'drawing1', 'drawingoffice', 200, false);
INSERT INTO classroom VALUES (20, 'drawing2', 'drawingoffice', 200, false);

INSERT INTO Departments VALUES (1, 'Chemical and Process Engineering');
INSERT INTO Departments VALUES (2, 'Civil Engineering');
INSERT INTO Departments VALUES (3, 'Computer Engineering');
INSERT INTO Departments VALUES (4, 'Electrical and Electronic Engineering');
INSERT INTO Departments VALUES (5, 'Engineering Management');
INSERT INTO Departments VALUES (6, 'Engineering Mathematics');
INSERT INTO Departments VALUES (7, 'Mechanical Engineering');
INSERT INTO Departments VALUES (8, 'Production and Manufacturing Engineering');

INSERT INTO role VALUES ('admin', 'ADMIN', 'admin123');
INSERT INTO role VALUES ('staff', 'STAFF', 'staff123');
INSERT INTO role VALUES ('e12333', 'STUDENT', 'e12333');
INSERT INTO role VALUES ('e12132', 'STUDENT', 'e12132');
INSERT INTO role VALUES ('e12117', 'STUDENT', 'e12117');

INSERT INTO RoomFacility VALUES (2, false, true, false);
INSERT INTO RoomFacility VALUES (3, false, true, false);

INSERT INTO timeslots VALUES (1, 'Mon 8:00 - 8:55');
INSERT INTO timeslots VALUES (2, 'Mon 8:55 - 9:50');
INSERT INTO timeslots VALUES (3, 'Mon 10:10 - 11:05');
INSERT INTO timeslots VALUES (4, 'Mon 11:05 - 12:00');
INSERT INTO timeslots VALUES (5, 'Mon 13:00 - 13:55');
INSERT INTO timeslots VALUES (6, 'Mon 13:55 - 14:50');
INSERT INTO timeslots VALUES (7, 'Mon 15:10 - 16:05');
INSERT INTO timeslots VALUES (8, 'Mon 16:05 - 17:00');
INSERT INTO timeslots VALUES (9, 'Tue 8:00 - 8:55');
INSERT INTO timeslots VALUES (10, 'Tue 8:55 - 9:50');
INSERT INTO timeslots VALUES (11, 'Tue 10:10 - 11:05');
INSERT INTO timeslots VALUES (12, 'Tue 11:05 - 12:00');
INSERT INTO timeslots VALUES (13, 'Tue 13:00 - 13:55');
INSERT INTO timeslots VALUES (14, 'Tue 13:55 - 14:50');
INSERT INTO timeslots VALUES (15, 'Tue 15:10 - 16:05');
INSERT INTO timeslots VALUES (16, 'Tue 16:05 - 17:00');
INSERT INTO timeslots VALUES (17, 'Wed 8:00 - 8:55');
INSERT INTO timeslots VALUES (18, 'Wed 8:55 - 9:50');
INSERT INTO timeslots VALUES (19, 'Wed 10:10 - 11:05');
INSERT INTO timeslots VALUES (20, 'Wed 11:05 - 12:00');
INSERT INTO timeslots VALUES (21, 'Wed 13:00 - 13:55');
INSERT INTO timeslots VALUES (22, 'Wed 13:55 - 14:50');
INSERT INTO timeslots VALUES (23, 'Wed 15:10 - 16:05');
INSERT INTO timeslots VALUES (24, 'Wed 16:05 - 17:00');
INSERT INTO timeslots VALUES (25, 'Thur 8:00 - 8:55');
INSERT INTO timeslots VALUES (26, 'Thur 8:55 - 9:50');
INSERT INTO timeslots VALUES (27, 'Thur 10:10 - 11:05');
INSERT INTO timeslots VALUES (28, 'Thur 11:05 - 12:00');
INSERT INTO timeslots VALUES (29, 'Thur 13:00 - 13:55');
INSERT INTO timeslots VALUES (30, 'Thur 13:55 - 14:50');
INSERT INTO timeslots VALUES (31, 'Thur 15:10 - 16:05');
INSERT INTO timeslots VALUES (32, 'Thur 16:05 - 17:00');
INSERT INTO timeslots VALUES (33, 'Fri 8:00 - 8:55');
INSERT INTO timeslots VALUES (34, 'Fri 8:55 - 9:50');
INSERT INTO timeslots VALUES (35, 'Fri 10:10 - 11:05');
INSERT INTO timeslots VALUES (36, 'Fri 11:05 - 12:00');
INSERT INTO timeslots VALUES (37, 'Fri 13:00 - 13:55');
INSERT INTO timeslots VALUES (38, 'Fri 13:55 - 14:50');
INSERT INTO timeslots VALUES (39, 'Fri 15:10 - 16:05');
INSERT INTO timeslots VALUES (40, 'Fri 16:05 - 17:00');

INSERT INTO Lecturers VALUES (1, 'Mr M Dharmawardane', 'a', 1, true);
INSERT INTO Lecturers VALUES (2, 'Mr D Athawuda', 'a', 1, true);
INSERT INTO Lecturers VALUES (3, 'Dr A K Kulathunga', 'a', 1, true);
INSERT INTO Lecturers VALUES (4, 'Dr K Samarakoon', 'a', 1, true);
INSERT INTO Lecturers VALUES (5, 'Dr R Ragel', 'a', 1, true);
INSERT INTO Lecturers VALUES (6, 'Mr S Deegalla', 'a', 1, true);
INSERT INTO Lecturers VALUES (7, 'Dr D Elkaduwa', 'a', 1, true);
INSERT INTO Lecturers VALUES (8, 'Dr K Rathnam', 'a', 1, true);
INSERT INTO Lecturers VALUES (9, 'Dr N Karunarathna', 'a', 1, true);
INSERT INTO Lecturers VALUES (10, 'Dr S A H A Suraweera', 'a', 1, true);
INSERT INTO Lecturers VALUES (11, 'Dr S Radakrishnan', 'a', 1, true);
INSERT INTO Lecturers VALUES (12, 'Dr A Bandaranayake', 'a', 1, true);
INSERT INTO Lecturers VALUES (13, 'Mr Z Marikkar', 'a', 1, true);
INSERT INTO Lecturers VALUES (14, 'Dr J Alawathugoda', 'a', 1, true);
INSERT INTO Lecturers VALUES (15, 'Mr K Himesh', 'a', 1, true);
INSERT INTO Lecturers VALUES (16, 'Dr M Sandirigama', 'a', 1, true);
INSERT INTO Lecturers VALUES (17, 'Dr EMN', 'a', 1, true);
INSERT INTO Lecturers VALUES (18, 'Dr VRH', 'a', 1, true);
INSERT INTO Lecturers VALUES (19, 'Dr HAS', 'a', 1, true);
INSERT INTO Lecturers VALUES (20, 'Dr JBE', 'a', 1, true);
INSERT INTO Lecturers VALUES (21, 'Dr WLA', 'a', 1, true);
INSERT INTO Lecturers VALUES (22, 'Dr DBR', 'a', 1, true);
INSERT INTO Lecturers VALUES (23, 'Dr DNU', 'a', 1, true);
INSERT INTO Lecturers VALUES (24, 'Dr KBN', 'a', 1, true);
INSERT INTO Lecturers VALUES (25, 'Dr JVW', 'a', 1, true);
INSERT INTO Lecturers VALUES (26, 'Dr RJK', 'a', 1, true);
INSERT INTO Lecturers VALUES (27, 'Dr SSK', 'a', 1, true);
INSERT INTO Lecturers VALUES (28, 'Dr PJB', 'a', 1, true);
INSERT INTO Lecturers VALUES (29, 'Dr AWG', 'a', 1, true);
INSERT INTO Lecturers VALUES (30, 'Dr MPB', 'a', 1, true);
INSERT INTO Lecturers VALUES (31, 'Dr LTS', 'a', 1, true);
INSERT INTO Lecturers VALUES (32, 'Dr RIG', 'a', 1, true);
INSERT INTO Lecturers VALUES (33, 'Dr RMF', 'a', 1, true);
INSERT INTO Lecturers VALUES (34, 'Dr WAL', 'a', 1, true);
INSERT INTO Lecturers VALUES (35, 'Dr KML', 'a', 1, true);
INSERT INTO Lecturers VALUES (36, 'Dr RIG', 'a', 1, true);
INSERT INTO Lecturers VALUES (37, 'Dr JR', 'a', 1, true);
INSERT INTO Lecturers VALUES (38, 'Dr AR', 'a', 1, true);
INSERT INTO Lecturers VALUES (39, 'Dr WPD', 'a', 1, true);
INSERT INTO Lecturers VALUES (40, 'Dr SPG', 'a', 1, true);
INSERT INTO Lecturers VALUES (41, 'Dr VG', 'a', 1, true);
INSERT INTO Lecturers VALUES (42, 'Dr PBB', 'a', 1, true);
INSERT INTO Lecturers VALUES (43, 'Dr TL', 'a', 1, true);
INSERT INTO Lecturers VALUES (44, 'Dr LR', 'a', 1, true);
INSERT INTO Lecturers VALUES (45, 'Dr DHSM', 'a', 1, true);
INSERT INTO Lecturers VALUES (46, 'Dr SKS', 'a', 1, true);
INSERT INTO Lecturers VALUES (47, 'Dr LUB', 'a', 1, true);
INSERT INTO Lecturers VALUES (48, 'Dr VL', 'a', 1, true);
INSERT INTO Lecturers VALUES (49, 'Dr KW', 'a', 1, true);
INSERT INTO Lecturers VALUES (50, 'Dr C.S. Kalpage', 'a', 1, true);
INSERT INTO Lecturers VALUES (51, 'Prof R. Shanthini', 'a', 1, true);
INSERT INTO Lecturers VALUES (52, 'Dr D.G.G.P. Karunarathne', 'a', 1, true);
INSERT INTO Lecturers VALUES (53, 'Ms. S.M.W.T.P.K. Ariyarathne', 'a', 1, true);
INSERT INTO Lecturers VALUES (54, 'Ms. MA Elangasinghe', 'a', 1, true);
INSERT INTO Lecturers VALUES (55, 'Ms. AWM Menike', 'a', 1, true);
INSERT INTO Lecturers VALUES (56, 'Dr S.G.P. Gunawardane', 'a', 1, true);


INSERT INTO Courses VALUES (1, 'PR204', 'Production 21', '3', false, 40);
INSERT INTO Courses VALUES (2, 'PR314', 'Production 31', '3', false, 30);
INSERT INTO Courses VALUES (3, 'PR315', 'Production 32', '3', false, 30);
INSERT INTO Courses VALUES (4, 'CO221', 'Computer 21', '3', false, 60);
INSERT INTO Courses VALUES (5, 'CO222', 'Computer 22', '3', false, 60);
INSERT INTO Courses VALUES (6, 'CO223', 'Computer 23', '3', false, 60);
INSERT INTO Courses VALUES (7, 'CO321', 'Computer 31', '3', false, 60);
INSERT INTO Courses VALUES (8, 'CO322', 'Computer 32', '3', false, 60);
INSERT INTO Courses VALUES (9, 'CO323', 'Computer 33', '3', false, 60);
INSERT INTO Courses VALUES (10, 'CO324', 'Computer 34', '3', false, 60);
INSERT INTO Courses VALUES (11, 'CO325', 'Computer 35', '3', false, 60);
INSERT INTO Courses VALUES (12, 'CO421', 'Computer 41', '3', false, 60);
INSERT INTO Courses VALUES (13, 'CO422', 'Computer 42', '3', false, 60);
INSERT INTO Courses VALUES (14, 'CO423', 'Computer 43', '3', false, 60);
INSERT INTO Courses VALUES (15, 'CO424', 'Computer 44', '3', false, 60);
INSERT INTO Courses VALUES (16, 'EE201', 'Elec 21', '3', false, 100);
INSERT INTO Courses VALUES (17, 'EE251', 'Elec 22', '3', false, 100);
INSERT INTO Courses VALUES (18, 'EE252', 'Elec 23', '3', false, 100);
INSERT INTO Courses VALUES (19, 'EE253', 'Elec 24', '3', false, 100);
INSERT INTO Courses VALUES (20, 'EE280', 'Elec Mech Prod', '3', false, 260);
INSERT INTO Courses VALUES (21, 'EE282', 'Elec Com 21', '3', false, 75);
INSERT INTO Courses VALUES (22, 'EE320', 'Elec 31', '3', false, 100);
INSERT INTO Courses VALUES (23, 'EE351', 'Elec 32', '3', false, 100);
INSERT INTO Courses VALUES (24, 'EE322', 'Elec 33', '3', false, 100);
INSERT INTO Courses VALUES (25, 'EE325', 'Elec 34', '3', false, 100);
INSERT INTO Courses VALUES (26, 'EE326', 'Elec 35', '3', false, 100);
INSERT INTO Courses VALUES (27, 'EE352', 'Elec 36', '3', false, 100);
INSERT INTO Courses VALUES (28, 'EE380', 'Elec Mech Prod', '3', false, 90);
INSERT INTO Courses VALUES (29, 'EE386', 'COM 31', '3', false, 75);
INSERT INTO Courses VALUES (30, 'EE401', 'Elec 41', '3', false, 100);
INSERT INTO Courses VALUES (31, 'EE402', 'Elec 42', '3', false, 100);
INSERT INTO Courses VALUES (32, 'EE403', 'Elec 43', '3', false, 25);
INSERT INTO Courses VALUES (33, 'EE404', 'Elec 44', '3', false, 100);
INSERT INTO Courses VALUES (34, 'ME202', 'Civil 21', '3', false, 150);
INSERT INTO Courses VALUES (35, 'ME211', 'Mech Chem Prod Elec', '3', false, 240);
INSERT INTO Courses VALUES (36, 'ME213', 'Mech prod', '3', false, 100);
INSERT INTO Courses VALUES (37, 'ME301', 'Mech Prod', '3', false, 90);
INSERT INTO Courses VALUES (38, 'ME303', 'Mech Chem', '3', false, 75);
INSERT INTO Courses VALUES (39, 'ME306', 'Mech Chem Prod', '3', false, 90);
INSERT INTO Courses VALUES (40, 'ME406', 'Mech 41', '3', false, 50);
INSERT INTO Courses VALUES (41, 'ME502', 'Mech t 41', '3', false, 30);
INSERT INTO Courses VALUES (42, 'ME512', 'Mech Chem', '3', false, 40);
INSERT INTO Courses VALUES (43, 'ME518', 'Mech t 42', '3', false, 50);
INSERT INTO Courses VALUES (44, 'ME520', 'Mech Chem Prod', '3', false, 75);
INSERT INTO Courses VALUES (45, 'CP201', 'Chem 21', '3', false, 25);
INSERT INTO Courses VALUES (46, 'CP303', 'Chem 31', '3', false, 25);
INSERT INTO Courses VALUES (47, 'CP502', 'Chem t31', '3', false, 25);
INSERT INTO Courses VALUES (48, 'CP513', 'Mech Chem', '3', false, 40);
INSERT INTO Courses VALUES (49, 'CP515', 'Chem t41', '3', false, 25);


INSERT INTO CourseLecturerMap VALUES (1,1,1);
INSERT INTO CourseLecturerMap VALUES (2,2,2);
INSERT INTO CourseLecturerMap VALUES (3,3,3);
INSERT INTO CourseLecturerMap VALUES (4,4,4);
INSERT INTO CourseLecturerMap VALUES (5,4,5);
INSERT INTO CourseLecturerMap VALUES (6,4,6);
INSERT INTO CourseLecturerMap VALUES (7,5,5);
INSERT INTO CourseLecturerMap VALUES (8,5,7);
INSERT INTO CourseLecturerMap VALUES (9,6,8);
INSERT INTO CourseLecturerMap VALUES (10,6,9);
INSERT INTO CourseLecturerMap VALUES (11,6,10);
INSERT INTO CourseLecturerMap VALUES (12,7,11);
INSERT INTO CourseLecturerMap VALUES (13,7,5);
INSERT INTO CourseLecturerMap VALUES (14,7,7);
INSERT INTO CourseLecturerMap VALUES (15,8,12);
INSERT INTO CourseLecturerMap VALUES (16,8,7);
INSERT INTO CourseLecturerMap VALUES (17,9,12);
INSERT INTO CourseLecturerMap VALUES (18,9,9);
INSERT INTO CourseLecturerMap VALUES (19,10,13);
INSERT INTO CourseLecturerMap VALUES (20,10,8);
INSERT INTO CourseLecturerMap VALUES (21,10,14);
INSERT INTO CourseLecturerMap VALUES (22,10,15);
INSERT INTO CourseLecturerMap VALUES (23,11,12);
INSERT INTO CourseLecturerMap VALUES (24,11,16);
INSERT INTO CourseLecturerMap VALUES (25,11,14);
INSERT INTO CourseLecturerMap VALUES (26,12,6);
INSERT INTO CourseLecturerMap VALUES (27,13,16);
INSERT INTO CourseLecturerMap VALUES (28,13,4);
INSERT INTO CourseLecturerMap VALUES (29,13,13);
INSERT INTO CourseLecturerMap VALUES (30,14,16);
INSERT INTO CourseLecturerMap VALUES (31,14,12);
INSERT INTO CourseLecturerMap VALUES (32,15,16);
INSERT INTO CourseLecturerMap VALUES (33,15,12);
INSERT INTO CourseLecturerMap VALUES (34,16,17);
INSERT INTO CourseLecturerMap VALUES (35,16,18);
INSERT INTO CourseLecturerMap VALUES (36,16,19);
INSERT INTO CourseLecturerMap VALUES (37,17,20);
INSERT INTO CourseLecturerMap VALUES (38,18,21);
INSERT INTO CourseLecturerMap VALUES (39,18,22);
INSERT INTO CourseLecturerMap VALUES (40,18,23);
INSERT INTO CourseLecturerMap VALUES (41,19,24);
INSERT INTO CourseLecturerMap VALUES (42,19,25);
INSERT INTO CourseLecturerMap VALUES (43,20,26);
INSERT INTO CourseLecturerMap VALUES (44,20,27);
INSERT INTO CourseLecturerMap VALUES (45,21,17);
INSERT INTO CourseLecturerMap VALUES (46,21,18);
INSERT INTO CourseLecturerMap VALUES (47,21,19);
INSERT INTO CourseLecturerMap VALUES (48,22,23);
INSERT INTO CourseLecturerMap VALUES (49,22,27);
INSERT INTO CourseLecturerMap VALUES (50,23,28);
INSERT INTO CourseLecturerMap VALUES (51,23,29);
INSERT INTO CourseLecturerMap VALUES (52,24,19);
INSERT INTO CourseLecturerMap VALUES (53,24,25);
INSERT INTO CourseLecturerMap VALUES (54,25,30);
INSERT INTO CourseLecturerMap VALUES (55,25,22);
INSERT INTO CourseLecturerMap VALUES (56,26,28);
INSERT INTO CourseLecturerMap VALUES (57,26,31);
INSERT INTO CourseLecturerMap VALUES (58,27,28);
INSERT INTO CourseLecturerMap VALUES (59,27,31);
INSERT INTO CourseLecturerMap VALUES (60,27,32);
INSERT INTO CourseLecturerMap VALUES (61,28,33);
INSERT INTO CourseLecturerMap VALUES (62,28,26);
INSERT INTO CourseLecturerMap VALUES (63,28,27);
INSERT INTO CourseLecturerMap VALUES (64,29,34);
INSERT INTO CourseLecturerMap VALUES (65,29,28);
INSERT INTO CourseLecturerMap VALUES (66,29,35);
INSERT INTO CourseLecturerMap VALUES (67,30,36);
INSERT INTO CourseLecturerMap VALUES (68,30,17);
INSERT INTO CourseLecturerMap VALUES (69,30,19);
INSERT INTO CourseLecturerMap VALUES (70,31,30);
INSERT INTO CourseLecturerMap VALUES (71,31,31);
INSERT INTO CourseLecturerMap VALUES (72,32,21);
INSERT INTO CourseLecturerMap VALUES (73,32,18);
INSERT INTO CourseLecturerMap VALUES (74,33,33);
INSERT INTO CourseLecturerMap VALUES (75,33,20);
INSERT INTO CourseLecturerMap VALUES (76,34,37);
INSERT INTO CourseLecturerMap VALUES (77,34,38);
INSERT INTO CourseLecturerMap VALUES (78,34,39);
INSERT INTO CourseLecturerMap VALUES (79,34,40);
INSERT INTO CourseLecturerMap VALUES (80,34,41);
INSERT INTO CourseLecturerMap VALUES (81,35,38);
INSERT INTO CourseLecturerMap VALUES (82,35,40);
INSERT INTO CourseLecturerMap VALUES (83,35,42);
INSERT INTO CourseLecturerMap VALUES (84,36,38);
INSERT INTO CourseLecturerMap VALUES (85,36,42);
INSERT INTO CourseLecturerMap VALUES (86,37,40);
INSERT INTO CourseLecturerMap VALUES (87,37,42);
INSERT INTO CourseLecturerMap VALUES (88,37,38);
INSERT INTO CourseLecturerMap VALUES (89,37,43);
INSERT INTO CourseLecturerMap VALUES (90,38,39);
INSERT INTO CourseLecturerMap VALUES (91,38,44);
INSERT INTO CourseLecturerMap VALUES (92,38,40);
INSERT INTO CourseLecturerMap VALUES (93,38,43);
INSERT INTO CourseLecturerMap VALUES (94,39,42);
INSERT INTO CourseLecturerMap VALUES (95,39,38);
INSERT INTO CourseLecturerMap VALUES (96,40,45);
INSERT INTO CourseLecturerMap VALUES (97,40,42);
INSERT INTO CourseLecturerMap VALUES (98,41,37);
INSERT INTO CourseLecturerMap VALUES (99,41,46);
INSERT INTO CourseLecturerMap VALUES (100,42,40);
INSERT INTO CourseLecturerMap VALUES (101,42,44);
INSERT INTO CourseLecturerMap VALUES (102,42,47);
INSERT INTO CourseLecturerMap VALUES (103,42,48);
INSERT INTO CourseLecturerMap VALUES (104,42,38);
INSERT INTO CourseLecturerMap VALUES (105,43,45);
INSERT INTO CourseLecturerMap VALUES (106,44,38);
INSERT INTO CourseLecturerMap VALUES (107,44,49);
INSERT INTO CourseLecturerMap VALUES (108,44,43);
INSERT INTO CourseLecturerMap VALUES (109,45,50);
INSERT INTO CourseLecturerMap VALUES (110,45,51);
INSERT INTO CourseLecturerMap VALUES (111,45,52);
INSERT INTO CourseLecturerMap VALUES (112,45,53);
INSERT INTO CourseLecturerMap VALUES (113,46,54);
INSERT INTO CourseLecturerMap VALUES (114,46,50);
INSERT INTO CourseLecturerMap VALUES (115,46,51);
INSERT INTO CourseLecturerMap VALUES (116,46,55);
INSERT INTO CourseLecturerMap VALUES (117,47,51);
INSERT INTO CourseLecturerMap VALUES (118,47,52);
INSERT INTO CourseLecturerMap VALUES (119,47,55);
INSERT INTO CourseLecturerMap VALUES (120,48,52);
INSERT INTO CourseLecturerMap VALUES (121,48,50);
INSERT INTO CourseLecturerMap VALUES (122,48,56);
INSERT INTO CourseLecturerMap VALUES (123,49,51);
INSERT INTO CourseLecturerMap VALUES (124,49,52);
INSERT INTO CourseLecturerMap VALUES (125,49,54);

INSERT INTO Groups VALUES (1,40); --prod 2nd year --PR204 
INSERT INTO Groups VALUES (2,30); --Prod 3rd year --PR314,PR315
INSERT INTO Groups VALUES (3,60); --Com 2nd year --CO221,CO222,CO223
INSERT INTO Groups VALUES (4,60); --Com 3rd year --CO321, CO322, CO323, CO324, CO325
INSERT INTO Groups VALUES (5,60); --Com 4th year --CO421, CO422, CO423, CO424
INSERT INTO Groups VALUES (6,100); -- Elec 2nd year
INSERT INTO Groups VALUES (7,100); -- Elec 3rd year
INSERT INTO Groups VALUES (8,100); -- Elec 4th year
INSERT INTO Groups VALUES (9,150); -- Civil 2nd year
INSERT INTO Groups VALUES (10,150); -- Civil 3rd year
INSERT INTO Groups VALUES (11,150); -- Civil 4th year
INSERT INTO Groups VALUES (12,25); -- Chem 2nd year
INSERT INTO Groups VALUES (13,25); -- Chem 3rd year
INSERT INTO Groups VALUES (14,25); -- Chem 4th year
INSERT INTO Groups VALUES (15,40); -- Mech 2nd year
INSERT INTO Groups VALUES (16,40); -- Mech 3rd year
INSERT INTO Groups VALUES (17,40); -- Mech 4th year
INSERT INTO Groups VALUES (18, 30); -- Prod 4th year 


INSERT INTO GroupCourseMap VALUES (1,1,1);
INSERT INTO GroupCourseMap VALUES (2,1,20);
INSERT INTO GroupCourseMap VALUES (3,2,2);
INSERT INTO GroupCourseMap VALUES (4,2,3);
INSERT INTO GroupCourseMap VALUES (5,2,28);
INSERT INTO GroupCourseMap VALUES (6,3,4);
INSERT INTO GroupCourseMap VALUES (7,3,5);
INSERT INTO GroupCourseMap VALUES (8,3,6);
INSERT INTO GroupCourseMap VALUES (9,3,21);
INSERT INTO GroupCourseMap VALUES (10,4,7);
INSERT INTO GroupCourseMap VALUES (11,4,8);
INSERT INTO GroupCourseMap VALUES (12,4,9);
INSERT INTO GroupCourseMap VALUES (13,4,10);
INSERT INTO GroupCourseMap VALUES (14,4,11);
INSERT INTO GroupCourseMap VALUES (15,4,29);
INSERT INTO GroupCourseMap VALUES (16,5,12);
INSERT INTO GroupCourseMap VALUES (17,5,13);
INSERT INTO GroupCourseMap VALUES (18,5,14);
INSERT INTO GroupCourseMap VALUES (19,5,15);
INSERT INTO GroupCourseMap VALUES (20,6,16);
INSERT INTO GroupCourseMap VALUES (21,6,17);
INSERT INTO GroupCourseMap VALUES (22,6,18);
INSERT INTO GroupCourseMap VALUES (23,6,19);
INSERT INTO GroupCourseMap VALUES (24,6,20);
INSERT INTO GroupCourseMap VALUES (25,6,21);
INSERT INTO GroupCourseMap VALUES (26,7,22);
INSERT INTO GroupCourseMap VALUES (27,7,23);
INSERT INTO GroupCourseMap VALUES (28,7,24);
INSERT INTO GroupCourseMap VALUES (29,7,25);
INSERT INTO GroupCourseMap VALUES (30,7,26);
INSERT INTO GroupCourseMap VALUES (31,7,27);
INSERT INTO GroupCourseMap VALUES (32,7,28);
INSERT INTO GroupCourseMap VALUES (33,8,30);
INSERT INTO GroupCourseMap VALUES (34,8,31);
INSERT INTO GroupCourseMap VALUES (35,8,32);
INSERT INTO GroupCourseMap VALUES (36,8,33);
INSERT INTO GroupCourseMap VALUES (37,9,34);
INSERT INTO GroupCourseMap VALUES (38,12,34);
INSERT INTO GroupCourseMap VALUES (39,6,34);
INSERT INTO GroupCourseMap VALUES (40,15,34);
INSERT INTO GroupCourseMap VALUES (41,1,34);
INSERT INTO GroupCourseMap VALUES (42,1,36);
INSERT INTO GroupCourseMap VALUES (43,15,36);
INSERT INTO GroupCourseMap VALUES (44,2,37);
INSERT INTO GroupCourseMap VALUES (45,16,37);
INSERT INTO GroupCourseMap VALUES (46,13,38);
INSERT INTO GroupCourseMap VALUES (47,16,38);
INSERT INTO GroupCourseMap VALUES (48,13,39);
INSERT INTO GroupCourseMap VALUES (49,2,39);
INSERT INTO GroupCourseMap VALUES (50,16,39);
INSERT INTO GroupCourseMap VALUES (51,17,40);
INSERT INTO GroupCourseMap VALUES (52,17,41);
INSERT INTO GroupCourseMap VALUES (53,14,42);
INSERT INTO GroupCourseMap VALUES (54,17,42);
INSERT INTO GroupCourseMap VALUES (55,16,43);
INSERT INTO GroupCourseMap VALUES (56,17,43);
INSERT INTO GroupCourseMap VALUES (57,16,44);
INSERT INTO GroupCourseMap VALUES (58,17,44);
INSERT INTO GroupCourseMap VALUES (59,17,44);
INSERT INTO GroupCourseMap VALUES (60,15,20);
INSERT INTO GroupCourseMap VALUES (61,7,28);
INSERT INTO GroupCourseMap VALUES (62,12,45);
INSERT INTO GroupCourseMap VALUES (63,13,46);
INSERT INTO GroupCourseMap VALUES (64,13,47);
INSERT INTO GroupCourseMap VALUES (65,14,48);
INSERT INTO GroupCourseMap VALUES (66,17,48);
INSERT INTO GroupCourseMap VALUES (67,14,49);