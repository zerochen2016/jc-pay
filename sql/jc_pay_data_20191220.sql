SET FOREIGN_KEY_CHECKS = 0;

insert into `pay_config_info`(`config_key`,`config_value`,`remark`,`config_type`,`status`) values
('PAY_BUTTON_TYPE','1','按钮开关',200,1),
('PAY_EXPIRE_TIME_MINUTES','5',' ',200,1),
('PAY_INTERCEPTOR_SWITCH','0','支付拦截器开关',200,1),
('PAY_JUMP_ALIPAY','alipays://platformapi/startapp?appId=10000007',' ',200,1),
('PAY_JUMP_WECHAT','weixin://',' ',200,1),
('PAY_NOTIFY_URL','https://www/thirdpay/mypaynotify.php',' ',200,1),
('PAY_PUBLIC_KEY','TjS5Wv6CjpuyxdiMn@.8pYpo1hkpkqgW',' ',200,1),
('WHITE_LIST_IP','0.0.0.0','ip白名单',200,1);

insert into `pay_menu`(`id`,`name`,`url`,`pid`,`status`) values
(1,'支付管理','/admin',0,1),
(11,'第三方支付','/admin/thirdPay/pager',1,1);

insert into `pay_operator`(`account`,`password`,`role_id`,`status`,`create_time`,`update_time`) values
('admin','password',1,1,0,0);

insert into `pay_role_info`(`id`,`role_name`,`status`,`create_time`,`update_time`) values
(1,'管理员',1,0,0);

insert into `pay_role_menu_relate`(`id`,`role_id`,`menu_id`) values
(1,1,1),
(2,1,11);
SET FOREIGN_KEY_CHECKS = 1;

