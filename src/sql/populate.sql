INSERT INTO users(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authorities (ID,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authorities (ID,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authorities (ID,username, authority) VALUES (3,'admin', 'ROLE_USER');
 

INSERT INTO `location` VALUES (1,'442 Glenwood Avenue','Culver City','CA', '87547');
INSERT INTO `location` VALUES (2,'1 Yellow Brook Road','Emerald City','OZ', '12345');

INSERT INTO `review` VALUES ('VERY GOOD','ALI','RAZA','4', 4);
 
INSERT INTO `xemployee` VALUES (1,12, 8754,'Curious','George','Boy Monkey',1,"guest");
INSERT INTO `xemployee` VALUES (2,123, 8733,'Allen','Rench','Torque Master',2,"admin");

INSERT INTO `roomtype` VALUES (1, 'single', 50);
INSERT INTO `roomtype` VALUES (2, 'double', 70);
INSERT INTO `roomtype` VALUES (3, 'triple', 100);
INSERT INTO `roomtype` VALUES (4, 'family', 150);

INSERT INTO `viewtype` VALUES (5, 'lake', 30);
INSERT INTO `viewtype` VALUES (6, 'city', 10);
INSERT INTO `viewtype` VALUES (7, 'none', 0);

INSERT INTO `address` VALUES ('Fairfield', 'john@gmail.com', '123-234-5677', 'Iowa', 'First', '56789');
					