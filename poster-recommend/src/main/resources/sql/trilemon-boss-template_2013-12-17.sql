# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.27)
# Database: trilemon-boss-template
# Generation Time: 2013-12-16 16:11:34 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table poster_template
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_template`;

CREATE TABLE `poster_template` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `preview_type` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `preview_pic_url` varchar(1024) NOT NULL DEFAULT '',
  `preview_pic_html` text NOT NULL,
  `template_ftl` text NOT NULL,
  `slot_num` int(11) unsigned NOT NULL DEFAULT '0',
  `sizes` varchar(128) NOT NULL DEFAULT '',
  `colors` varchar(128) NOT NULL DEFAULT '',
  `copy_keys` varchar(1024) NOT NULL DEFAULT '',
  `categories` varchar(128) NOT NULL DEFAULT '',
  `topics` varchar(128) NOT NULL DEFAULT '',
  `festivals` varchar(128) NOT NULL DEFAULT '',
  `type` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `use_num` int(11) unsigned NOT NULL DEFAULT '0',
  `favorite_num` int(11) unsigned NOT NULL DEFAULT '0',
  `like_num` int(11) unsigned NOT NULL DEFAULT '0',
  `apply_version` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `status` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `poster_template` WRITE;
/*!40000 ALTER TABLE `poster_template` DISABLE KEYS */;

INSERT INTO `poster_template` (`id`, `preview_type`, `preview_pic_url`, `preview_pic_html`, `template_ftl`, `slot_num`, `sizes`, `colors`, `copy_keys`, `categories`, `topics`, `festivals`, `type`, `use_num`, `favorite_num`, `like_num`, `apply_version`, `status`, `add_time`, `upd_time`)
VALUES
	(100,1,'','<table width=\"750\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n    <tbody>\n    <tr>\n        <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"2\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img01.taobaocdn.com/imgextra/i1/73328087/T20As7XnpaXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"></a>\n            </td>\n         </tr>\n          <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>\n        <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"3\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img04.taobaocdn.com/imgextra/i4/73328087/T2KrxlXCRXXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"> </a>\n            </td>\n         </tr>\n          <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>\n          <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"3\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img02.taobaocdn.com/imgextra/i2/73328087/T2mGwVXlVaXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"> </a>\n            </td>\n         </tr>\n         <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>\n         <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"3\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img04.taobaocdn.com/imgextra/i4/73328087/T2KrxlXCRXXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"> </a>\n            </td>\n         </tr>\n          <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>\n         \n    </tr>\n      <tr>\n        <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"3\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img01.taobaocdn.com/imgextra/i1/73328087/T20As7XnpaXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"> </a>\n            </td>\n         </tr>\n          <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>\n        <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"3\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img02.taobaocdn.com/imgextra/i2/73328087/T2mGwVXlVaXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"> </a>\n            </td>\n         </tr>\n          <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>\n          <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"3\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img01.taobaocdn.com/imgextra/i1/73328087/T20As7XnpaXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"> </a>\n            </td>\n         </tr>\n          <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>\n         <td width=\"180\" style=\"padding-right:2px;\">\n        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\" background-color:#A41413; width:180px;margin-bottom:10px;\">\n         <tbody><tr>\n            <td colspan=\"3\" valign=\"center\" height=\"220\" bgcolor=\"#f2f2f2\" background=\"http://img01.taobaocdn.com/imgextra/i1/73328087/T20As7XnpaXXXXXXXX_!!73328087.jpg\" align=\"center\" style=\"background-repeat:no-repeat;background-position:50% 50%;\">\n            <a style=\"display:block;width:180px; height:220px;\" target=\"_blank\" href=\"#2\"> </a>\n            </td>\n         </tr>\n         <tr>\n               <td align=\"left\" width=\"60%\">\n                <span style=\"font-size:18px; height:35px; line-height:35px; color:#F9FEF8; font-weight:bold;float:left; padding-left:3px; text-align:center;\">129.00</span>\n                </td>\n                <td width=\"40%\" background=\"http://cdn.huanleguang.com/img/list/7315778/btns.png\" align=\"right\" style=\"height:35px; line-height:35px; background-repeat:no-repeat; background-position:right top;margin-right:5px;\">\n                <a target=\"_blank\" title=\"#title#\" href=\"#2\" style=\"display:block;width:72px; height:35px;font-size:18px; font-family:\'黑体\';color:#fff; text-decoration:none; text-align:left;\"></a></td>\n            </tr>\n          </tbody></table>\n         </td>   \n    </tr>\n    </tbody>\n    </table>\n  ','',0,'','','','2','1','',0,0,0,0,0,0,'0000-00-00 00:00:00','2013-12-09 17:05:32');

/*!40000 ALTER TABLE `poster_template` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table poster_template_category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_template_category`;

CREATE TABLE `poster_template_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_template_festival
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_template_festival`;

CREATE TABLE `poster_template_festival` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL DEFAULT '',
  `calendar` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `festival_time_type` tinyint(11) unsigned NOT NULL DEFAULT '0',
  `festival_fix_time` date NOT NULL DEFAULT '0000-00-00',
  `festival_dynamic_time` varchar(32) NOT NULL DEFAULT '',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table poster_template_topic
# ------------------------------------------------------------

DROP TABLE IF EXISTS `poster_template_topic`;

CREATE TABLE `poster_template_topic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` int(11) NOT NULL,
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
