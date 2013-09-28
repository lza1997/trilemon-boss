# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-top-spy
# Generation Time: 2013-09-13 08:02:45 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table isv
# ------------------------------------------------------------

DROP TABLE IF EXISTS `isv`;

CREATE TABLE `isv` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `bulletin` varchar(4096) NOT NULL DEFAULT '',
  `certification` varchar(32) NOT NULL DEFAULT '',
  `tp` varchar(32) DEFAULT NULL,
  `wangwang` varchar(64) NOT NULL DEFAULT '',
  `phone` varchar(64) NOT NULL DEFAULT '',
  `email` varchar(64) NOT NULL DEFAULT '',
  `crawl_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_isv_name_crawl_time` (`name`,`crawl_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



# Dump of table isv_app
# ------------------------------------------------------------

DROP TABLE IF EXISTS `isv_app`;

CREATE TABLE `isv_app` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isv_name` varchar(128) DEFAULT NULL,
  `app_name` varchar(32) NOT NULL DEFAULT '',
  `service_code` varchar(32) NOT NULL DEFAULT '',
  `app_desc` varchar(1024) NOT NULL DEFAULT '',
  `app_logo` varchar(1024) NOT NULL DEFAULT '',
  `app_first_category` varchar(32) NOT NULL DEFAULT '其他',
  `app_second_category` varchar(32) NOT NULL DEFAULT '其他',
  `app_third_category` varchar(32) NOT NULL DEFAULT '其他',
  `valid_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `pay_user_num` int(11) unsigned NOT NULL DEFAULT '0',
  `free_user_num` int(11) unsigned NOT NULL DEFAULT '0',
  `pv` int(11) unsigned NOT NULL DEFAULT '0',
  `rate` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `usability_rate` decimal(10,2) NOT NULL DEFAULT '0.00',
  `service_attitude_rate` decimal(10,2) NOT NULL DEFAULT '0.00',
  `stability_rate` decimal(10,2) NOT NULL DEFAULT '0.00',
  `professional_level` decimal(10,2) NOT NULL DEFAULT '0.00',
  `rank` int(11) unsigned NOT NULL DEFAULT '0',
  `revenue` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `order_num` int(10) unsigned NOT NULL DEFAULT '0',
  `crawl_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_isv_app_service_code_and_crawl_time` (`service_code`,`crawl_time`),
  KEY `index_isv_app_app_name` (`app_name`),
  KEY `index_isv_app_crawl_time` (`crawl_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



# Dump of table isv_app_detail_page
# ------------------------------------------------------------

DROP TABLE IF EXISTS `isv_app_detail_page`;

CREATE TABLE `isv_app_detail_page` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `service_code` varchar(32) NOT NULL DEFAULT '',
  `detail_page` mediumtext NOT NULL,
  `crawl_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_isv_app_detail_page_service_code_and_crawl_time` (`service_code`,`crawl_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



# Dump of table isv_app_market_share
# ------------------------------------------------------------

DROP TABLE IF EXISTS `isv_app_market_share`;

CREATE TABLE `isv_app_market_share` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `service_code` varchar(32) NOT NULL DEFAULT '',
  `share_type` varchar(16) NOT NULL DEFAULT '',
  `source` varchar(16) NOT NULL DEFAULT '',
  `share` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `crawl_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_isv_app_market_share_service_code_and_crawl_time` (`service_code`,`crawl_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table isv_app_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `isv_app_order`;

CREATE TABLE `isv_app_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `service_code` varchar(32) NOT NULL DEFAULT '',
  `nick` varchar(64) NOT NULL DEFAULT '',
  `seller_rate` varchar(16) NOT NULL DEFAULT '',
  `rate_sum` varchar(16) NOT NULL DEFAULT '',
  `is_b2c_seller` tinyint(4) NOT NULL DEFAULT '0',
  `is_plan_subed` tinyint(4) NOT NULL DEFAULT '0',
  `is_tryout_subed` tinyint(4) NOT NULL DEFAULT '0',
  `pay_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `deadline` varchar(64) NOT NULL DEFAULT '',
  `version` varchar(64) NOT NULL DEFAULT '',
  `crawl_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_isv_app_service_code_and_nick_and_pay_time` (`service_code`,`nick`,`pay_time`),
  KEY `index_isv_app_order_service_code` (`service_code`),
  KEY `index_isv_app_order_version_deadline_pay_time` (`version`,`deadline`,`pay_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table isv_app_plan
# ------------------------------------------------------------

DROP TABLE IF EXISTS `isv_app_plan`;

CREATE TABLE `isv_app_plan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `service_code` varchar(32) NOT NULL DEFAULT '',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `promotion_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `version` varchar(32) NOT NULL DEFAULT '',
  `deadline` varchar(32) NOT NULL DEFAULT '',
  `crawl_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_isv_app_plan_service_code_and_crawl_time` (`service_code`,`crawl_time`),
  KEY `index_isv_app_plan_version_deadline_crawl_time` (`version`,`deadline`,`crawl_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table market
# ------------------------------------------------------------

DROP TABLE IF EXISTS `market`;

CREATE TABLE `market` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isv_num` int(11) unsigned NOT NULL DEFAULT '0',
  `fuwu_num` int(11) unsigned NOT NULL DEFAULT '0',
  `app_num` int(11) unsigned NOT NULL DEFAULT '0',
  `order_num` int(11) unsigned NOT NULL DEFAULT '0',
  `revenue` decimal(11,0) unsigned NOT NULL DEFAULT '0',
  `order_num_exclude_taobao` int(11) unsigned NOT NULL DEFAULT '0',
  `revenue_exclude_taobao` decimal(11,0) unsigned NOT NULL DEFAULT '0',
  `crawl_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_market_crawl_time` (`crawl_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
