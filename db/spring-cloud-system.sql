/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : spring-cloud-system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-09-24 17:29:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu` (
  `id` varchar(36) NOT NULL,
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) DEFAULT NULL,
  `menu_description` varchar(255) DEFAULT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_menu
-- ----------------------------
INSERT INTO `base_menu` VALUES ('1', '用户管理', '/user', '用户管理相关', '-1');

-- ----------------------------
-- Table structure for base_operation
-- ----------------------------
DROP TABLE IF EXISTS `base_operation`;
CREATE TABLE `base_operation` (
  `id` varchar(36) NOT NULL,
  `operation_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_operation
-- ----------------------------
INSERT INTO `base_operation` VALUES ('1', '新增用户');

-- ----------------------------
-- Table structure for base_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_permission`;
CREATE TABLE `base_permission` (
  `id` varchar(36) NOT NULL,
  `permission_name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `permission_code` varchar(50) DEFAULT NULL COMMENT '权限编码',
  `permission_description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `permission_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_permission
-- ----------------------------
INSERT INTO `base_permission` VALUES ('1', '用户管理菜单', 'PER_MENU_USER', '用户管理菜单权限', 'MENU');
INSERT INTO `base_permission` VALUES ('2', '新增用户', 'PER_USER_ADD', '新增用户操作权限', 'OPERA');

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
INSERT INTO `base_role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `base_role` VALUES ('2', 'ROLE_USER');

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
INSERT INTO `base_user` VALUES ('1', '测试用户', 'test', 'test');
INSERT INTO `base_user` VALUES ('2', '系统管理员', 'admin', 'admin');

-- ----------------------------
-- Table structure for rl_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `rl_role_permission`;
CREATE TABLE `rl_role_permission` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `permission_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rl_role_permission
-- ----------------------------
INSERT INTO `rl_role_permission` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for rl_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `rl_user_permission`;
CREATE TABLE `rl_user_permission` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `permission_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rl_user_permission
-- ----------------------------
INSERT INTO `rl_user_permission` VALUES ('1', '1', '2');

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
INSERT INTO `rl_user_role` VALUES ('1', '1', '1');
INSERT INTO `rl_user_role` VALUES ('2', '1', '2');
