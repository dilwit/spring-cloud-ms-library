-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for library-inventory
CREATE DATABASE IF NOT EXISTS `library-inventory` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library-inventory`;

-- Dumping structure for table library-inventory.book
CREATE TABLE IF NOT EXISTS `book` (
  `ISBN` varchar(50) NOT NULL DEFAULT '',
  `NAME` varchar(50) NOT NULL DEFAULT '',
  `AUTHOR` varchar(50) NOT NULL DEFAULT '',
  `TOTAL` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table library-inventory.book: ~0 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
