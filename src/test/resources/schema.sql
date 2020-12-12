drop TABLE IF EXISTS `simple_calculator_database.SIMPLE_CALCULATION`;
drop schema if exists `simple_calculator_database`;

CREATE schema IF NOT EXISTS `simple_calculator_database`;

CREATE TABLE IF NOT EXISTS `simple_calculator_database.SIMPLE_CALCULATION` (
  `ID` int NOT NULL,
  `EXPRESSION` varchar(255) DEFAULT NULL,
  `RESULT` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
);