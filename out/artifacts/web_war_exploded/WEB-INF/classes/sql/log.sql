
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
    `l_username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户名称',
    `l_operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户操作',
    `l_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '对象描述',
    `l_price` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '价格',
    `l_num` int(0) NULL DEFAULT NULL COMMENT '数量',
    `l_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `l_id` int(0) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`l_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '高领卫衣', '188', 23, '2023-12-18 01:54:02', 1);
INSERT INTO `log` VALUES ('超级用户', '购买', '纯黑色系韩系书包', '236', 45, '2023-12-18 04:42:02', 26);
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '纯黑色系韩系书包', '236', 45, '2023-12-18 04:43:41', 27);
INSERT INTO `log` VALUES ('超级用户', '购买', '纯黑色系韩系书包', '236', 45, '2023-12-18 04:43:48', 28);
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '匹克运动外套', '338', 23, '2023-12-18 05:14:12', 29);
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '特步篮球鞋', '399', 21, '2023-12-18 05:14:13', 30);
INSERT INTO `log` VALUES ('超级用户', '购买', '匹克运动外套', '338', 23, '2023-12-18 05:14:20', 31);
INSERT INTO `log` VALUES ('超级用户', '移出购物车', '特步篮球鞋', '399', 21, '2023-12-18 05:14:39', 32);
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '匹克运动外套', '338', 22, '2023-12-18 05:32:33', 33);
INSERT INTO `log` VALUES ('超级用户', '购买', '匹克运动外套', '338', 22, '2023-12-18 05:32:40', 34);
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '匹克运动外套', '338', 21, '2023-12-18 05:46:13', 35);
INSERT INTO `log` VALUES ('超级用户', '移出购物车', '匹克运动外套', '338', 21, '2023-12-18 05:46:16', 36);
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '匡威双肩包', '99', 23, '2023-12-18 05:46:20', 37);
INSERT INTO `log` VALUES ('超级用户', '移出购物车', '匡威双肩包', '99', 23, '2023-12-18 05:46:23', 38);
INSERT INTO `log` VALUES ('超级用户', '加入购物车', '匹克运动外套', '338', 21, '2023-12-18 05:54:35', 39);

SET FOREIGN_KEY_CHECKS = 1;
