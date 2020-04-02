# db_teacher
DROP SCHEMA IF EXISTS db_teacher;
CREATE SCHEMA db_teacher;
USE db_teacher;

CREATE TABLE `teacher`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张三');
INSERT INTO `teacher` VALUES (2, '李四');
INSERT INTO `teacher` VALUES (3, '王五');

SET FOREIGN_KEY_CHECKS = 1;

# db_course
DROP SCHEMA IF EXISTS db_course;
CREATE SCHEMA db_course;
USE db_course;
CREATE TABLE `course`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '语文', 2);
INSERT INTO `course` VALUES (2, '数学', 1);
INSERT INTO `course` VALUES (3, '英语', 3);
INSERT INTO `course` VALUES (4, '语文', 4);
INSERT INTO `course` VALUES (5, '数学', 5);
INSERT INTO `course` VALUES (6, '语文', 6);
INSERT INTO `course` VALUES (7, '数学', 7);

SET FOREIGN_KEY_CHECKS = 1;


# db_student
DROP SCHEMA IF EXISTS db_student;
CREATE SCHEMA db_student;
USE db_student;

CREATE TABLE `sc`  (
  `sid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (2, 1, 70);
INSERT INTO `sc` VALUES (2, 2, 60);
INSERT INTO `sc` VALUES (2, 3, 80);
INSERT INTO `sc` VALUES (3, 1, 80);
INSERT INTO `sc` VALUES (3, 2, 80);
INSERT INTO `sc` VALUES (3, 3, 80);
INSERT INTO `sc` VALUES (4, 1, 50);
INSERT INTO `sc` VALUES (4, 2, 30);
INSERT INTO `sc` VALUES (4, 3, 20);
INSERT INTO `sc` VALUES (5, 1, 76);
INSERT INTO `sc` VALUES (5, 2, 87);
INSERT INTO `sc` VALUES (6, 1, 31);
INSERT INTO `sc` VALUES (6, 3, 34);
INSERT INTO `sc` VALUES (7, 2, 89);
INSERT INTO `sc` VALUES (7, 3, 98);


CREATE TABLE `student`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sage` int(11) DEFAULT NULL,
  `ssex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '赵雷', 19900101, '男');
INSERT INTO `student` VALUES (2, '田电', 19901221, '男');
INSERT INTO `student` VALUES (3, '孙风', 19900520, '男');
INSERT INTO `student` VALUES (4, '李云', 19900806, '男');
INSERT INTO `student` VALUES (5, '周梅', 19911201, '女');
INSERT INTO `student` VALUES (6, '吴兰', 19920301, '女');
INSERT INTO `student` VALUES (7, '郑竹', 19890701, '女');
INSERT INTO `student` VALUES (8, '王菊', 19900120, '女');

SET FOREIGN_KEY_CHECKS = 1;
