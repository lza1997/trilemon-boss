# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-360boss-rate
# Generation Time: 2013-12-07 12:54:32 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table rate_comment_setting
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_comment_setting`;

CREATE TABLE `rate_comment_setting` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL DEFAULT '0',
  `content` varchar(500) NOT NULL DEFAULT '',
  `status` tinyint(11) NOT NULL DEFAULT '1',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rate_filter_trade_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_filter_trade_1`;

CREATE TABLE `rate_filter_trade_1` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL DEFAULT '0',
  `buyer_nick` varchar(32) NOT NULL DEFAULT '',
  `tid` bigint(11) NOT NULL DEFAULT '0',
  `is_seller_rate` tinyint(1) NOT NULL DEFAULT '0',
  `is_buyer_rate` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(11) NOT NULL DEFAULT '0',
  `filter_type` tinyint(11) NOT NULL DEFAULT '0',
  `filter_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rate_filter_trade_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_filter_trade_2`;

CREATE TABLE `rate_filter_trade_2` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL DEFAULT '0',
  `buyer_nick` varchar(32) NOT NULL DEFAULT '',
  `tid` bigint(11) NOT NULL DEFAULT '0',
  `is_seller_rate` tinyint(1) NOT NULL DEFAULT '0',
  `is_buyer_rate` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(11) NOT NULL DEFAULT '0',
  `filter_type` tinyint(11) NOT NULL DEFAULT '0',
  `filter_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rate_log_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_log_1`;

CREATE TABLE `rate_log_1` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `order_num` int(11) unsigned NOT NULL DEFAULT '0',
  `inserted_rate_order_num` int(11) unsigned NOT NULL DEFAULT '0',
  `day14_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `day15_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `good_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `neutral_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `bad_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_credit_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_register_day_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_good_rate_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_bad_rate_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_blacklist_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `rate_status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `rate_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `rate_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rate_log_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_log_2`;

CREATE TABLE `rate_log_2` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `order_num` int(11) unsigned NOT NULL DEFAULT '0',
  `inserted_rate_order_num` int(11) unsigned NOT NULL DEFAULT '0',
  `day14_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `day15_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `good_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `neutral_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `bad_rate_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_credit_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_register_day_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_good_rate_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_bad_rate_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `filtered_blacklist_trade_num` int(11) unsigned NOT NULL DEFAULT '0',
  `rate_status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `rate_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `rate_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rate_order_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_order_1`;

CREATE TABLE `rate_order_1` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL DEFAULT '0',
  `comment` varchar(500) NOT NULL DEFAULT '',
  `item_num_iid` bigint(11) NOT NULL DEFAULT '0',
  `buyer_nick` varchar(32) NOT NULL DEFAULT '',
  `result` varchar(8) NOT NULL DEFAULT '',
  `tid` bigint(11) NOT NULL DEFAULT '0',
  `oid` bigint(11) NOT NULL DEFAULT '0',
  `order_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `rate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rate_order_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_order_2`;

CREATE TABLE `rate_order_2` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL DEFAULT '0',
  `comment` varchar(500) NOT NULL DEFAULT '',
  `item_num_iid` bigint(11) NOT NULL DEFAULT '0',
  `buyer_nick` varchar(32) NOT NULL DEFAULT '',
  `result` varchar(8) NOT NULL DEFAULT '',
  `tid` bigint(11) NOT NULL DEFAULT '0',
  `oid` bigint(11) NOT NULL DEFAULT '0',
  `order_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(11) NOT NULL DEFAULT '0',
  `rate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rate_setting
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_setting`;

CREATE TABLE `rate_setting` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `rate_type` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `auto_good_rate` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `auto_neutral_rate` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `auto_bad_rate` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `enable_sms_notify` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `sms_notify_phone` varchar(32) NOT NULL DEFAULT '',
  `enable_credit_filter` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `credit_filter_min` int(11) unsigned NOT NULL DEFAULT '0',
  `credit_filter_max` int(11) unsigned NOT NULL DEFAULT '0',
  `enable_good_rate_filter` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `good_rate_filter` float unsigned NOT NULL DEFAULT '0',
  `enable_bad_rate_filter` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `bad_rate_filter` float unsigned NOT NULL DEFAULT '0',
  `enable_register_day_filter` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `register_day_filter` int(11) unsigned NOT NULL DEFAULT '0',
  `enable_blacklist_filter` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `last_rate_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_rate_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `rate_status` tinyint(11) NOT NULL DEFAULT '0',
  `rate_owner` varchar(32) NOT NULL DEFAULT '',
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
