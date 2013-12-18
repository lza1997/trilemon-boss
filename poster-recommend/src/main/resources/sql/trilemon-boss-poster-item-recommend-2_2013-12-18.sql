# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-boss-poster-item-recommend-2
# Generation Time: 2013-12-18 10:16:55 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table poster_recommend_activity_3
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_3`;

CREATE TABLE `poster_recommend_activity_3` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `title` varchar(64) NOT NULL DEFAULT '',
  `color` char(7) NOT NULL DEFAULT '',
  `size` int(11) unsigned NOT NULL,
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `detail_page_position` tinyint(4) unsigned NOT NULL,
  `publish_html` varchar(5120) NOT NULL,
  `publish_type` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `publish_owner` varchar(32) NOT NULL DEFAULT '',
  `publish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `unpublish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `unpublish_owner` varchar(11) NOT NULL DEFAULT '',
  `publish_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `publish_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_activity_4
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_4`;

CREATE TABLE `poster_recommend_activity_4` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `title` varchar(64) NOT NULL DEFAULT '',
  `color` char(7) NOT NULL DEFAULT '',
  `size` int(11) unsigned NOT NULL,
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `detail_page_position` tinyint(4) unsigned NOT NULL,
  `publish_html` varchar(5120) NOT NULL,
  `publish_type` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `publish_owner` varchar(32) NOT NULL DEFAULT '',
  `publish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `unpublish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `unpublish_owner` varchar(32) NOT NULL DEFAULT '',
  `publish_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `publish_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_activity_item_3
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_item_3`;

CREATE TABLE `poster_recommend_activity_item_3` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL,
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(128) NOT NULL DEFAULT '',
  `copy` varchar(1024) NOT NULL DEFAULT '',
  `template_sequence_index` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_activity_item_4
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_item_4`;

CREATE TABLE `poster_recommend_activity_item_4` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL,
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(128) NOT NULL DEFAULT '',
  `copy` varchar(1024) NOT NULL DEFAULT '',
  `template_sequence_index` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_publish_item_3
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_3`;

CREATE TABLE `poster_recommend_publish_item_3` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(1024) NOT NULL DEFAULT '',
  `detail_page_position` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `publish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_publish_item_4
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_4`;

CREATE TABLE `poster_recommend_publish_item_4` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(1024) NOT NULL DEFAULT '',
  `detail_page_position` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `publish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_publish_item_detail_page_3
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_detail_page_3`;

CREATE TABLE `poster_recommend_publish_item_detail_page_3` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(11) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(11) NOT NULL DEFAULT '',
  `desc` mediumtext NOT NULL,
  `backup_desc` mediumtext,
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_publish_item_detail_page_4
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_detail_page_4`;

CREATE TABLE `poster_recommend_publish_item_detail_page_4` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(11) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(11) NOT NULL DEFAULT '',
  `desc` mediumtext NOT NULL,
  `backup_desc` mediumtext,
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
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
