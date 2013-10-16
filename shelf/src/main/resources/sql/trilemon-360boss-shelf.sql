# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-360boss-shelf
# Generation Time: 2013-10-16 09:13:03 +0000
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
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `is_new_item` tinyint(1) unsigned NOT NULL,
  `item_seller_cid` bigint(11) unsigned NOT NULL,
  `item_title` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `item_title_pinyin` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `item_pic_url` varchar(1024) NOT NULL DEFAULT '',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `plan_adjust_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `adjust_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;

INSERT INTO `plan` (`id`, `plan_setting_id`, `user_id`, `item_num_iid`, `is_new_item`, `item_seller_cid`, `item_title`, `item_title_pinyin`, `item_pic_url`, `status`, `plan_adjust_time`, `adjust_time`, `add_time`, `upd_time`)
VALUES
	(1,1,1,1,1,0,X'E8AFA0E6B8A1E889AFE59381E7A78BE8A385E58E9FE5889BE8BF90E58AA8E8A3A4E4BFAEE8BAABE58DABE8A3A4E4BC91E997B2E8A3A4E5B08FE8849AE99FA9E78988E794B7E5A3ABE6BDAEE58DABE8A3A43331313034',X'','http://gi1.md.alicdn.com/bao/uploaded/i1/11685028300661916/T1YAiPFcxXXXXXXXXX_!!0-item_pic.jpg',0,'2013-10-15 22:34:17','2013-10-15 22:34:17','2013-10-15 22:34:17','2013-10-15 22:35:12'),
	(2,1,1,2,1,0,X'E58BA4E88C8220E88BB9E69E9CE695B0E68DAEE58585E794B5E7BABF206970686F6E65E695B0E68DAEE7BABF203473E695B0E68DAEE7BABF2069706164E695B0',X'','http://gd2.alicdn.com/bao/uploaded/i2/12708025970370164/T1wWX6FileXXXXXXXX_!!0-item_pic.jpg_310x310.jpg_.webp',0,'2013-10-15 22:34:17','2013-10-15 22:34:17','0000-00-00 00:00:00','2013-10-15 22:36:24');

/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table plan_setting
# ------------------------------------------------------------

DROP TABLE IF EXISTS `plan_setting`;

CREATE TABLE `plan_setting` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `name` varchar(32) NOT NULL DEFAULT '',
  `name_pinyin` varchar(256) NOT NULL DEFAULT '',
  `include_cids` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `auto_add_new_items` tinyint(1) NOT NULL DEFAULT '0',
  `exclude_item_iids` varchar(1024) NOT NULL DEFAULT '',
  `distribution` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `distribution_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `before_adjust_distribution` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `next_plan_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `plan_setting` WRITE;
/*!40000 ALTER TABLE `plan_setting` DISABLE KEYS */;

INSERT INTO `plan_setting` (`id`, `user_id`, `name`, `name_pinyin`, `include_cids`, `auto_add_new_items`, `exclude_item_iids`, `distribution`, `distribution_type`, `before_adjust_distribution`, `status`, `next_plan_time`, `add_time`, `upd_time`)
VALUES
	(1,1,'我的第一个计划','wodiyigejihua',X'',0,'',X'317C393A30302D31303A30307C7C317C31303A30302D31323A3030',1,X'',0,'0000-00-00 00:00:00','0000-00-00 00:00:00','2013-10-15 22:38:55');

/*!40000 ALTER TABLE `plan_setting` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
