CREATE DATABASE `db1` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
use db1;
CREATE TABLE db1.`goods` (
                             `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `name` VARCHAR(45) NOT NULL COMMENT '名称',
                             `price` BIGINT NOT NULL COMMENT '价格',
                             PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=UTF8;
INSERT INTO `db1`.`goods` (`id`, `name`, `price`) VALUES ('1', 'iPhone 12 Pro', '1000000');

CREATE DATABASE `db2` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
use db2;
CREATE TABLE db2.`merchant` (
                                `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `name` VARCHAR(45) NOT NULL COMMENT '名称',
                                `age` INT NOT NULL COMMENT '价格',
                                PRIMARY KEY (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=0 DEFAULT CHARSET=UTF8;
INSERT INTO `db2`.`merchant` (`id`, `name`, `age`) VALUES ('1', '拼多多', '12');

