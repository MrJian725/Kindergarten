/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : kindergarten

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2024-01-09 23:34:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- DROP DABABASE IF EXISTS kindergarten;
-- CREATE DATABASE kindergarten;
-- USE kindergarten;

-- ----------------------------
-- Table structure for `chuqing`
-- ----------------------------
DROP TABLE IF EXISTS `chuqing`;
CREATE TABLE `chuqing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `statue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  CONSTRAINT `chuqing_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chuqing
-- ----------------------------
INSERT INTO `chuqing` VALUES ('1', '1001', '2024-01-08 08:36:22', '正常');
INSERT INTO `chuqing` VALUES ('2', '1002', '2024-01-08 08:36:22', '缺勤');
INSERT INTO `chuqing` VALUES ('5', '1001', '2024-01-09 23:29:40', '正常');

-- ----------------------------
-- Table structure for `richangbiaoxian`
-- ----------------------------
DROP TABLE IF EXISTS `richangbiaoxian`;
CREATE TABLE `richangbiaoxian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  CONSTRAINT `richangbiaoxian_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of richangbiaoxian
-- ----------------------------
INSERT INTO `richangbiaoxian` VALUES ('1', '1001', '2024-01-08', '表现非常好，乖乖吃饭上课不吵，课测优秀', '优');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  `classname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1001', '张三', '男', '5', '小班');
INSERT INTO `student` VALUES ('1002', '李四', '男', '5', '小班');
INSERT INTO `student` VALUES ('1003', '王五', '女', '6', '大班');
INSERT INTO `student` VALUES ('1004', '赵六', '女', '6', '大班');
INSERT INTO `student` VALUES ('1005', '钱七', '女', '4', '小班');

-- ----------------------------
-- Table structure for `tijian`
-- ----------------------------
DROP TABLE IF EXISTS `tijian`;
CREATE TABLE `tijian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `width` varchar(255) DEFAULT NULL,
  `eent` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sid` (`sid`),
  CONSTRAINT `tijian_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tijian
-- ----------------------------
INSERT INTO `tijian` VALUES ('1', '1001', '2024-01-08', '140cm', '35kg', '正常', '正常');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
