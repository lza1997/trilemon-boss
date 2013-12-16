# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-360boss-rate
# Generation Time: 2013-12-16 13:22:07 +0000
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

LOCK TABLES `rate_comment_setting` WRITE;
/*!40000 ALTER TABLE `rate_comment_setting` DISABLE KEYS */;

INSERT INTO `rate_comment_setting` (`id`, `user_id`, `content`, `status`, `add_time`, `upd_time`)
VALUES
	(1,56912708,'我试一个评论',0,'2013-11-28 17:25:55','2013-11-28 17:25:55'),
	(2,56912708,'测试',0,'2013-11-28 17:26:07','2013-11-28 17:26:07'),
	(3,56912708,'123',0,'2013-12-11 09:43:26','2013-12-11 09:43:26'),
	(4,56912708,'123456',0,'2013-12-11 09:43:31','2013-12-11 09:43:31');

/*!40000 ALTER TABLE `rate_comment_setting` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rate_filter_trade_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_filter_trade_1`;

CREATE TABLE `rate_filter_trade_1` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL DEFAULT '0',
  `buyer_nick` varchar(64) NOT NULL DEFAULT '',
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
  `buyer_nick` varchar(64) NOT NULL DEFAULT '',
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

LOCK TABLES `rate_log_1` WRITE;
/*!40000 ALTER TABLE `rate_log_1` DISABLE KEYS */;

INSERT INTO `rate_log_1` (`id`, `user_id`, `trade_num`, `order_num`, `inserted_rate_order_num`, `day14_rate_num`, `day15_rate_num`, `good_rate_num`, `neutral_rate_num`, `bad_rate_num`, `filtered_credit_trade_num`, `filtered_register_day_trade_num`, `filtered_good_rate_trade_num`, `filtered_bad_rate_trade_num`, `filtered_blacklist_trade_num`, `rate_status`, `rate_start_time`, `rate_end_time`, `add_time`, `upd_time`)
VALUES
	(1,56912708,0,0,0,0,0,0,0,0,0,0,0,0,0,2,'2013-11-28 16:29:46','2013-11-29 16:29:46','0000-00-00 00:00:00','2013-11-29 16:31:40'),
	(2,56912708,0,0,0,0,0,0,0,0,0,0,0,0,0,2,'2013-11-28 16:29:46','2013-11-29 16:29:46','0000-00-00 00:00:00','2013-11-29 16:51:11'),
	(3,56912708,0,0,0,0,0,0,0,0,0,0,0,0,0,2,'2013-11-28 17:20:59','2013-11-29 17:20:59','0000-00-00 00:00:00','2013-11-29 17:21:48'),
	(4,56912708,0,0,0,0,0,0,0,0,0,0,0,0,0,1,'2013-11-29 17:43:34','2013-11-29 17:53:19','0000-00-00 00:00:00','2013-11-29 17:46:08');

/*!40000 ALTER TABLE `rate_log_1` ENABLE KEYS */;
UNLOCK TABLES;


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
  `buyer_nick` varchar(64) NOT NULL DEFAULT '',
  `result` varchar(8) NOT NULL DEFAULT '',
  `content` varchar(500) NOT NULL DEFAULT '',
  `created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `tid` bigint(11) NOT NULL DEFAULT '0',
  `oid` bigint(11) NOT NULL DEFAULT '0',
  `order_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `rate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `rate_order_1` WRITE;
/*!40000 ALTER TABLE `rate_order_1` DISABLE KEYS */;

INSERT INTO `rate_order_1` (`id`, `user_id`, `comment`, `item_num_iid`, `buyer_nick`, `result`, `content`, `created`, `item_title`, `item_price`, `tid`, `oid`, `order_end_time`, `status`, `rate_time`, `add_time`, `upd_time`)
VALUES
	(1,56912708,'测试评论',0,'','bad','','0000-00-00 00:00:00','',0.00,1,1,'2013-12-14 20:23:38',0,'2013-11-28 20:23:38','0000-00-00 00:00:00','2013-12-16 17:25:29'),
	(2,56912708,'测试评论2',0,'','bad','','0000-00-00 00:00:00','',0.00,2,2,'2013-12-14 20:23:38',0,'2013-11-28 20:23:38','0000-00-00 00:00:00','2013-12-16 17:25:32'),
	(3,56912708,'我试一个评论',0,'','bad','','0000-00-00 00:00:00','',0.00,3,3,'2013-12-14 20:23:38',0,'2013-11-28 20:23:38','0000-00-00 00:00:00','2013-12-16 17:25:33'),
	(4,56912708,'我试一个评论',0,'汤汤','','','0000-00-00 00:00:00','',0.00,466124573220033,466124573220033,'2013-12-14 20:23:38',0,'2013-11-29 17:43:50','0000-00-00 00:00:00','2013-12-16 17:25:33');

/*!40000 ALTER TABLE `rate_order_1` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table rate_order_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rate_order_2`;

CREATE TABLE `rate_order_2` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL DEFAULT '0',
  `comment` varchar(500) NOT NULL DEFAULT '',
  `item_num_iid` bigint(11) NOT NULL DEFAULT '0',
  `buyer_nick` varchar(64) NOT NULL DEFAULT '',
  `result` varchar(8) NOT NULL DEFAULT '',
  `content` varchar(500) NOT NULL DEFAULT '',
  `created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) NOT NULL DEFAULT '0.00',
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

LOCK TABLES `rate_setting` WRITE;
/*!40000 ALTER TABLE `rate_setting` DISABLE KEYS */;

INSERT INTO `rate_setting` (`id`, `user_id`, `status`, `rate_type`, `auto_good_rate`, `auto_neutral_rate`, `auto_bad_rate`, `enable_sms_notify`, `sms_notify_phone`, `enable_credit_filter`, `credit_filter_min`, `credit_filter_max`, `enable_good_rate_filter`, `good_rate_filter`, `enable_bad_rate_filter`, `bad_rate_filter`, `enable_register_day_filter`, `register_day_filter`, `enable_blacklist_filter`, `last_rate_start_time`, `last_rate_end_time`, `rate_status`, `rate_owner`, `add_time`, `upd_time`)
VALUES
	(1,56912708,1,0,1,0,0,0,'',0,0,0,0,0,0,0,0,0,0,'2013-11-29 17:43:34','2013-11-29 17:53:19',1,'rate-1','2013-11-28 17:21:37','2013-11-29 17:46:07');

/*!40000 ALTER TABLE `rate_setting` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
