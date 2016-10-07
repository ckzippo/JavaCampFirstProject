/*
 Navicat MySQL Data Transfer

 Source Server         : mysqlconnection
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : easybuy

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/07/2016 22:36:54 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `easybuy_comment`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_comment`;
CREATE TABLE `easybuy_comment` (
  `ec_id` int(50) NOT NULL AUTO_INCREMENT,
  `ec_reply` varchar(200) DEFAULT NULL,
  `ec_content` text,
  `ec_create_time` datetime DEFAULT NULL,
  `ec_reply_time` datetime DEFAULT NULL,
  `ec_nick_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `easybuy_comment`
-- ----------------------------
BEGIN;
INSERT INTO `easybuy_comment` VALUES ('1', '阿萨德', '侧耳', null, null, '猪八戒'), ('2', '这是一条回ces是', '留言内容', '2016-10-03 16:58:38', '2016-10-07 16:58:41', '孙悟空'), ('3', '唐山', '撒旦啊', null, null, '唐三彩'), ('4', '鞭', '我我我', null, null, '白龙马'), ('5', '你好啊', '这是撒', null, null, '如来'), ('6', '其他天天天天', '谁谁谁', null, null, '蛇精'), ('7', '我我我我我啊', '你好啊', null, null, '蜘蛛精'), ('8', '空的', '非空', null, null, '海豚'), ('9', '我我我哇啊啊', '明天去啊', null, null, '河马'), ('10', '12222按时', '啊实打实的', null, null, '大象'), ('11', '学习', '真没', null, null, '长颈鹿'), ('12', null, null, null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
