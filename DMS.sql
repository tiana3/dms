/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - dms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dms`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `admin_role` */

DROP TABLE IF EXISTS `admin_role`;

CREATE TABLE `admin_role` (
  `adminId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_role` */

/*Table structure for table `cartype` */

DROP TABLE IF EXISTS `cartype`;

CREATE TABLE `cartype` (
  `modelId` int(11) NOT NULL AUTO_INCREMENT,
  `factory` varchar(20) DEFAULT NULL,
  `model` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`modelId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `cartype` */

insert  into `cartype`(`modelId`,`factory`,`model`) values (10,'东本','CRV'),(11,'东本','CIVIC'),(14,'东本','XRV'),(15,'宝马','X5'),(17,'奔驰','S60'),(19,'宝马','X3'),(20,'大众','甲壳虫');

/*Table structure for table `custom` */

DROP TABLE IF EXISTS `custom`;

CREATE TABLE `custom` (
  `orderId` varchar(20) DEFAULT NULL,
  `customName` varchar(200) DEFAULT NULL,
  `customPrice` double DEFAULT NULL,
  `customId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`customId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `custom` */

insert  into `custom`(`orderId`,`customName`,`customPrice`,`customId`,`employeeId`) values ('20170829001','后杠拆装',100,9,9),('20170829001','后杠喷漆',400,10,10),('20170829002','后杠拆装',100,11,9),('20170829002','后杠喷漆',400,12,10),('20170829003','后杠拆装',100,13,9),('20170829003','后杠喷漆',400,14,10),('20170829004','后杠拆装',100,15,9),('20170829004','后杠喷漆',400,16,10),('20170829005','后杠拆装',100,17,9),('20170829005','后杠喷漆',400,18,10),('20170829006','后杠拆装',100,19,9),('20170829006','后杠喷漆',400,20,10);

/*Table structure for table `customercarinfo` */

DROP TABLE IF EXISTS `customercarinfo`;

CREATE TABLE `customercarinfo` (
  `customerCarInfoId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(20) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `idCard` varchar(20) DEFAULT NULL,
  `plateNumber` varchar(20) DEFAULT NULL,
  `VIN` varchar(20) DEFAULT NULL,
  `engineNumber` varchar(20) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `gearbox` varchar(20) DEFAULT NULL,
  `buyDate` varchar(20) DEFAULT NULL,
  `policy` varchar(20) DEFAULT NULL,
  `modelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`customerCarInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `customercarinfo` */

insert  into `customercarinfo`(`customerCarInfoId`,`customerName`,`gender`,`address`,`phone`,`idCard`,`plateNumber`,`VIN`,`engineNumber`,`color`,`gearbox`,`buyDate`,`policy`,`modelId`) values (1,'黄三','男','成都市金牛区茶店子','15888888888','510','川A88888','LVHRE4851A2558454','A35221','红','AT','2015-7-18','2017-7-18',11);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`departmentId`,`name`) values (1,'事故定损部'),(2,'售后前台'),(3,'维修车间');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `idCard` varchar(20) DEFAULT NULL,
  `jobId` int(11) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `employee_job_fk` (`jobId`),
  CONSTRAINT `employee_job_fk` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`employeeId`,`name`,`gender`,`phone`,`idCard`,`jobId`) values (1,'张三','男','13555555555','510',1),(2,'张四','女','13666666666','510',1),(3,'李二','男','13777777777','510',2),(5,'李四','女','135','510',1),(8,'李技师','男','13333333333','510',4),(9,'陈技师','男','13333333333','510',5),(10,'朱技师','男','13333333333','510',6),(11,'赖技师','男','13333333333','510',7),(12,'朱军','男','13333333333','510',9),(13,'李兵','男','13333333333','510',10);

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `jobId` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`jobId`),
  KEY `job_department_fk` (`departmentId`),
  CONSTRAINT `job_department_fk` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `job` */

insert  into `job`(`jobId`,`NAME`,`departmentId`) values (1,'服务顾问',2),(2,'定损员',1),(3,'服务经理',2),(4,'机电技师',3),(5,'钣金技师',3),(6,'油漆技师',3),(7,'美容技师',3),(8,'信息员',2),(9,'车间主管',3),(10,'质检',3);

/*Table structure for table `order_part` */

DROP TABLE IF EXISTS `order_part`;

CREATE TABLE `order_part` (
  `orderId` varchar(20) DEFAULT NULL,
  `partId` int(11) DEFAULT NULL,
  `picker` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `order_part` */

insert  into `order_part`(`orderId`,`partId`,`picker`,`id`) values ('20170829001',5,NULL,1),('20170829002',5,NULL,2),('20170829003',5,NULL,3),('20170829004',5,NULL,4),('20170829005',5,NULL,5),('20170829006',5,NULL,6);

/*Table structure for table `order_workplace` */

DROP TABLE IF EXISTS `order_workplace`;

CREATE TABLE `order_workplace` (
  `orderId` varchar(20) DEFAULT NULL,
  `workplaceId` int(11) DEFAULT NULL,
  `Ma_Tec` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_workplace` */

/*Table structure for table `orderidbuild` */

DROP TABLE IF EXISTS `orderidbuild`;

CREATE TABLE `orderidbuild` (
  `num` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderidbuild` */

insert  into `orderidbuild`(`num`) values ('20170830001');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderId` varchar(20) NOT NULL,
  `customerCarInfoId` int(11) DEFAULT NULL,
  `SA` int(11) DEFAULT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `mileage` double DEFAULT NULL,
  `carRemark` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `expectDate` varchar(20) DEFAULT NULL,
  `repairTypeId` int(11) DEFAULT NULL,
  `sender` varchar(20) DEFAULT NULL,
  `senderPhone` varchar(20) DEFAULT NULL,
  `orderStateId` int(11) DEFAULT '1',
  `workPrice` double DEFAULT '0',
  `partPrice` double DEFAULT '0',
  `customPrice` double DEFAULT '0',
  `discountPrice` double DEFAULT '0',
  `inspector` int(11) DEFAULT '0',
  `completedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`orderId`,`customerCarInfoId`,`SA`,`Date`,`mileage`,`carRemark`,`remark`,`expectDate`,`repairTypeId`,`sender`,`senderPhone`,`orderStateId`,`workPrice`,`partPrice`,`customPrice`,`discountPrice`,`inspector`,`completedDate`) values ('20170824002',1,1,'2017-8-24 16:00',10000,NULL,NULL,'2017-8-24 17:00',1,'李小姐','13666666666',1,NULL,NULL,NULL,NULL,0,NULL),('20170829001',1,5,'2017-8-29 18:39:05',15000,'车身脏','无','2017-08-29 18:25',7,'吴美女','13555555555',1,0,0,0,0,0,NULL),('20170829009',1,5,'2017-8-29 19:31:59',10000,'','','2017-08-29 19:45',7,'吴美女','13555555555',1,0,0,0,0,0,NULL),('20170829010',1,5,'2017-8-29 19:37:25',15000,'','','2017-08-29 19:45',7,'吴美女','13555555555',1,0,0,0,0,0,NULL),('20170829011',1,5,'2017-8-29 19:37:51',15000,'','','2017-08-29 19:45',7,'吴美女','13555555555',1,0,0,0,0,0,NULL),('20170829012',1,5,'2017-8-29 19:37:52',15000,'','','2017-08-29 19:45',7,'吴美女','13555555555',1,0,0,0,0,0,NULL),('20170829013',1,5,'2017-8-29 19:51:38',1,'','','2017-08-29 19:51',7,'吴美女','13555555555',1,0,0,0,0,0,NULL),('20170830001',1,5,'2017-8-30 10:48:46',1,'','','2017-08-30 10:48',7,'吴美女','13555555555',1,0,0,0,0,0,NULL);

/*Table structure for table `orderstate` */

DROP TABLE IF EXISTS `orderstate`;

CREATE TABLE `orderstate` (
  `orderStateId` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`orderStateId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `orderstate` */

insert  into `orderstate`(`orderStateId`,`state`) values (1,'在修'),(2,'完工'),(3,'已结算');

/*Table structure for table `part` */

DROP TABLE IF EXISTS `part`;

CREATE TABLE `part` (
  `partId` int(11) NOT NULL AUTO_INCREMENT,
  `partName` varchar(20) DEFAULT NULL,
  `partNo` varchar(20) DEFAULT NULL,
  `buyingPrice` double DEFAULT NULL,
  `sellingPrice` double DEFAULT NULL,
  `modelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`partId`),
  KEY `part_cartype_fk` (`modelId`),
  CONSTRAINT `part_cartype_fk` FOREIGN KEY (`modelId`) REFERENCES `cartype` (`modelId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `part` */

insert  into `part`(`partId`,`partName`,`partNo`,`buyingPrice`,`sellingPrice`,`modelId`) values (2,'后杠','001001',600,780,17),(5,'后杠','001003',500,700,14),(7,'前挡玻璃','001005',800,1000,10),(8,'右前车门','001006',2000,2800,10),(9,'右倒车镜','001007',1200,1530,10),(10,'左倒车镜','001008',1200,1530,10),(11,'左后车门','001009',1500,2000,10),(12,'右后车门','001011',1500,2000,15);

/*Table structure for table `powers` */

DROP TABLE IF EXISTS `powers`;

CREATE TABLE `powers` (
  `powerId` int(11) NOT NULL AUTO_INCREMENT,
  `power` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`powerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `powers` */

/*Table structure for table `repairtype` */

DROP TABLE IF EXISTS `repairtype`;

CREATE TABLE `repairtype` (
  `repairTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `repairType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`repairTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `repairtype` */

insert  into `repairtype`(`repairTypeId`,`repairType`) values (1,'事故现金'),(2,'保险理赔'),(3,'三包'),(4,'保养'),(5,'小修'),(6,'免费检查'),(7,'美容');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

/*Table structure for table `role_power` */

DROP TABLE IF EXISTS `role_power`;

CREATE TABLE `role_power` (
  `roleId` int(11) DEFAULT NULL,
  `powerId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_power` */

/*Table structure for table `standardhour` */

DROP TABLE IF EXISTS `standardhour`;

CREATE TABLE `standardhour` (
  `standardHourId` int(11) NOT NULL AUTO_INCREMENT,
  `standardHour` double DEFAULT NULL,
  PRIMARY KEY (`standardHourId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `standardhour` */

/*Table structure for table `workplace` */

DROP TABLE IF EXISTS `workplace`;

CREATE TABLE `workplace` (
  `workplaceId` int(11) NOT NULL AUTO_INCREMENT,
  `workplaceName` varchar(20) DEFAULT NULL,
  `workhour` double DEFAULT NULL,
  `workpay` double DEFAULT NULL,
  `modelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`workplaceId`),
  KEY `modelId` (`modelId`),
  CONSTRAINT `workplace_ibfk_1` FOREIGN KEY (`modelId`) REFERENCES `cartype` (`modelId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `workplace` */

insert  into `workplace`(`workplaceId`,`workplaceName`,`workhour`,`workpay`,`modelId`) values (7,'拆装后杠',1,150,NULL),(8,'拆装前挡玻',2,300,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
