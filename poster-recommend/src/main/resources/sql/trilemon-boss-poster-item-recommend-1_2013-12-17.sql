# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-boss-poster-item-recommend-1
# Generation Time: 2013-12-16 16:11:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table poster_recommend_activity_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_1`;

CREATE TABLE `poster_recommend_activity_1` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `title` varchar(64) NOT NULL DEFAULT '',
  `color` char(7) NOT NULL DEFAULT '',
  `size` int(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `detail_page_position` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `publish_html` varchar(5120) NOT NULL DEFAULT '',
  `publish_type` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `publish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `publish_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `publish_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `poster_recommend_activity_1` WRITE;
/*!40000 ALTER TABLE `poster_recommend_activity_1` DISABLE KEYS */;

INSERT INTO `poster_recommend_activity_1` (`id`, `user_id`, `template_id`, `title`, `color`, `size`, `status`, `detail_page_position`, `publish_html`, `publish_type`, `publish_time`, `publish_start_time`, `publish_end_time`, `add_time`, `upd_time`)
VALUES
	(3,56912708,100,'测试活动设计部分','12344',790,1,4,'<a>test</a>',1,'0000-00-00 00:00:00','2013-09-07 23:59:59','2013-12-06 23:59:59','2013-12-16 22:18:18','2013-12-16 22:23:19');

/*!40000 ALTER TABLE `poster_recommend_activity_1` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table poster_recommend_activity_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_2`;

CREATE TABLE `poster_recommend_activity_2` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `title` varchar(64) NOT NULL DEFAULT '',
  `color` char(7) NOT NULL DEFAULT '',
  `size` int(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `detail_page_position` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `publish_html` varchar(5120) NOT NULL DEFAULT '',
  `publish_type` tinyint(4) unsigned NOT NULL DEFAULT '0',
  `publish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `publish_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `publish_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_activity_item_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_item_1`;

CREATE TABLE `poster_recommend_activity_item_1` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(128) NOT NULL DEFAULT '',
  `template_sequence_index` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `poster_recommend_activity_item_1` WRITE;
/*!40000 ALTER TABLE `poster_recommend_activity_item_1` DISABLE KEYS */;

INSERT INTO `poster_recommend_activity_item_1` (`id`, `user_id`, `activity_id`, `template_id`, `item_num_iid`, `item_title`, `item_price`, `item_pic_url`, `template_sequence_index`, `status`, `add_time`, `upd_time`)
VALUES
	(2,56912708,3,0,123456,'test title',10.00,'pic_url',0,0,'2013-12-16 22:41:42','2013-12-16 22:45:42'),
	(3,56912708,3,0,123456,'test title',10.00,'pic_url',0,0,'2013-12-16 22:44:38','2013-12-16 22:44:38'),
	(4,56912708,3,0,123456,'test title',10.00,'pic_url',0,0,'2013-12-16 22:44:39','2013-12-16 22:44:39'),
	(5,56912708,3,0,123456,'test title',10.00,'pic_url',0,0,'2013-12-16 22:44:41','2013-12-16 22:44:41'),
	(6,56912708,3,0,123456,'test title',10.00,'pic_url',0,0,'2013-12-16 22:44:41','2013-12-16 22:44:41');

/*!40000 ALTER TABLE `poster_recommend_activity_item_1` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table poster_recommend_activity_item_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_activity_item_2`;

CREATE TABLE `poster_recommend_activity_item_2` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `activity_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_title` varchar(64) NOT NULL DEFAULT '',
  `item_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `item_pic_url` varchar(128) NOT NULL DEFAULT '',
  `template_sequence_index` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_publish_item_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_1`;

CREATE TABLE `poster_recommend_publish_item_1` (
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

LOCK TABLES `poster_recommend_publish_item_1` WRITE;
/*!40000 ALTER TABLE `poster_recommend_publish_item_1` DISABLE KEYS */;

INSERT INTO `poster_recommend_publish_item_1` (`id`, `user_id`, `activity_id`, `item_num_iid`, `item_title`, `item_price`, `item_pic_url`, `detail_page_position`, `status`, `publish_time`, `add_time`, `upd_time`)
VALUES
	(1,56912708,3,0,'test title',10.00,'pic_url',0,0,'2013-12-16 23:07:07','2013-12-16 23:07:07','2013-12-16 23:07:08'),
	(2,56912708,3,0,'test title',10.00,'pic_url',0,0,'2013-12-16 23:07:27','2013-12-16 23:07:27','2013-12-16 23:07:27'),
	(3,56912708,3,0,'test title',10.00,'pic_url',0,0,'2013-12-16 23:07:29','2013-12-16 23:07:29','2013-12-16 23:07:29'),
	(4,56912708,3,0,'test title',10.00,'pic_url',0,0,'2013-12-16 23:07:30','2013-12-16 23:07:30','2013-12-16 23:07:30');

/*!40000 ALTER TABLE `poster_recommend_publish_item_1` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table poster_recommend_publish_item_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_2`;

CREATE TABLE `poster_recommend_publish_item_2` (
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



# Dump of table poster_recommend_publish_item_detail_page_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_detail_page_1`;

CREATE TABLE `poster_recommend_publish_item_detail_page_1` (
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



# Dump of table poster_recommend_publish_item_detail_page_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_publish_item_detail_page_2`;

CREATE TABLE `poster_recommend_publish_item_detail_page_2` (
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



# Dump of table poster_recommend_recommend_template
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_recommend_template`;

CREATE TABLE `poster_recommend_recommend_template` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL DEFAULT '',
  `recommend_type` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `template_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `recommend_start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `recommend_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `poster_recommend_recommend_template` WRITE;
/*!40000 ALTER TABLE `poster_recommend_recommend_template` DISABLE KEYS */;

INSERT INTO `poster_recommend_recommend_template` (`id`, `title`, `recommend_type`, `template_id`, `recommend_start_time`, `recommend_end_time`, `status`, `add_time`, `upd_time`)
VALUES
	(1,'测试推荐模板',1,100,'2013-01-01 00:00:00','2014-01-01 00:00:00',0,'0000-00-00 00:00:00','2013-12-16 23:35:42');

/*!40000 ALTER TABLE `poster_recommend_recommend_template` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table poster_recommend_user_1
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_user_1`;

CREATE TABLE `poster_recommend_user_1` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_recommend_user_2
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_recommend_user_2`;

CREATE TABLE `poster_recommend_user_2` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
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
