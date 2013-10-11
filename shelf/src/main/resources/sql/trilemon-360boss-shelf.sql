# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-360boss-shelf
# Generation Time: 2013-10-11 16:42:33 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table plan
# ------------------------------------------------------------

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `plan_setting_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_name` varchar(32) NOT NULL DEFAULT '',
  `item_pic_url` varchar(1024) NOT NULL DEFAULT '',
  `status` int(11) unsigned NOT NULL DEFAULT '0',
  `plan_listing_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `listing_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table plan_setting
# ------------------------------------------------------------

DROP TABLE IF EXISTS `plan_setting`;

CREATE TABLE `plan_setting` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `name` varchar(32) NOT NULL DEFAULT '',
  `name_pinyin` varchar(256) NOT NULL DEFAULT '',
  `plan_type` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_adjust_showcase` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `exclude_keywords` varchar(1024) NOT NULL DEFAULT '',
  `exclude_item_iids` varchar(1024) NOT NULL DEFAULT '',
  `include_cids` varchar(1024) NOT NULL DEFAULT '',
  `include_keywords` varchar(1024) NOT NULL DEFAULT '',
  `include_item_iids` varchar(1024) NOT NULL DEFAULT '',
  `adjust_intervals` varchar(256) NOT NULL DEFAULT '',
  `adjust_intervals_type` tinyint(1) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `last_adjust_item_num` int(11) NOT NULL DEFAULT '0',
  `last_adjust_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
