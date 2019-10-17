/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : spring-cloud-system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-10-17 17:14:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu` (
  `id` varchar(36) NOT NULL,
  `menu_component` varchar(255) DEFAULT NULL,
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) DEFAULT NULL,
  `menu_description` varchar(255) DEFAULT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `permission_code` varchar(50) DEFAULT NULL,
  `state` varchar(36) DEFAULT NULL,
  `hidden` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_menu
-- ----------------------------
INSERT INTO `base_menu` VALUES ('1', null, '系统管理', '/system', '系统管理相关', '-1', 'table', 'MENU_SYSTEM', null, '1');
INSERT INTO `base_menu` VALUES ('2', null, '博客管理', '/blog', '博客管理相关', '-1', 'table', 'MENU_BLOG', null, null);
INSERT INTO `base_menu` VALUES ('3', null, '用户管理', '/system/user', '@/views/system/user/index', '1', 'table', 'MENU_SYSTEM_USER', null, null);
INSERT INTO `base_menu` VALUES ('4', null, '角色管理', '/role', '角色管理', '1', 'table', 'MENU_SYSTEM_ROLE', null, null);
INSERT INTO `base_menu` VALUES ('5', null, '字典管理', '/dict', '字典管理', '1', 'table', 'MENU_SYSTEM_DICT', null, null);
INSERT INTO `base_menu` VALUES ('6', null, '菜单管理', '/menu', '菜单管理', '1', 'table', 'MENU_SYSTEM_MENU', null, null);
INSERT INTO `base_menu` VALUES ('7', null, '文章管理', '/blog/article', '文章管理', '2', 'table', 'MENU_BLOG_ARTICLE', null, null);
INSERT INTO `base_menu` VALUES ('7688f85dd0554f2290665e58f54bdb01', 'Monitor', '系统监控', '/monitor', '系统监控', '-1', 'table', 'MENU_MONITOR', '启用', null);
INSERT INTO `base_menu` VALUES ('8', null, '标签管理', '/blog/tag', '标签管理', '2', 'table', 'MENU_BLOG_TAG', null, null);
INSERT INTO `base_menu` VALUES ('9ded853a707b405b88876b19c54dc597', 'Exception', '异常记录', '/monitor/exception', '异常记录', '7688f85dd0554f2290665e58f54bdb01', 'table', 'MENU_MONITOR_EXCEPTION', '启用', null);

-- ----------------------------
-- Table structure for base_operation
-- ----------------------------
DROP TABLE IF EXISTS `base_operation`;
CREATE TABLE `base_operation` (
  `id` varchar(36) NOT NULL,
  `operation_name` varchar(50) DEFAULT NULL,
  `menu_id` varchar(36) DEFAULT NULL,
  `permission_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_operation
-- ----------------------------
INSERT INTO `base_operation` VALUES ('59f5607c921f4315b4d09a5b53e64d07', '新增用户1', null, 'OPERATION_USER_ADD');
INSERT INTO `base_operation` VALUES ('a835767e11334a14927791de79fdcac0', '修改用户', '3', 'OPERATION_USER_MODIFY');
INSERT INTO `base_operation` VALUES ('e669328e0b2344bf83bd703b1275e1b3', '删除用户', '3', 'OPERATION_USER_DELETE');

-- ----------------------------
-- Table structure for base_role
-- ----------------------------
DROP TABLE IF EXISTS `base_role`;
CREATE TABLE `base_role` (
  `id` varchar(36) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_role
-- ----------------------------
INSERT INTO `base_role` VALUES ('1', '管理员', 'ROLE_ADMIN');
INSERT INTO `base_role` VALUES ('2', '普通用户', 'ROLE_USER');

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `sex` varchar(36) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `state` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('1', '测试用户', 'test', 'test', null, null, null, null, null, null, null);
INSERT INTO `base_user` VALUES ('2', '系统管理员', 'admin', 'admin', null, null, null, null, null, null, null);
INSERT INTO `base_user` VALUES ('7e79e7204b4447dda969af088df1f71e', null, 'zs', 'zs', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for rl_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `rl_role_permission`;
CREATE TABLE `rl_role_permission` (
  `id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  `resource_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_type` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rl_role_permission
-- ----------------------------
INSERT INTO `rl_role_permission` VALUES ('1', '1', '1', 'menu');
INSERT INTO `rl_role_permission` VALUES ('2', '1', '2', 'menu');
INSERT INTO `rl_role_permission` VALUES ('3', '1', '3', 'menu');
INSERT INTO `rl_role_permission` VALUES ('4', '1', '1', 'operation');
INSERT INTO `rl_role_permission` VALUES ('5', '1', '6', 'menu');
INSERT INTO `rl_role_permission` VALUES ('6', '1', '7', 'menu');
INSERT INTO `rl_role_permission` VALUES ('7', '1', '8', 'menu');

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
