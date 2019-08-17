CREATE DATABASE  IF NOT EXISTS `employee_database`;
USE `employee_database`; # The USE keyword is used to select a database in MySQL and SQL Server

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Roninho','Lindinho','roninho@gmail.com'),
	(2,'Duzinho','Bonitinho','duzinho@gmail.com'),
	(3,'Jacskon','Brods','jacskon@gmail.com'),
	(4,'Yancnkvok','Petrov','yancnkvok@gmail.com'),
	(5,'Guzinho','Feinho','guzinho@gmail.com');

