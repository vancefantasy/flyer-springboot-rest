SET FOREIGN_KEY_CHECKS = 0;
SET NAMES utf8;

DROP DATABASE IF EXISTS flyer_ut;
CREATE DATABASE flyer_ut
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE flyer_ut;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id`           BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `add_time`     DATETIME            NOT NULL DEFAULT '1970-01-01 00:00:00'
  COMMENT '新增时间',
  `open_id`      VARCHAR(64)         NOT NULL DEFAULT '',
  `union_id`     VARCHAR(11)         NOT NULL DEFAULT '',
  `cellphone`    VARCHAR(64)         NOT NULL DEFAULT '',
  `wechat`       VARCHAR(256)        NOT NULL DEFAULT '',
  `nick_name`    VARCHAR(64)         NOT NULL DEFAULT '',
  `country`      VARCHAR(64)         NOT NULL DEFAULT '',
  `language`     VARCHAR(64)         NOT NULL DEFAULT '',
  `province`     VARCHAR(64)         NOT NULL DEFAULT '',
  `city`         VARCHAR(64)         NOT NULL DEFAULT '',
  `sex`          INT(11)             NOT NULL,
  `head_img_url` VARCHAR(50)         NOT NULL DEFAULT '',
  `remark`       VARCHAR(64)         NOT NULL DEFAULT '',
  `_timestamp`   TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '用户表';

CREATE USER flyer_w
  IDENTIFIED BY '123456';

GRANT ALL PRIVILEGES ON flyer_ut.* TO flyer_w;
FLUSH PRIVILEGES;
