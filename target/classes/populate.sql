#Room Types
INSERT INTO `roomtype` VALUES (1, 'single', 50);
INSERT INTO `roomtype` VALUES (2, 'double', 70);
INSERT INTO `roomtype` VALUES (3, 'triple', 100);
INSERT INTO `roomtype` VALUES (4, 'suit', 150);

#Room View Types
INSERT INTO `viewtype` VALUES (1, 'lobby', 0);
INSERT INTO `viewtype` VALUES (2, 'city', 10);
INSERT INTO `viewtype` VALUES (3, 'lake', 20);
INSERT INTO `viewtype` VALUES (4, 'round', 30);

#Rooms
INSERT INTO `room` VALUES (1, 50, 'RM001', 1, 1);
INSERT INTO `room` VALUES (2, 80, 'RM002', 2, 2);
INSERT INTO `room` VALUES (3, 120, 'RM003', 3, 3);
INSERT INTO `room` VALUES (4, 180, 'RM004', 4, 4);

#Addresses
INSERT INTO `address` VALUES (1, 'Fairfield', 'doe@fairfield.com', '456-678-8765', 'IA', 'First', '56789');
INSERT INTO `address` VALUES (2, 'Dallas', 'john@dallas.com', '654-678-8765', 'TX', 'West', '75789');
INSERT INTO `address` VALUES (3, 'Dallas', 'john@dallas.com', '654-678-8765', 'TX', 'East', '75789');
INSERT INTO `address` VALUES (4, 'Dallas', 'john@dallas.com', '654-678-8765', 'TX', 'Third', '75789');

#Authorities (Roles)
INSERT INTO `authority` VALUES (1, 'ADMIN');
INSERT INTO `authority` VALUES (2, 'CUSTOMER');

#Credentials
INSERT INTO `credentials` VALUES (1, 1, 'admin', 'Kaleb', 'admin', '1');
INSERT INTO `credentials` VALUES (2, 1, 'guest', 'Daniel', 'guest', '2');
INSERT INTO `credentials` VALUES (3, 1, 'guest', 'Sibtain', 'guest', '3');
INSERT INTO `credentials` VALUES (4, 1, 'admin', 'Mihreteab', 'admin', '4');

#Users (ADMIN)
INSERT INTO `user` VALUES (1, 'Kaleb', 'Workneh', 'UR001', 1, 1);
INSERT INTO `user` VALUES (4, 'Mihreteab', 'Kidane', 'UR004', 4, 1);

#Users (CUSTOMER)
INSERT INTO `user` VALUES (2, 'Daniel', 'Abraha', 'UR002', 2, 2);
INSERT INTO `user` VALUES (3, 'Sibtain', 'Raza', 'UR003', 3, 2);

#Bookings
INSERT INTO `booking` VALUES (1, 'BK001', '12-22-2020', '12-28-2020', 1, 0, 60, 2, 1);
INSERT INTO `booking` VALUES (2, 'BK002', '13-22-2020', '13-28-2020', 0, 1, 90, 3, 2);

#Reviews
INSERT INTO `review` VALUES (1, 'This was a nice stay', 'Kaleb', 'Workneh', 5, RV001);
INSERT INTO `review` VALUES (2, 'Very poor customer service', 'Daniel', 'Abraha', 5, RV001);
					