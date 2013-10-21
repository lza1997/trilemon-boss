/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50527
 Source Host           : localhost
 Source Database       : trilemon-360boss-shelf

 Target Server Version : 50527
 File Encoding         : utf-8

 Date: 10/21/2013 20:26:28 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `plan_setting_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `user_id` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_num_iid` bigint(11) unsigned NOT NULL DEFAULT '0',
  `item_seller_cid` bigint(11) unsigned NOT NULL,
  `item_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `item_title_pinyin` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `item_pic_url` varchar(1024) NOT NULL DEFAULT '',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `failed_cause` varchar(11) NOT NULL DEFAULT '',
  `plan_adjust_day` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `plan_adjust_start_time` time NOT NULL DEFAULT '00:00:00',
  `plan_adjust_end_time` time NOT NULL DEFAULT '00:00:00',
  `adjust_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `plan_setting`
-- ----------------------------
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
  `last_plan_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `add_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `upd_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
