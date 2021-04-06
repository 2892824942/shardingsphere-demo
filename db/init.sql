
CREATE DATABASE IF NOT EXISTS mydb;
CREATE DATABASE IF NOT EXISTS mydb0;
CREATE DATABASE IF NOT EXISTS mydb1;

DROP TABLE IF EXISTS `mydb`.`bill`;
CREATE TABLE `mydb`.`bill` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_name` varchar(255) NOT NULL DEFAULT '' COMMENT '账单名称',
  `bill_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `mydb`.`bill_item`;
CREATE TABLE `mydb`.`bill_item` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_id` bigint unsigned NOT NULL DEFAULT 0 COMMENT '账单id',
  `bill_item_name` varchar(255) NOT NULL DEFAULT '' COMMENT '子账单名称',
  `bill_item_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*分表*/
DROP TABLE IF EXISTS `mydb`.`bill_0`;
CREATE TABLE `mydb`.`bill_0` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_name` varchar(255) NOT NULL DEFAULT '' COMMENT '账单名称',
  `bill_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `mydb`.`bill_1`;
CREATE TABLE `mydb`.`bill_1` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_name` varchar(255) NOT NULL DEFAULT '' COMMENT '账单名称',
  `bill_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



/*分库分表*/
DROP TABLE IF EXISTS `mydb0`.`bill_0`;
CREATE TABLE `mydb0`.`bill_0` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_name` varchar(255) NOT NULL DEFAULT '' COMMENT '账单名称',
  `bill_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `mydb0`.`bill_1`;
CREATE TABLE `mydb0`.`bill_1` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_name` varchar(255) NOT NULL DEFAULT '' COMMENT '账单名称',
  `bill_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `mydb0`.`bill_item`;
CREATE TABLE `mydb0`.`bill_item` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_id` bigint unsigned NOT NULL DEFAULT 0 COMMENT '账单id',
  `bill_item_name` varchar(255) NOT NULL DEFAULT '' COMMENT '子账单名称',
  `bill_item_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `mydb1`.`bill_0`;
CREATE TABLE `mydb1`.`bill_0` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_name` varchar(255) NOT NULL DEFAULT '' COMMENT '账单名称',
  `bill_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `mydb1`.`bill_1`;
CREATE TABLE `mydb1`.`bill_1` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_name` varchar(255) NOT NULL DEFAULT '' COMMENT '账单名称',
  `bill_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `mydb1`.`bill_item`;
CREATE TABLE `mydb1`.`bill_item` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_id` bigint unsigned NOT NULL DEFAULT 0 COMMENT '账单id',
  `bill_item_name` varchar(255) NOT NULL DEFAULT '' COMMENT '子账单名称',
  `bill_item_amount` int unsigned NOT NULL DEFAULT '0' COMMENT '账单金额',
  `create_time` datetime(3) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0:未删除 1:已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;