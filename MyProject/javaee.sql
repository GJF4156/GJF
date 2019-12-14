/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : javaee

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-12-14 17:56:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `consignee` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cphone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `createuid` int(12) NOT NULL,
  PRIMARY KEY (`aid`),
  KEY `content` (`content`),
  KEY `fm_address_user_createuid` (`createuid`),
  CONSTRAINT `fm_address_user_createuid` FOREIGN KEY (`createuid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2', '郭建风', '17721901419', '德馨苑C3-225', '1');
INSERT INTO `address` VALUES ('14', '小强', '13644446666', '实验楼\r\n', '2');
INSERT INTO `address` VALUES ('17', '郭建风', '13684433731', '图书馆', '2');
INSERT INTO `address` VALUES ('20', 'test', '13777777777', '测试地址', '15');
INSERT INTO `address` VALUES ('22', '1', '1', '1111', '17');

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`fid`),
  KEY `fl_ForumAndUser_username` (`username`),
  CONSTRAINT `fl_ForumAndUser_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of forum
-- ----------------------------

-- ----------------------------
-- Table structure for messige
-- ----------------------------
DROP TABLE IF EXISTS `messige`;
CREATE TABLE `messige` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `suggest` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of messige
-- ----------------------------
INSERT INTO `messige` VALUES ('4', '张三', '13684433731', 'agfedhsrgjhtjfg');
INSERT INTO `messige` VALUES ('5', '张三', '13684433731', 'agfedhsrgjhtjfg');
INSERT INTO `messige` VALUES ('6', '张三', '13684433731', 'agfedhsrgjhtjfg');
INSERT INTO `messige` VALUES ('7', '郭建风', '13684433731', '测试留言');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '新闻测试1', '这是一个测试新闻内容', '2019-12-02 17:34:36');
INSERT INTO `news` VALUES ('2', '新闻测试2', '这是第二个新闻测试内容', '2019-12-02 17:34:31');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(8) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `colId` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `describe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `other_requirements` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cost` float(10,2) NOT NULL,
  `order_state` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `release_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `expect_time` varchar(225) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `receipt` int(255) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_user_order_uid` (`username`),
  KEY `fk_OrderAndUser` (`receipt`),
  KEY `fk_order_address_address` (`address`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('40', '15', 'test', '---请选择---', 'assdddddddddddddddddddd', 'test 13777777777 测试地址', '不限', '2.00', '未处理', '2019-12-13 19:20', '2019-12-13  19:20', '-1');
INSERT INTO `orders` VALUES ('41', '2', '郭建风', '求陪跑', 'sdcfafsdgfsdfghdf', '小强 13644446666 实验楼', '不限', '3.00', '未处理', '2019-12-13 19:39', '2019-12-13  19:39', '-1');
INSERT INTO `orders` VALUES ('42', '17', '1', '取快递', '11', '1 1 1111', '限美女', '2.00', '已完成', '2019-12-13 19:48', '2019-12-02  19:47', '2');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `reply_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rid`),
  KEY `fk_ReplyAndUser_uid` (`uid`),
  CONSTRAINT `fk_ReplyAndUser_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(225) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`uid`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小唐', '13778787979', '111', 'jjj@qq.com');
INSERT INTO `user` VALUES ('2', '郭建风', '13684433731', 'gjf.33731', 'gjf13684433731@163.com');
INSERT INTO `user` VALUES ('14', '王五', '17721191109', '555555', 'ww@qq.com');
INSERT INTO `user` VALUES ('15', 'test', '13666666666', '123456', 'test@qq.com');
INSERT INTO `user` VALUES ('16', '12122', '122221', '12121', '982121915@qq.com');
INSERT INTO `user` VALUES ('17', '1', '123', '111', '982121915@qq.com');
INSERT INTO `user` VALUES ('18', '张三', '17721901419', '1111', 'zs@qq.com');
