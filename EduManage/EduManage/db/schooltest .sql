/*
Navicat MySQL Data Transfer

Source Server         : MyPl
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : schooltest

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-04-26 12:28:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collage
-- ----------------------------
DROP TABLE IF EXISTS `collage`;
CREATE TABLE `collage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collage
-- ----------------------------
INSERT INTO `collage` VALUES ('1', '信息工程');
INSERT INTO `collage` VALUES ('2', '计算机');
INSERT INTO `collage` VALUES ('3', '自动化');
INSERT INTO `collage` VALUES ('4', '机电');
INSERT INTO `collage` VALUES ('5', '轻工化工');

-- ----------------------------
-- Table structure for command
-- ----------------------------
DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuId` int(11) NOT NULL,
  `subId` int(11) NOT NULL,
  `teaId` int(11) NOT NULL,
  `com` varchar(50) COLLATE utf8_bin NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `result_fk_stu` (`stuId`),
  KEY `result_fk_sub` (`subId`),
  KEY `result_fk_tea` (`teaId`),
  CONSTRAINT `command_ibfk_1` FOREIGN KEY (`teaId`) REFERENCES `teacher` (`id`),
  CONSTRAINT `command_ibfk_2` FOREIGN KEY (`stuId`) REFERENCES `student` (`id`),
  CONSTRAINT `command_ibfk_3` FOREIGN KEY (`subId`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of command
-- ----------------------------
INSERT INTO `command` VALUES ('22', '1001', '10', '2001', '老师棒棒哒', '4');
INSERT INTO `command` VALUES ('23', '1002', '10', '2001', '这老师可以得', '5');
INSERT INTO `command` VALUES ('24', '1003', '10', '2001', '还可以吧！', '3');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subId` int(11) NOT NULL,
  `teaId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  `classno` int(11) NOT NULL,
  `majorId` int(11) NOT NULL,
  `week` varchar(20) COLLATE utf8_bin NOT NULL,
  `room` varchar(20) COLLATE utf8_bin NOT NULL,
  `weekday` int(11) NOT NULL,
  `timepoint` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_fk_sub` (`subId`),
  KEY `course_fk_tea` (`teaId`),
  KEY `course_fk_grade` (`gradeId`),
  KEY `course_fk_major` (`majorId`),
  CONSTRAINT `course_fk_grade` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`id`),
  CONSTRAINT `course_fk_major` FOREIGN KEY (`majorId`) REFERENCES `major` (`id`),
  CONSTRAINT `course_fk_sub` FOREIGN KEY (`subId`) REFERENCES `subject` (`id`),
  CONSTRAINT `course_fk_tea` FOREIGN KEY (`teaId`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('10', '1', '2001', '3', '4', '1', '1-15', '教4-212', '1', '1');
INSERT INTO `course` VALUES ('12', '2', '2002', '3', '4', '1', '1-15周', '教2-527', '1', '3');
INSERT INTO `course` VALUES ('13', '8', '2005', '3', '4', '1', '1-15周', '教4-210', '1', '2');
INSERT INTO `course` VALUES ('14', '9', '2004', '3', '4', '1', '8-15周', '教1-403', '2', '2');
INSERT INTO `course` VALUES ('15', '1', '2001', '3', '4', '1', '5-8周', '教2-319', '3', '1');
INSERT INTO `course` VALUES ('16', '3', '2007', '3', '4', '1', '1-16周', '教2-515', '3', '4');
INSERT INTO `course` VALUES ('17', '4', '2008', '3', '4', '1', '1-16周', '教1-419', '5', '1');
INSERT INTO `course` VALUES ('18', '3', '2007', '3', '4', '1', '10-14周', '教1-403', '5', '2');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '大一');
INSERT INTO `grade` VALUES ('2', '大二');
INSERT INTO `grade` VALUES ('3', '大三');
INSERT INTO `grade` VALUES ('4', '大四');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `colId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `major_fk_col` (`colId`),
  CONSTRAINT `major_fk_col` FOREIGN KEY (`colId`) REFERENCES `collage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '应用电子技术', '1');
INSERT INTO `major` VALUES ('2', '通信工程', '1');
INSERT INTO `major` VALUES ('3', '软件工程', '2');
INSERT INTO `major` VALUES ('4', '电气工程及其自动化', '3');
INSERT INTO `major` VALUES ('5', '食品工程', '5');
INSERT INTO `major` VALUES ('6', '包装工程', '4');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `stucontent` varchar(500) COLLATE utf8_bin NOT NULL,
  `teacontent` varchar(500) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('		广工五一劳动节及五四青年节教学安排\n	1. 4月30号至2月2号，放假调休三天。（5月1号法定假期，2，3号补休）\n	\n	2. 5月4号下午停课半天，考试重修照常。', '		广工五一劳动节及五四青年节教学安排\n	1. 4月30号至2月2号，放假调休三天。（5月1号法定假期，2，3号补休）\n	\n	2. 5月4号下午停课半天，考试重修照常。');

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuId` int(11) NOT NULL,
  `subId` int(11) NOT NULL,
  `teaId` int(11) NOT NULL,
  `score` double NOT NULL,
  `time` varchar(30) COLLATE utf8_bin NOT NULL,
  `iscomm` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `result_fk_stuId` (`stuId`),
  KEY `result_fk_subId` (`subId`),
  KEY `result_fk_teaId` (`teaId`),
  CONSTRAINT `result_fk_stuId` FOREIGN KEY (`stuId`) REFERENCES `student` (`id`),
  CONSTRAINT `result_fk_subId` FOREIGN KEY (`subId`) REFERENCES `subject` (`id`),
  CONSTRAINT `result_fk_teaId` FOREIGN KEY (`teaId`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '1001', '10', '2001', '82', '2016-1-14', '1');
INSERT INTO `result` VALUES ('2', '1002', '10', '2001', '90', '2016-1-14', '1');
INSERT INTO `result` VALUES ('3', '1003', '10', '2001', '78', '2016-1-14', '1');

-- ----------------------------
-- Table structure for root
-- ----------------------------
DROP TABLE IF EXISTS `root`;
CREATE TABLE `root` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of root
-- ----------------------------
INSERT INTO `root` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `phone` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `dormiting` varchar(20) COLLATE utf8_bin NOT NULL,
  `majorId` int(11) NOT NULL,
  `gradeId` int(11) NOT NULL,
  `classno` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `stu_fk_major` (`majorId`),
  KEY `stu_fk_gradeId` (`gradeId`),
  CONSTRAINT `stu_fk_gradeId` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`id`),
  CONSTRAINT `stu_fk_major` FOREIGN KEY (`majorId`) REFERENCES `major` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1001', '呀呀', '1562342435', '123', '广东广州', '西四719', '1', '3', '4');
INSERT INTO `student` VALUES ('1002', '蓝色咖啡杯', '138234235456', '123', '广东梅州', '西四719', '1', '3', '4');
INSERT INTO `student` VALUES ('1003', '唐大侠', '156212981890', '123', '广东茂名', '西四725', '1', '3', '4');
INSERT INTO `student` VALUES ('1004', '温海涛', '1562920128903', '123', '广东揭阳', '西四665', '1', '3', '2');
INSERT INTO `student` VALUES ('1005', '张三', '1563128768', '123', '广东惠州', '西三429', '3', '1', '1');
INSERT INTO `student` VALUES ('1006', '包子', '136234312', '123', '广东惠州', '东十三619', '2', '3', '6');
INSERT INTO `student` VALUES ('1007', '咸蛋超人', '1561231290', '123', '广东河源', '东十三527', '4', '3', '2');
INSERT INTO `student` VALUES ('1008', '志古', '1562331839201', '123', '广东河源', '东六318', '5', '3', '1');
INSERT INTO `student` VALUES ('1009', '李四', '138317289378291', '123', '广东中山', '西八336', '6', '1', '2');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `subtime` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '电机与拖动', '48');
INSERT INTO `subject` VALUES ('2', '计算机网络技术原理', '36');
INSERT INTO `subject` VALUES ('3', '数据库原理及应用', '42');
INSERT INTO `subject` VALUES ('4', 'DSP原理及应用', '32');
INSERT INTO `subject` VALUES ('5', '开关电源', '48');
INSERT INTO `subject` VALUES ('6', '数字信号处理', '48');
INSERT INTO `subject` VALUES ('7', '专业英语', '16');
INSERT INTO `subject` VALUES ('8', '计算机控制技术', '32');
INSERT INTO `subject` VALUES ('9', '可编程控制器', '26');
INSERT INTO `subject` VALUES ('10', '单片机原理及应用', '48');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `phone` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2010 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2001', '李优新', '1383243254353', '123', '湖南长沙');
INSERT INTO `teacher` VALUES ('2002', '周映虹', '156312312321', '123', '广东广州');
INSERT INTO `teacher` VALUES ('2004', '胡清', '156212312342', '000000', '广东广州');
INSERT INTO `teacher` VALUES ('2005', '黄国宏', '1368219038', '000000', '广东广州');
INSERT INTO `teacher` VALUES ('2006', '张文慧', '1363812932810', '000000', '广东东莞');
INSERT INTO `teacher` VALUES ('2007', '田妮莉', '15631289398021', '000000', '广东深圳');
INSERT INTO `teacher` VALUES ('2008', '宋力峰', '1583812093812', '000000', '广东广州');
