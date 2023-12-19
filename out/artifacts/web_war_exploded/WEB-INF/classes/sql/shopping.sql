SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shopping
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping`  (
                             `s_user_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应用户',
                             `s_product_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '对应商品',
                             `a_u` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `s_id` int(0) NOT NULL AUTO_INCREMENT,
                             PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping
-- ----------------------------
INSERT INTO `shopping` VALUES ('1', '4', '2', 2);
INSERT INTO `shopping` VALUES ('1', '5', '2', 3);
INSERT INTO `shopping` VALUES ('1', '1', '2', 12);
INSERT INTO `shopping` VALUES ('1', '2', '2', 13);
INSERT INTO `shopping` VALUES ('1', '3', '2', 14);
INSERT INTO `shopping` VALUES ('1', '7', '2', 16);
INSERT INTO `shopping` VALUES ('1', '3', '1', 43);

SET FOREIGN_KEY_CHECKS = 1;
