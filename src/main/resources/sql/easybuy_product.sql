/*
 Navicat MySQL Data Transfer

 Source Server         : mysqlconnection
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : easybuy

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/07/2016 22:37:12 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `easybuy_product`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product`;
CREATE TABLE `easybuy_product` (
  `ep_id` int(40) NOT NULL AUTO_INCREMENT,
  `ep_name` varchar(100) DEFAULT NULL,
  `ep_description` varchar(500) DEFAULT NULL,
  `ep_price` double DEFAULT NULL,
  `ep_stock` int(20) DEFAULT NULL,
  `epc_id` int(10) DEFAULT NULL,
  `epc_child_id` int(10) DEFAULT NULL,
  `ep_file_name` varchar(200) DEFAULT NULL,
  `ep_barcode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `easybuy_product`
-- ----------------------------
BEGIN;
INSERT INTO `easybuy_product` VALUES ('2', 'thinkpad X100', 'thinkpad X100', '8000', '3000', '6', '2', 'ddddd/', '222222'), ('3', 'macbook pro', 'macbook pro', '15000', '1000', '5', '2', 'ddddd/', '333333'), ('4', 'macbook air', 'macbook air', '10000', '2000', '5', '2', 'ddddd/', '111122223333'), ('5', '波斯顿羽绒服', '波斯顿羽绒服', '1000', '10000', '3', null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
