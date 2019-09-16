/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : spring-cloud-system

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-06-21 17:27:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role` (
  `id` varchar(36) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_role
-- ----------------------------

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('180f4cc5f3504b0388c81df847694d3d', '测试用户', 'test', '$2a$10$X4qd953sLoZYgK7BmF3xGejPnd4X98w6MxDvg8diP0LaDkxsutfAm');
INSERT INTO `base_user` VALUES ('ecb37988e2914b8da3034bc5bc347c2f', '系统管理员', 'admin', '$2a$10$CaUa.CYUhb1eBQyc0sVBueq3B2BXwKXUP/GsvnN39lsIvczp/LTIO');

-- ----------------------------
-- Table structure for rl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `rl_user_role`;
CREATE TABLE `rl_user_role` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  `role_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rl_user_role
-- ----------------------------
