/*
 Navicat MySQL Data Transfer

 Source Server         : mysqlconnection
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : easybuy

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/07/2016 22:37:03 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `easybuy_order`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order`;
CREATE TABLE `easybuy_order` (
  `eo_id` int(40) NOT NULL AUTO_INCREMENT,
  `eo_user_id` int(20) NOT NULL,
  `eo_user_name` varchar(50) NOT NULL,
  `eo_user_address` varchar(200) NOT NULL,
  `eo_create_time` datetime NOT NULL,
  `eo_cost` double NOT NULL,
  `eo_status` int(4) NOT NULL COMMENT '1 下单 2 审核通过 3 配货 4 送货中 5 收货并确认',
  `eo_type` int(4) NOT NULL COMMENT '1 货到付款 2 网上支付',
  PRIMARY KEY (`eo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
