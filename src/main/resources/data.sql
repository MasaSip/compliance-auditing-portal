-- This file inserts some test data into the database

INSERT INTO `report` (`end_time`, `name`, `start_time`)
VALUES (NULL, 'Test report 1', now());

INSERT INTO `non_compliance` (`comment`, `media_link`, `question`, `report_id`)
VALUES ('Comment 1 for report 1', NULL, 'What is your comment 1?', '1');
INSERT INTO `non_compliance` (`comment`, `media_link`, `question`, `report_id`)
VALUES ('Comment 2 for report 1', NULL, 'What is your comment 2?', '1');


INSERT INTO `report` (`end_time`, `name`, `start_time`)
VALUES (NULL, 'Test report 2', now());

INSERT INTO `non_compliance` (`comment`, `media_link`, `question`, `report_id`)
VALUES ('Comment 1 for report 2', NULL, 'What is your comment 1?', '2');
INSERT INTO `non_compliance` (`comment`, `media_link`, `question`, `report_id`)
VALUES ('Comment 2 for report 2', NULL, 'What is your comment 2?', '2');