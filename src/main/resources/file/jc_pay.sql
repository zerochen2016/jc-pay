CREATE TABLE `pay_account_notify` (
  `account` varchar(50) NOT NULL,
  `notify` varchar(200) NOT NULL DEFAULT '',
  `show_type` int(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `pay_config_info` (
  `config_key` varchar(50) NOT NULL DEFAULT '' COMMENT 'key',
  `config_value` varchar(100) NOT NULL DEFAULT '' COMMENT 'value',
  `remark` varchar(50) NOT NULL DEFAULT '',
  `config_type` int(1) unsigned NOT NULL DEFAULT '1',
  `status` int(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`config_key`),
  KEY `config_type` (`config_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置表';

insert into `pay_config_info`(`config_key`,`config_value`,`remark`,`config_type`,`status`) values
('PAY_EXPIRE_TIME_MINUTES','5',' ',200,1),
('PAY_JUMP_ALIPAY','alipays://platformapi/startapp?appId=10000007',' ',200,1),
('PAY_JUMP_WECHAT','weixin://',' ',200,1),
('PAY_PUBLIC_KEY','',' ',200,1),
('WHITE_LIST_IP','127.0.0.1','ip白名单',200,1);


CREATE TABLE `pay_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `pid` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `pit` (`pid`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into `pay_menu`(`id`,`name`,`url`,`pid`,`status`) values
(1,'支付管理','/admin',0,1),
(11,'第三方支付','/admin/thirdPay/pager',1,1);


CREATE TABLE `pay_operator` (
  `account` varchar(50) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `role_id` int(3) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL,
  `update_time` bigint(13) NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `pay_operator`(`account`,`password`,`role_id`,`status`,`create_time`,`update_time`) values
('admin','',1,1,0,0);
DROP TABLE IF EXISTS  `pay_order_info`;
CREATE TABLE `pay_order_info` (
  `order_no` varchar(40) NOT NULL,
  `qrcode_id` int(11) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `create_time` bigint(13) NOT NULL DEFAULT '0',
  `update_time` bigint(13) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '1',
  `trade_no` varchar(45) DEFAULT NULL,
  `expire_time` bigint(12) NOT NULL DEFAULT '0',
  `user_id` varchar(45) DEFAULT '',
  `account` varchar(45) DEFAULT '',
  `mobile` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`order_no`),
  UNIQUE KEY `tradeno` (`trade_no`),
  KEY `notifykey` (`qrcode_id`,`create_time`),
  KEY `mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `pay_qrcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(45) DEFAULT '',
  `money` varchar(45) DEFAULT '0',
  `qrcode_url` varchar(200) DEFAULT '',
  `code_type` int(1) DEFAULT '1' COMMENT '1 支付宝 2 微信 3 农信二维码',
  `money_key` varchar(45) DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '1',
  `oktime` bigint(13) NOT NULL DEFAULT '0',
  `user_id` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `one` (`account`,`money`),
  KEY `money_key` (`money_key`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `pay_role_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `status` int(1) unsigned NOT NULL DEFAULT '1',
  `create_time` bigint(13) unsigned NOT NULL DEFAULT '0',
  `update_time` bigint(13) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `pay_role_info`(`id`,`role_name`,`status`,`create_time`,`update_time`) values
(1,'管理员',1,0,0);


CREATE TABLE `pay_role_menu_relate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL,
  `menu_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`role_id`),
  KEY `menuid` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert into `pay_role_menu_relate`(`id`,`role_id`,`menu_id`) values
(1,1,1),
(2,1,11);
SET FOREIGN_KEY_CHECKS = 1;

