-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for sampleticketsystem
CREATE DATABASE IF NOT EXISTS `sampleticketsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sampleticketsystem`;


-- Dumping structure for table sampleticketsystem.department
CREATE TABLE IF NOT EXISTS `department` (
  `departmentId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sampleticketsystem.department: ~2 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`departmentId`, `departmentName`) VALUES
	(1, 'sample'),
	(2, 'hr');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


-- Dumping structure for table sampleticketsystem.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `employeeId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(20) NOT NULL DEFAULT '',
  `managerEmployeeId` int(11) unsigned DEFAULT NULL,
  `departmentId` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `FK_employee_department` (`departmentId`),
  CONSTRAINT `FK_employee_department` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sampleticketsystem.employee: ~2 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`employeeId`, `employeeName`, `managerEmployeeId`, `departmentId`) VALUES
	(1, 'Arun', 0, 1),
	(2, 'Ashish', 0, 2);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- Dumping structure for table sampleticketsystem.person
CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table sampleticketsystem.person: ~4 rows (approximately)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `name`, `country`) VALUES
	(1, 'arun', 'Indiaad'),
	(3, 'yout', 'adsfads'),
	(4, 'Suman', 'wife'),
	(5, 'asdf', 'adf dfa');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


-- Dumping structure for table sampleticketsystem.ticket
CREATE TABLE IF NOT EXISTS `ticket` (
  `ticketId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `summary` varchar(200) NOT NULL DEFAULT '',
  `description` varchar(500) NOT NULL DEFAULT '',
  `type` int(11) unsigned DEFAULT '0',
  `createdBy` int(11) unsigned NOT NULL,
  `creationTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `assignedTo` int(11) unsigned DEFAULT NULL,
  `assignmentTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `closeBy` int(11) unsigned DEFAULT NULL,
  `closingTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ticketId`),
  KEY `FK_ticket_employee` (`createdBy`),
  CONSTRAINT `FK_ticket_employee` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`employeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sampleticketsystem.ticket: ~0 rows (approximately)
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
