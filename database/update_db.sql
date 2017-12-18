
DROP DATABASE IF EXISTS `car`;
CREATE DATABASE IF NOT EXISTS `car`;
USE `car`;


DROP TABLE IF EXISTS `accessory`;
CREATE TABLE IF NOT EXISTS `accessory` (
  `id_accessory` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` decimal(20,2) NOT NULL,
  PRIMARY KEY (`id_accessory`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id_location` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) NOT NULL,
  `link` varchar(2000) NOT NULL,
  PRIMARY KEY (`id_location`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `id_oder` bigint(20) NOT NULL AUTO_INCREMENT,
  `pick_up_date` datetime NOT NULL,
  `drop_off_date` datetime NOT NULL,
  `status` varchar(100) NOT NULL,
  `total_price` decimal(20,2) NOT NULL,
  `id_pick_up_location` bigint(20) NOT NULL,
  `id_drop_off_location` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_rented_car` bigint(20) DEFAULT NULL,
  `id_accessory` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_oder`),
  KEY `idx_order_id_user` (`id_user`),
  KEY `idx_order_id_accessory` (`id_accessory`),
  KEY `idx_order_id_pick_up_location` (`id_pick_up_location`),
  KEY `idx_order_id_drop_off_location` (`id_drop_off_location`),
  KEY `idx_order_id_rented_car` (`id_rented_car`),
  CONSTRAINT `fk_order_accessories` FOREIGN KEY (`id_accessory`) REFERENCES `accessory` (`id_accessory`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_locations_drop` FOREIGN KEY (`id_drop_off_location`) REFERENCES `location` (`id_location`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_locations_pick` FOREIGN KEY (`id_pick_up_location`) REFERENCES `location` (`id_location`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_rented_cars` FOREIGN KEY (`id_rented_car`) REFERENCES `rented_car` (`id_rented_car`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_users` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `rented_car`;
CREATE TABLE IF NOT EXISTS `rented_car` (
  `id_rented_car` bigint(20) NOT NULL AUTO_INCREMENT,
  `model` varchar(50) NOT NULL,
  `year` year(4) NOT NULL,
  `transmition` varchar(50) NOT NULL DEFAULT 'AUTO',
  `wheel_drive` varchar(50) NOT NULL DEFAULT 'REAR',
  `fuil_type` varchar(50) NOT NULL DEFAULT 'PETROL',
  `color` varchar(50) NOT NULL,
  `image` varchar(1000) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `readiness` varchar(50) NOT NULL,
  `id_accessory` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_rented_car`),
  KEY `idx_rented_cars_id_accessory` (`id_accessory`),
  CONSTRAINT `fk_rented_cars_accessories` FOREIGN KEY (`id_accessory`) REFERENCES `accessory` (`id_accessory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `salon`;
CREATE TABLE IF NOT EXISTS `salon` (
  `id_salon` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `id_location` bigint(20) NOT NULL,
  `id_rented_car` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_salon`),
  KEY `idx_salons_id_rented_car` (`id_rented_car`),
  KEY `idx_salons_id_location` (`id_location`),
  CONSTRAINT `fk_salons_locations` FOREIGN KEY (`id_location`) REFERENCES `location` (`id_location`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_salons_rented_cars` FOREIGN KEY (`id_rented_car`) REFERENCES `rented_car` (`id_rented_car`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `title` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `driver_license` varchar(50) NOT NULL,
  `role` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;