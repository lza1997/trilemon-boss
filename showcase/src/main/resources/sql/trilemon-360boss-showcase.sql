# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-360boss-showcase
# Generation Time: 2013-11-12 13:55:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table adjust_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `adjust_detail`;

CREATE TABLE `adjust_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL,
  `item_num_iid` bigint(11) unsigned NOT NULL,
  `item_title` varchar(128) NOT NULL DEFAULT '',
  `item_title_pinyin` varchar(256) NOT NULL DEFAULT '',
  `item_pic_url` varchar(1024) NOT NULL DEFAULT '',
  `adjust_type` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `adjust_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_adjust_detail_item_num_iid` (`item_num_iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table setting
# ------------------------------------------------------------

DROP TABLE IF EXISTS `setting`;

CREATE TABLE `setting` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `rule_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `include_min_sale_volume` int(11) unsigned NOT NULL DEFAULT '0',
  `include_max_sale_volume` int(11) unsigned NOT NULL DEFAULT '0',
  `include_min_price` decimal(11,2) unsigned NOT NULL DEFAULT '0.00',
  `include_max_price` decimal(11,2) unsigned NOT NULL DEFAULT '0.00',
  `include_keywords` varchar(128) NOT NULL DEFAULT '',
  `include_seller_cids` varchar(1024) NOT NULL DEFAULT '',
  `include_item_num_iids` varchar(1024) NOT NULL DEFAULT '',
  `exclude_item_num_iids` varchar(1024) NOT NULL DEFAULT '',
  `is_exclude_item_delisting_within` tinyint(1) NOT NULL DEFAULT '0',
  `exclude_item_delisting_within` int(11) unsigned NOT NULL DEFAULT '0',
  `is_exclude_item_inventory_lt` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `exclude_item_inventory_lt` int(11) unsigned NOT NULL DEFAULT '0',
  `is_exclude_item_delisting_after` tinyint(1) NOT NULL DEFAULT '0',
  `exclude_item_delisting_after` int(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_setting_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
