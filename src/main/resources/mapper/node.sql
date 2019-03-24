CREATE TABLE `node` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `parent_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='节点表'

INSERT INTO node (name, parent_id) VALUES ('一级节点A', 0);
INSERT INTO node (name, parent_id) VALUES ('一级节点B', 0);
INSERT INTO node (name, parent_id) VALUES ('一级节点C', 0);
INSERT INTO node (name, parent_id) VALUES ('二级节点AA', 1);
INSERT INTO node (name, parent_id) VALUES ('二级节点aa', 1);
INSERT INTO node (name, parent_id) VALUES ('二级节点BB', 2);
INSERT INTO node (name, parent_id) VALUES ('三级级节点AAA', 4);
INSERT INTO node (name, parent_id) VALUES ('三级级节点aaa', 4);
INSERT INTO node (name, parent_id) VALUES ('三级级节点BBB', 6);