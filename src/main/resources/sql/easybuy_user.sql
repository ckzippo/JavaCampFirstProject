/*
 Navicat MySQL Data Transfer

 Source Server         : mysqlconnection
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : easybuy

 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/07/2016 22:34:47 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `easybuy_user`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user` (
  `eu_user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `eu_user_name` varchar(50) NOT NULL,
  `eu_password` varchar(50) NOT NULL,
  `eu_sex` int(1) DEFAULT NULL,
  `eu_birthday` datetime DEFAULT NULL,
  `eu_identity_code` varchar(20) DEFAULT NULL,
  `eu_email` varchar(50) DEFAULT NULL,
  `eu_mobile` varchar(11) DEFAULT NULL,
  `eu_address` varchar(100) DEFAULT NULL,
  `eu_headimage` varchar(400) DEFAULT NULL,
  `eu_status` int(1) DEFAULT NULL COMMENT '1 普通用户 2 管理员',
  PRIMARY KEY (`eu_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `easybuy_user`
-- ----------------------------
BEGIN;
INSERT INTO `easybuy_user` VALUES ('3', '网', '222', '1', '1988-01-01 00:00:00', '122333333', '123@13.com', null, '龙蟠路', null, '2'), ('9', '越前平次', '123', '0', null, null, null, null, null, null, '1'), ('10', '利息', '阿大声道', '1', '1999-11-01 00:00:00', null, null, '33333', '1111', '/Users/ckzippo/IdeaProjects/JavaCampFirstProject/out/artifacts/JavaCampFirstProject_war_exploded/upload/headimage/', '1'), ('11', 'lisi', '2222', '0', null, null, null, null, null, 'wowowo', '1'), ('15', 'lisi', '2222', '0', null, null, null, null, null, 'wowowo', '1'), ('16', 'lisi', '2222', '1', '1999-11-01 00:00:00', null, null, '898898', '', '/Users/ckzippo/IdeaProjects/JavaCampFirstProject/out/artifacts/JavaCampFirstProject_war_exploded/upload/headimage/', '1'), ('17', 'lisi', '2222', '0', null, null, null, null, null, 'wowowo', '1'), ('18', 'wowwowo', '2222', '0', null, null, null, null, null, 'wowowo', '1'), ('19', 'wangwu', '123344', '0', '2000-12-02 00:00:00', '111122', null, '33333333', 'UTF-8', '/Users/ckzippo/IdeaProjects/JavaCampFirstProject/out/artifacts/JavaCampFirstProject_war_exploded/upload/headimage/', '1'), ('20', '你好', '123456', '0', '1999-11-02 00:00:00', '1212222222', null, '2222222', '3333333da 打', '/Users/ckzippo/IdeaProjects/JavaCampFirstProject/out/artifacts/JavaCampFirstProject_war_exploded/upload/headimage/', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
