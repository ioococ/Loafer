/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 10/11/2023 19:20:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` datetime NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createdate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, '1970-01-01 00:00:00');
INSERT INTO `users` VALUES (2, 'Julia Henry', '[?X9rh>eNT{&3*q', '女', '14488123297', 'jhe@icloud.com', '1999-11-28 03:28:32', 'Victor Jones', '2020-05-17 15:39:13');
INSERT INTO `users` VALUES (3, 'Virginia Gardner', 'm1_GjwI0ePH5`F;', '女', '527815646', 'gardvirg@gmail.com', '2003-03-24 02:17:59', 'Rodney Powell', '2020-01-29 11:52:22');
INSERT INTO `users` VALUES (4, '侯杰宏', 'W:%#5cY&|m>h-\"}', '男', '741172920', 'jieho4@onei.onei', '1998-02-25 13:41:49', 'Bonnie Griffin', '2020-01-17 08:11:02');
INSERT INTO `users` VALUES (5, 'Harold Chen', 'dvE5k=JGTcVRL.q', '男', '8066332759', 'chen222@qq.com', '1998-07-07 20:19:31', 'Tina Aguilar', '2022-03-16 02:39:00');
INSERT INTO `users` VALUES (6, 'Liao Lu', 'su\'O>pdh*LC!DBU', '女', '2877900605', 'luliao@onei.onei', '2002-09-28 05:23:00', 'David Gibson', '2022-07-29 07:12:23');
INSERT INTO `users` VALUES (7, 'Arthur Davis', '!I52<^A`}>i&/c.', '男', '8069979547', 'daart1@icloud.com', '2000-08-20 16:19:37', 'Raymond Garcia', '2021-07-13 20:37:44');
INSERT INTO `users` VALUES (8, 'Wu Lu', 'd`TSq<OzXm-:CHI', '女', '218298917', 'luwu@yahoo.com', '2001-11-04 08:18:18', 'Rodney Griffin', '2022-06-27 00:39:25');
INSERT INTO `users` VALUES (9, '彭璐', '4XHoCGw@j_A;b=}', '女', '13387971175', 'peng7@gmail.com', '2001-03-02 02:21:25', 'Bernard Castillo', '2021-04-23 15:48:09');
INSERT INTO `users` VALUES (10, 'Xie Lan', '|sB82cE6SyigtFR', '女', '9045676215', 'xie4@outlook.com', '1999-05-06 07:18:05', 'Glenn Bryant', '2023-11-05 00:12:13');
INSERT INTO `users` VALUES (11, 'Jason Bailey', 'NIPY_M&7<-AC,^D', '男', '526871693', 'bailey9@qq.com', '1999-07-31 06:22:24', 'Alice Chavez', '2023-01-12 02:09:24');
INSERT INTO `users` VALUES (12, 'Irene Reed', 'k3Lp?Y`dFwb1OHo', '女', '19364648730', 'irener@gmail.com', '1998-01-30 14:36:40', 'Joseph Tran', '2022-01-31 00:29:51');
INSERT INTO `users` VALUES (13, '孙震南', ';f6Wt/g\'M<m9\\~a', '男', '2878847326', 'suzhennan812@hotmail.com', '1999-04-25 13:38:40', 'Norman Cooper', '2020-11-07 06:28:29');
INSERT INTO `users` VALUES (14, 'Julia Bennett', '4RH%V:DcC\\ei-J6', '女', '18922919769', 'juliabennett@gmail.com', '2002-04-08 01:45:19', 'Carolyn Anderson', '2021-07-07 07:40:49');
INSERT INTO `users` VALUES (15, '廖震南', 'bk[^<Ly{nG.7m5g', '男', '118087854', 'lizhennan@outlook.com', '1998-07-08 19:51:38', 'Stanley Soto', '2022-07-31 19:04:39');
INSERT INTO `users` VALUES (16, 'Shao Yuning', ')+D/J-\'hyqz4i1<', '男', '13987848127', 'shao1@gmail.com', '2003-03-01 13:31:03', 'Angela Kennedy', '2022-06-11 21:07:11');
INSERT INTO `users` VALUES (17, 'Wang Zhennan', 'wTM2rXZ&3DO#j$<', '男', '8043321817', 'zhennan8@msn.com', '2000-08-11 16:38:09', 'Jennifer Porter', '2022-11-12 15:29:42');
INSERT INTO `users` VALUES (18, 'Lu Rui', 'nk\")f\'D]JFe9a:Y', '男', '15561031172', 'rulu10@outlook.com', '2001-07-07 23:51:20', 'Ray Miller', '2023-08-30 06:48:39');
INSERT INTO `users` VALUES (19, 'Wu Jiehong', 'gty/9H%@zps>(dL', '男', '1024243915', 'wu1@msn.com', '2000-11-13 17:41:12', 'Beverly Gonzalez', '2023-03-05 10:51:17');
INSERT INTO `users` VALUES (20, 'Shi Xiaoming', '}^=~ek\"+A-T/_$I', '男', '205390093', 'xiaomingsh7@outlook.com', '2003-09-05 04:40:29', 'Dawn Ramos', '2021-09-03 17:28:57');
INSERT INTO `users` VALUES (21, '汪詩涵', 'VN_6.dI^xq@Z-gE', '女', '9028539988', 'shihanwang@outlook.com', '1999-07-03 08:38:22', 'Kelly Price', '2022-03-01 01:13:18');
INSERT INTO `users` VALUES (22, '邹杰宏', '|6`!eW/uT~aZdUR', '男', '1021685810', 'zoj@msn.com', '1999-02-20 22:26:25', 'Dorothy Wright', '2021-03-12 02:26:27');
INSERT INTO `users` VALUES (23, 'Hu Xiaoming', '<4:={Z3*v_L\\,gl', '男', '13745123442', 'huxiao@onei.onei', '2003-05-16 10:03:08', 'Manuel Lee', '2020-11-15 12:03:31');
INSERT INTO `users` VALUES (24, '崔子韬', 'l}Wb6(aj^)qyTM<', '男', '75561796179', 'cuiz@outlook.com', '2001-05-01 23:15:37', 'Esther Kelly', '2023-05-15 09:49:25');
INSERT INTO `users` VALUES (25, '薛詩涵', '4`1TRUs_v-wkfDX', '女', '18049487754', 'xue5@gmail.com', '2002-01-22 18:20:24', 'Sandra Silva', '2022-06-14 07:59:09');
INSERT INTO `users` VALUES (26, 'Long Rui', 'Qg\"`~m>P!Hdhi\\0', '男', '2037924010', 'lonrui95@outlook.com', '1999-04-16 07:26:25', 'Jimmy Edwards', '2023-09-20 10:27:49');
INSERT INTO `users` VALUES (27, 'Johnny Porter', 'iq\\Q#,x^;vCo%&w', '男', '103553765', 'pojohnny@msn.com', '2002-12-01 10:36:20', 'Barry Harris', '2020-08-08 22:11:32');
INSERT INTO `users` VALUES (28, 'Duan Anqi', 'M*\'IB{Zkdg<^P!N', '女', '16414249824', 'danqi10@outlook.com', '2000-01-31 05:30:57', 'Tracy Rivera', '2021-09-06 18:41:42');
INSERT INTO `users` VALUES (29, '钟詩涵', '$>=+.Iaj46dBfr3', '女', '660892762', 'zhonshihan@icloud.com', '2002-04-23 16:45:22', 'Anne Medina', '2022-05-11 18:14:15');
INSERT INTO `users` VALUES (30, 'Yan Jiehong', '}%?kgIL8l1Aihxy', '男', '19449971965', 'jiehya5@gmail.com', '1998-04-08 10:39:46', 'Alfred Henry', '2020-08-07 22:18:15');
INSERT INTO `users` VALUES (31, 'Meng Yuning', 'rdBD>-L@y#`|[S1', '男', '2875620592', 'meng927@icloud.com', '2000-05-16 15:15:06', 'Victoria Schmidt', '2023-01-28 02:56:09');
INSERT INTO `users` VALUES (32, 'Jesus Harrison', 'tUO1f!>:\\j8<rZ*', '男', '7074673337', 'jesus1951@gmail.com', '2000-04-20 14:08:53', 'Theodore Jenkins', '2020-01-15 18:16:23');
INSERT INTO `users` VALUES (33, 'Edward Tucker', '{=<|)`4*\\#YuSHp', '男', '7060318110', 'edwardtu7@icloud.com', '1998-03-19 08:49:33', 'Randall Dixon', '2022-04-20 09:26:11');
INSERT INTO `users` VALUES (34, '许震南', '0i@\"){Z];|Fv<9H', '男', '528054226', 'zhennan47@gmail.com', '1999-11-08 14:02:26', 'Jason Thomas', '2021-11-09 10:55:35');
INSERT INTO `users` VALUES (35, 'Dong Zitao', '[k3FK?)W^Jb_I,*', '男', '9071011487', 'zitao223@hotmail.com', '2003-07-05 12:31:36', 'Earl Daniels', '2022-04-15 01:34:25');
INSERT INTO `users` VALUES (36, 'Wang Anqi', '@A}9&#(dJ2jTzvF', '女', '529938681', 'wanganqi1970@outlook.com', '2000-05-12 11:38:16', 'Herbert James', '2023-06-27 10:44:15');
INSERT INTO `users` VALUES (37, '熊震南', ']_8TZJc}{os/;za', '男', '9063730447', 'xiongzhe@gmail.com', '1999-03-17 00:27:51', 'Connie Bryant', '2022-06-26 12:33:01');
INSERT INTO `users` VALUES (38, 'Fu Jiehong', 'Za4][;\"%g2FW>G|', '男', '9001395744', 'jiehofu@onei.onei', '2003-08-17 12:57:41', 'Barbara Garcia', '2020-11-25 00:50:33');
INSERT INTO `users` VALUES (39, 'Wang Zhennan', 'Zgvm=5/Iaj1q9Ft', '男', '7069962606', 'wangz@outlook.com', '2002-05-08 09:40:56', 'Louise Garcia', '2020-05-30 19:20:32');
INSERT INTO `users` VALUES (40, 'Cui Yuning', 'WMH0IXN&S^\\n`\'f', '男', '2082651687', 'cuyu@msn.com', '2002-12-31 00:33:16', 'Marie Parker', '2021-07-29 18:03:09');
INSERT INTO `users` VALUES (41, '龙嘉伦', '2[W?O-Q!~i5|q;H', '男', '2036414466', 'longji@outlook.com', '2000-07-20 17:08:26', 'Carolyn Sanchez', '2022-03-27 17:58:29');
INSERT INTO `users` VALUES (42, '李詩涵', '!XBpI`}$4nxrW<V', '女', '7698469187', 'shihal@outlook.com', '2003-03-25 21:52:35', 'Katherine Johnson', '2021-04-26 14:44:58');
INSERT INTO `users` VALUES (43, 'Gu Jialun', 'Scv^bpX0A!e>RsY', '男', '7691604413', 'gujialun120@icloud.com', '2002-07-29 14:38:41', 'Elizabeth Lee', '2021-05-23 07:31:57');
INSERT INTO `users` VALUES (44, 'Rita Lewis', 'wBT#?v\\{o9-;~M^', '女', '104713290', 'lewis121@gmail.com', '2000-02-11 02:09:25', 'Jeffery Gonzales', '2023-03-08 05:01:28');
INSERT INTO `users` VALUES (45, '毛嘉伦', 'o:E3G%@}tMuq(&L', '男', '665917810', 'jialunmao5@gmail.com', '1999-03-24 10:01:46', 'Tiffany Simmons', '2020-08-20 08:25:33');
INSERT INTO `users` VALUES (46, 'Walter Rice', 'h<ny$1~DSHJ=olV', '男', '7603270410', 'walterric@icloud.com', '1998-01-09 00:28:14', 'Rhonda Ellis', '2023-10-02 10:21:52');
INSERT INTO `users` VALUES (47, 'Edna Webb', '0nBpTKb9{?CYr/`', '女', '8095367698', 'ednawebb@yahoo.com', '2000-08-16 03:49:35', 'Stephen Rodriguez', '2023-10-03 06:53:27');
INSERT INTO `users` VALUES (48, '汪子异', '[+.37;_\'FJ>52|u', '男', '18021261774', 'wang627@gmail.com', '2000-02-17 18:01:06', 'Monica Butler', '2022-07-17 07:59:50');
INSERT INTO `users` VALUES (49, 'Charles Ramos', 'i\"b2g/c5x%[tCUP', '男', '16168619055', 'charles11@mail.com', '2001-07-11 04:39:35', 'Craig Hernandez', '2022-05-26 18:56:48');
INSERT INTO `users` VALUES (50, 'Frances Ferguson', '1qo<F)hJy%\'0pn4', '女', '18532140076', 'ferguson305@onei.onei', '2001-01-07 18:49:49', 'Anne West', '2021-05-01 18:16:14');

SET FOREIGN_KEY_CHECKS = 1;
