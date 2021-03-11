create database if not exists spring_boot_db;

use spring_boot_db;

CREATE TABLE `sys_user` (
	`user_id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
	`account` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
	`password` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
	`email` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
	`phone` VARCHAR ( 45 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
	PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;


