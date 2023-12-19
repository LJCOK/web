SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
                            `p_describe` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品描述',
                            `p_price` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '价格',
                            `p_num` int(0) NOT NULL COMMENT '剩余数量',
                            `p_sale` int(0) NULL DEFAULT NULL,
                            `p_sales_volume` int(0) NULL DEFAULT NULL,
                            `p_id` int(0) NOT NULL AUTO_INCREMENT,
                            PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('匡威双肩包', '99', 23, 0, 0, 2);
INSERT INTO `product` VALUES ('匹克运动外套', '338', 21, 0, 0, 3);
INSERT INTO `product` VALUES ('特步篮球鞋', '399', 21, 0, 0, 4);
INSERT INTO `product` VALUES ('高领卫衣', '188', 23, 0, 0, 6);
INSERT INTO `product` VALUES ('纯黑色系韩系书包1', '236', 44, 0, 0, 7);

SET FOREIGN_KEY_CHECKS = 1;
