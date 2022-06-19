INSERT INTO `fis_training`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('1', 'Hà Nội', '0571828451', 'Nguyễn Văn Kiên');
INSERT INTO `fis_training`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('2', 'Đà Nẵng', '0963121245', 'Nguyễn Tiến Hải');
INSERT INTO `fis_training`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('3', 'Hồ Chí Minh', '0946237112', 'Đặng Thu Thảo');
INSERT INTO `fis_training`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('4', 'Nha Trang', '0357826757', 'Phạm Duy Nam');
INSERT INTO `fis_training`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('5', 'Đà Lạt', '0754123578', 'Đỗ Thị Bích Ngọc');


INSERT INTO `fis_training`.`tbl_product` (`id`, `name`, `price`) VALUES ('1', 'Xôi', '15');
INSERT INTO `fis_training`.`tbl_product` (`id`, `name`, `price`) VALUES ('2', 'Bún chả', '30');
INSERT INTO `fis_training`.`tbl_product` (`id`, `name`, `price`) VALUES ('3', 'Phở gà', '35');
INSERT INTO `fis_training`.`tbl_product` (`id`, `name`, `price`) VALUES ('4', 'Phở Bò', '40');
INSERT INTO `fis_training`.`tbl_product` (`id`, `name`, `price`) VALUES ('5', 'Pizza', '79');
INSERT INTO `fis_training`.`tbl_product` (`id`, `name`, `price`) VALUES ('6', 'Bánh Mì', '15');


INSERT INTO `fis_training`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('1', '2019-03-07 12:23:59', 'CREATED', '80', '1');
INSERT INTO `fis_training`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('2', '2019-03-07 12:23:59', 'CREATED', '65', '1');
INSERT INTO `fis_training`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('3', '2019-03-07 12:23:59', 'CREATED', '79', '2');
INSERT INTO `fis_training`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('4', '2019-03-07 12:23:59', 'CREATED', '55', '3');
INSERT INTO `fis_training`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('5', '2019-03-07 12:23:59', 'CREATED', '45', '4');
INSERT INTO `fis_training`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('6', '2019-03-07 12:23:59', 'CREATED', '75', '5');



INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('1', '15', '1', '1', '1');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('2', '30', '1', '1', '2');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('3', '35', '1', '1', '3');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('4', '30', '1', '2', '2');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('5', '35', '1', '2', '3');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('6', '79', '1', '3', '5');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('7', '40', '1', '4', '4');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('8', '15', '1', '4', '6');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('9', '15', '1', '5', '1');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('10', '30', '1', '5', '2');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('11', '35', '1', '6', '3');
INSERT INTO `fis_training`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('12', '40', '1', '6', '4');


