SET MODE MYSQL;

CREATE schema IF NOT EXISTS `public`;

CREATE TABLE IF NOT EXISTS `public.SIMPLE_CALCULATION` (
  `ID` int NOT NULL,
  `LEFTHAND` int DEFAULT NULL,
  `OPERATOR` varchar(255) DEFAULT NULL,
  `RESULT` int DEFAULT NULL,
  `RIGHTHAND` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

truncate table `public.SIMPLE_CALCULATION`;

INSERT INTO `public.SIMPLE_CALCULATION`
(ID, LEFTHAND, OPERATOR, `RESULT`, RIGHTHAND)
VALUES(0, 1, 'ADD', 3, 2);


