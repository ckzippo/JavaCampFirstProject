/*
 Navicat MySQL Data Transfer

 Source Server         : mysqlconnection
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : easybuy

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/07/2016 22:37:17 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `easybuy_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product_category`;
CREATE TABLE `easybuy_product_category` (
  `epc_id` int(20) NOT NULL AUTO_INCREMENT,
  `epc_name` varchar(100) NOT NULL,
  `epc_parent_id` int(20) NOT NULL,
  PRIMARY KEY (`epc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `easybuy_product_category`
-- ----------------------------
BEGIN;
INSERT INTO `easybuy_product_category` VALUES ('1', '根目录', '0'), ('2', '电脑', '1'), ('3', '衣服', '1'), ('4', '手机', '1'), ('5', '苹果电脑', '2'), ('6', 'ThinkPad', '2'), ('7', '冰箱', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
