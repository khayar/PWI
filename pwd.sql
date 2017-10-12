/*
SQLyog Community v11.31 (64 bit)
MySQL - 10.1.21-MariaDB : Database - pwd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pwd` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pwd`;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `brand_id` int(10) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `brand` */

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `company_id` int(10) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `company` */

/*Table structure for table `component_product` */

DROP TABLE IF EXISTS `component_product`;

CREATE TABLE `component_product` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `component_product_prodcut_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `component_product` */

/*Table structure for table `finished_product` */

DROP TABLE IF EXISTS `finished_product`;

CREATE TABLE `finished_product` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `finished_product_product_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `finished_product` */

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `inventory_id` int(10) NOT NULL AUTO_INCREMENT,
  `in_stock` int(10) DEFAULT NULL,
  `available_quantity` int(10) DEFAULT NULL,
  `in_transit` int(10) DEFAULT NULL,
  `mininum_order_quantity` int(10) DEFAULT NULL,
  `quantity_per_box` int(10) DEFAULT NULL,
  `reoder_point` int(10) DEFAULT NULL,
  `warehouse_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`inventory_id`),
  KEY `inventory_warehouse_FK` (`warehouse_id`),
  CONSTRAINT `inventory_warehouse_FK` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `inventory` */

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `location_id` int(10) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `location` */

/*Table structure for table `packaging_material` */

DROP TABLE IF EXISTS `packaging_material`;

CREATE TABLE `packaging_material` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `packaging_material_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `packaging_material` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) DEFAULT NULL,
  `brand_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `brand_product_FK` (`brand_id`),
  CONSTRAINT `brand_product_FK` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

/*Table structure for table `size` */

DROP TABLE IF EXISTS `size`;

CREATE TABLE `size` (
  `size_id` int(10) NOT NULL AUTO_INCREMENT,
  `size_name` varchar(100) DEFAULT NULL,
  `product_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`size_id`),
  KEY `size_product_FK` (`product_id`),
  CONSTRAINT `size_product_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `size` */

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `warehouse_id` int(10) NOT NULL AUTO_INCREMENT,
  `warehouse_name` varchar(100) DEFAULT NULL,
  `location_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`),
  KEY `location_warehouse_FK` (`location_id`),
  CONSTRAINT `location_warehouse_FK` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `warehouse` */

/*Table structure for table `warehouse_prodcut` */

DROP TABLE IF EXISTS `warehouse_prodcut`;

CREATE TABLE `warehouse_prodcut` (
  `warehouse_id` int(10) NOT NULL,
  `product_id` int(10) NOT NULL,
  PRIMARY KEY (`warehouse_id`,`product_id`),
  KEY `prodcut_warehouse_FK` (`product_id`),
  CONSTRAINT `prodcut_warehouse_FK` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `warehouse_product_FK` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `warehouse_prodcut` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
