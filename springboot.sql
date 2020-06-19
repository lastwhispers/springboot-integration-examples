-- utf8_general_ci(ci是 case insensitive)  大小写不敏感
-- utf8_general_cs 大小写敏感
-- utf8_bin 二进制存储

-- utf8_general_ci: 校对速度快，但准确度稍差。
-- utf8_unicode_ci: 准确度高，但校对速度稍慢(德语、法语或者俄语)。

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
CREATE TABLE `sys_user` (
	`user_id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
	`account` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
	`password` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
	`email` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
	`phone` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
	PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
CREATE TABLE `sys_user_role` ( 
	`user_id` BIGINT ( 20 ) NOT NULL COMMENT '用户ID', 
	`role_id` BIGINT ( 20 ) NOT NULL COMMENT '角色ID' 
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
CREATE TABLE `sys_role` (
	`role_id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
	`name` VARCHAR ( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
	PRIMARY KEY ( `role_id` ) USING BTREE 
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
   `role_id` bigint(20) NOT NULL COMMENT '角色ID',
   `menu_id` bigint(20) NOT NULL COMMENT '菜单ID/按钮ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
CREATE TABLE `sys_menu`  (
	`menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `pid` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单/按钮名称',
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `permit` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 0菜单 1按钮',
  `sort` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

