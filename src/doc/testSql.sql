CREATE TABLE `t_user`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `username`    varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
    `nickname`    varchar(64) NOT NULL DEFAULT '' COMMENT '用户昵称',
    `user_status` tinyint     NOT NULL DEFAULT '0' COMMENT '用户状态 0-停用 1-启用',
    `user_role`   tinyint     NOT NULL DEFAULT '0' COMMENT '用户角色 0-普通用户 1-管理员',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime             DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY           `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3 COMMENT='用户表';


-- 测试数据
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user1', '用户1', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user2', '用户2', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user3', '用户3', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user4', '用户4', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user5', '用户5', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user6', '用户6', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user7', '用户7', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user8', '用户8', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user9', '用户9', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user10', '用户10', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user11', '用户11', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user12', '用户12', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user13', '用户13', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user14', '用户14', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user15', '用户15', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user16', '用户16', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user17', '用户17', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user18', '用户18', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user19', '用户19', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user20', '用户20', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user21', '用户21', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user22', '用户22', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user23', '用户23', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user24', '用户24', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user25', '用户25', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user26', '用户26', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user27', '用户27', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user28', '用户28', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user29', '用户29', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user30', '用户30', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user31', '用户31', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user32', '用户32', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user33', '用户33', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user34', '用户34', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user35', '用户35', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user36', '用户36', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user37', '用户37', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user38', '用户38', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user39', '用户39', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user40', '用户40', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user41', '用户41', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user42', '用户42', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user43', '用户43', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user44', '用户44', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user45', '用户45', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user46', '用户46', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user47', '用户47', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user48', '用户48', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user49', '用户49', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user50', '用户50', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user51', '用户51', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user52', '用户52', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user53', '用户53', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user54', '用户54', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user55', '用户55', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user56', '用户56', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user57', '用户57', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user58', '用户58', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user59', '用户59', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user60', '用户60', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user61', '用户61', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user62', '用户62', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user63', '用户63', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user64', '用户64', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user65', '用户65', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user66', '用户66', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user67', '用户67', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user68', '用户68', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user69', '用户69', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user70', '用户70', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user71', '用户71', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user72', '用户72', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user73', '用户73', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user74', '用户74', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user75', '用户75', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user76', '用户76', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user77', '用户77', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user78', '用户78', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user79', '用户79', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user80', '用户80', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user81', '用户81', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user82', '用户82', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user83', '用户83', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user84', '用户84', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user85', '用户85', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user86', '用户86', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user87', '用户87', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user88', '用户88', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user89', '用户89', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user90', '用户90', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user91', '用户91', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user92', '用户92', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user93', '用户93', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user94', '用户94', 1, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user95', '用户95', 1, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user96', '用户96', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user97', '用户97', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user98', '用户98', 0, 0);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user99', '用户99', 0, 1);
INSERT INTO `t_user` (`username`, `nickname`, `user_status`, `user_role`) VALUES ('user100', '用户100', 0, 1);
