/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : javaee

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-12-17 21:57:46
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2', '郭建风', '17721901419', '德馨苑C3-225', '1');
INSERT INTO `address` VALUES ('17', '郭建风', '13684433731', '三教图书馆', '2');
INSERT INTO `address` VALUES ('20', 'test', '13777777777', '测试地址', '15');
INSERT INTO `address` VALUES ('22', '测试地址', '01234567891', '测试地址', '17');
INSERT INTO `address` VALUES ('24', '小峰同学', '13197819248', 'C9-321', '2');
INSERT INTO `address` VALUES ('25', '郭建风', '13881188257', 'C3', '20');
INSERT INTO `address` VALUES ('26', '嘿嘿', '17721901419', 'C10-321', '21');

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `publishUid` int(11) NOT NULL,
  `publishUser` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`fid`),
  KEY `fl_ForumAndUser_username` (`publishUid`),
  CONSTRAINT `fl_ForumAndUser_username` FOREIGN KEY (`publishUid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES ('7', '2', '小峰同学', '        哈哈哈哈哈哈哈哈哈', '2019-12-15 00:06');
INSERT INTO `forum` VALUES ('8', '2', '小峰同学', '        测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下测试一下', '2019-12-15 00:07');
INSERT INTO `forum` VALUES ('9', '15', 'test', '        喜喜喜喜喜喜', '2019-12-15 00:36');
INSERT INTO `forum` VALUES ('10', '2', '小峰同学', '        bhsdfgghfgn', '2019-12-15 20:34');
INSERT INTO `forum` VALUES ('11', '20', '苦其心志', '        你心中', '2019-12-15 21:21');
INSERT INTO `forum` VALUES ('12', '2', '小峰同学', '        测试发帖        测试发帖        测试发帖', '2019-12-16 19:00');
INSERT INTO `forum` VALUES ('13', '2', '小峰同学', '        我来试试发帖', '2019-12-16 19:03');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of messige
-- ----------------------------
INSERT INTO `messige` VALUES ('4', '张三', '13684433731', 'agfedhsrgjhtjfg');
INSERT INTO `messige` VALUES ('5', '张三', '13684433731', 'agfedhsrgjhtjfg');
INSERT INTO `messige` VALUES ('6', '张三', '13684433731', 'agfedhsrgjhtjfg');
INSERT INTO `messige` VALUES ('7', '郭建风', '13684433731', '测试留言');
INSERT INTO `messige` VALUES ('8', '小峰同学', '13778358345', '测试发一条建议');
INSERT INTO `messige` VALUES ('9', '和你们', '649494649464', '你以为');
INSERT INTO `messige` VALUES ('10', '小唐', '17721901419', '测试留言');

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
  KEY `fk_order_address_address` (`address`),
  KEY `fk_orders_user_uid` (`uid`),
  CONSTRAINT `fk_orders_user_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('44', '2', '小峰同学', '求帮忙', '帮忙去后街取东西', '郭建风 13684433731 图书馆', '不限', '5.00', '进行中', '2019-12-15 20:56', '2019-12-15  21:55', '17');
INSERT INTO `orders` VALUES ('46', '2', '小峰同学', '取快递', '快递超市取快递，有点重', '郭建风 13684433731 图书馆', '限男生', '8.00', '已完成', '2019-12-15 20:58', '2019-12-15  22:58', '17');
INSERT INTO `orders` VALUES ('47', '17', '1', '求带饭', '测试发布任务', '测试地址 01234567891 测试地址', '限美女', '2.00', '进行中', '2019-12-15 21:16', '2019-12-15  21:16', '20');
INSERT INTO `orders` VALUES ('48', '17', '1', '取快递', '好脸色虎扑', '测试地址 01234567891 测试地址', '限美女', '2.00', '已完成', '2019-12-15 21:20', '2019-12-15  21:20', '20');
INSERT INTO `orders` VALUES ('49', '21', '嘿嘿', '求帮忙', '帮忙指导作业', '嘿嘿 17721901419 C10-321', '限美女', '3.00', '进行中', '2019-12-16 12:08', '2019-12-16  19:08', '2');
INSERT INTO `orders` VALUES ('50', '2', '小峰同学', '求帮忙', '帮忙', '郭建风 13684433731 C3-225', '不限', '2.00', '未处理', '2019-12-16 19:06', '2019-12-16  19:06', '-1');
INSERT INTO `orders` VALUES ('51', '2', '小峰同学', '求帮忙', '送资料', '郭建风 13684433731 三教图书馆', '不限', '2.00', '未处理', '2019-12-16 21:47', '2019-12-16  21:47', '-1');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(255) NOT NULL,
  `uid` int(255) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `replyTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `fk_reply_forum_fid` (`fid`),
  KEY `fk_ReplyAndUser_uid` (`uid`),
  CONSTRAINT `fk_ReplyAndUser_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_reply_forum_fid` FOREIGN KEY (`fid`) REFERENCES `forum` (`fid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('34', '10', '2', '小峰同学', '第一条回复', '2019-12-16 19:03');
INSERT INTO `reply` VALUES ('35', '12', '2', '小峰同学', '测试回帖', '2019-12-16 19:03');
INSERT INTO `reply` VALUES ('36', '12', '2', '小峰同学', '哈哈', '2019-12-16 21:46');
INSERT INTO `reply` VALUES ('37', '11', '2', '小峰同学', '啦啦啦', '2019-12-16 21:47');
INSERT INTO `reply` VALUES ('38', '8', '2', '小峰同学', '啦啦啦啦啦', '2019-12-16 21:47');

-- ----------------------------
-- Table structure for stucard
-- ----------------------------
DROP TABLE IF EXISTS `stucard`;
CREATE TABLE `stucard` (
  `cid` int(255) NOT NULL AUTO_INCREMENT,
  `uid` int(255) NOT NULL,
  `realName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `stuNumber` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `cardImage` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `fk_stucard_user_uid` (`uid`),
  CONSTRAINT `fk_stucard_user_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stucard
-- ----------------------------
INSERT INTO `stucard` VALUES ('1', '2', '郭建风', '41701034', 'ef699ed9-3717-4323-b248-a5096287c7a6.png');
INSERT INTO `stucard` VALUES ('2', '2', '郭建风', '41701034', '56783d75-830d-4c53-b6ac-28d01bbba934.png');

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小唐', '13778787979', '111', 'jjj@qq.com');
INSERT INTO `user` VALUES ('2', '小峰同学', '13684433731', 'gjf.33731', 'gjf13684433731@163.com');
INSERT INTO `user` VALUES ('14', '王五', '17721191109', '555555', 'ww@qq.com');
INSERT INTO `user` VALUES ('15', 'test', '13666666666', 'aaa', 'test@qq.com');
INSERT INTO `user` VALUES ('16', '12122', '122221', '12121', '982121915@qq.com');
INSERT INTO `user` VALUES ('17', '1', '123', '111', '982121915@qq.com');
INSERT INTO `user` VALUES ('18', '张三', '17721901419', '1111', 'zs@qq.com');
INSERT INTO `user` VALUES ('20', '苦其心志', '13881188257', 'qwer1234', '8494@qq.com');
INSERT INTO `user` VALUES ('21', '嘿嘿', '17721901419', 'gjf.33731', 'aa@163.com');
