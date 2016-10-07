/*
 Navicat MySQL Data Transfer

 Source Server         : mysqlconnection
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : easybuy

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/07/2016 22:37:09 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `easybuy_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order_detail`;
CREATE TABLE `easybuy_order_detail` (
  `eod_id` int(40) NOT NULL AUTO_INCREMENT,
  `eo_id` int(40) NOT NULL,
  `ep_id` int(40) NOT NULL,
  `eod_quantity` int(40) NOT NULL,
  `eod_cost` double(20,0) NOT NULL,
  PRIMARY KEY (`eod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
