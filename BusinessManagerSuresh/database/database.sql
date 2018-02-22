-- MySQL dump 10.13  Distrib 5.5.34, for Win32 (x86)
--
-- Host: localhost    Database: suresh_shop
-- ------------------------------------------------------
-- Server version	5.5.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `ACCOUNT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_NAME` varchar(60) NOT NULL,
  `ADDRESS` varchar(100) NOT NULL,
  `ACCOUNT_TYPE` int(11) NOT NULL,
  `MOBILE_NO` varchar(15) NOT NULL,
  `REMARKS` varchar(60) NOT NULL,
  `IS_DELETED` tinyint(1) NOT NULL,
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categeory`
--

DROP TABLE IF EXISTS `categeory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categeory` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(45) NOT NULL,
  `REMARKS` varchar(45) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categeory`
--

LOCK TABLES `categeory` WRITE;
/*!40000 ALTER TABLE `categeory` DISABLE KEYS */;
INSERT INTO `categeory` VALUES (1,'HARD','');
/*!40000 ALTER TABLE `categeory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheque`
--

DROP TABLE IF EXISTS `cheque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheque` (
  `CHEQUE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_ID` int(11) NOT NULL,
  `SALE_PURCHASE_ID` int(11) NOT NULL,
  `CHEQUE_NUMBER` varchar(45) NOT NULL,
  `CHEQUE_DATE` date NOT NULL,
  `GIVEN_DATE` date NOT NULL,
  PRIMARY KEY (`CHEQUE_ID`),
  KEY `fk_cheque_account1_idx` (`ACCOUNT_ID`),
  KEY `fk_cheque_sale_purchase1_idx` (`SALE_PURCHASE_ID`),
  CONSTRAINT `fk_cheque_account1` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `account` (`ACCOUNT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cheque_sale_purchase1` FOREIGN KEY (`SALE_PURCHASE_ID`) REFERENCES `sale_purchase` (`SALE_PURCHASE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque`
--

LOCK TABLES `cheque` WRITE;
/*!40000 ALTER TABLE `cheque` DISABLE KEYS */;
/*!40000 ALTER TABLE `cheque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day`
--

DROP TABLE IF EXISTS `day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day` (
  `DAY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `YEAR_ID` int(11) NOT NULL,
  `DAY` date NOT NULL,
  `REMARKS` varchar(60) NOT NULL,
  PRIMARY KEY (`DAY_ID`),
  UNIQUE KEY `DAY_UNIQUE` (`DAY`),
  KEY `fk_day_year1_idx` (`YEAR_ID`),
  CONSTRAINT `fk_day_year1` FOREIGN KEY (`YEAR_ID`) REFERENCES `year` (`YEAR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day`
--

LOCK TABLES `day` WRITE;
/*!40000 ALTER TABLE `day` DISABLE KEYS */;
/*!40000 ALTER TABLE `day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurement_unit`
--

DROP TABLE IF EXISTS `measurement_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `measurement_unit` (
  `UNIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `UNIT_NAME` varchar(100) NOT NULL,
  `REMARKS` varchar(100) NOT NULL,
  PRIMARY KEY (`UNIT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement_unit`
--

LOCK TABLES `measurement_unit` WRITE;
/*!40000 ALTER TABLE `measurement_unit` DISABLE KEYS */;
INSERT INTO `measurement_unit` VALUES (6,'FEET',''),(7,'SHEET','');
/*!40000 ALTER TABLE `measurement_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` int(11) NOT NULL,
  `PRODUCT_NAME` varchar(100) NOT NULL,
  `RATE` double NOT NULL,
  `CURRENT_RATE` double NOT NULL,
  `ORIGINAL_RATE` double NOT NULL,
  `UNIT_ID` int(11) NOT NULL,
  `QUANTITY` double NOT NULL,
  `REMARKS` varchar(100) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `fk_product_measurement_unit1_idx` (`UNIT_ID`),
  KEY `fk_product_categeory1_idx` (`CATEGORY_ID`),
  CONSTRAINT `fk_product_measurement_unit1` FOREIGN KEY (`UNIT_ID`) REFERENCES `measurement_unit` (`UNIT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_categeory1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `categeory` (`CATEGORY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_purchase`
--

DROP TABLE IF EXISTS `sale_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_purchase` (
  `DAY_ID` int(11) NOT NULL,
  `ACCOUNT_ID` int(11) NOT NULL,
  `SALE_PURCHASE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TOTAL_AMOUNT` double NOT NULL,
  `TYPE` int(11) NOT NULL,
  `REMARKS` varchar(100) NOT NULL,
  `PAID_AMOUNT` double NOT NULL,
  PRIMARY KEY (`SALE_PURCHASE_ID`),
  KEY `fk_sale_purchase_account1_idx` (`ACCOUNT_ID`),
  KEY `fk_sale_purchase_day1_idx` (`DAY_ID`),
  CONSTRAINT `fk_sale_purchase_account1` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `account` (`ACCOUNT_ID`),
  CONSTRAINT `fk_sale_purchase_day1` FOREIGN KEY (`DAY_ID`) REFERENCES `day` (`DAY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_purchase`
--

LOCK TABLES `sale_purchase` WRITE;
/*!40000 ALTER TABLE `sale_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `DAY_ID` int(11) NOT NULL,
  `ACCOUNT_ID` int(11) NOT NULL,
  `SALE_PURCHASE_ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `TRANSACTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUANTITY` double NOT NULL,
  `AMOUNT` double NOT NULL,
  `TYPE` int(11) NOT NULL,
  `PRODUCT_ORIGINAL_RATE` double DEFAULT NULL,
  PRIMARY KEY (`TRANSACTION_ID`),
  KEY `fk_transaction_account1_idx` (`ACCOUNT_ID`),
  KEY `fk_transaction_sale_purchase1_idx` (`SALE_PURCHASE_ID`),
  KEY `fk_transaction_day1_idx` (`DAY_ID`),
  KEY `fk_transaction_product1_idx` (`PRODUCT_ID`),
  CONSTRAINT `fk_transaction_account1` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `account` (`ACCOUNT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_sale_purchase1` FOREIGN KEY (`SALE_PURCHASE_ID`) REFERENCES `sale_purchase` (`SALE_PURCHASE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_product1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_day1` FOREIGN KEY (`DAY_ID`) REFERENCES `day` (`DAY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `year`
--

DROP TABLE IF EXISTS `year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `year` (
  `YEAR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `YEAR` int(11) NOT NULL,
  `REMARKS` varchar(60) NOT NULL,
  PRIMARY KEY (`YEAR_ID`),
  UNIQUE KEY `YEAR_UNIQUE` (`YEAR`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `year`
--

LOCK TABLES `year` WRITE;
/*!40000 ALTER TABLE `year` DISABLE KEYS */;
/*!40000 ALTER TABLE `year` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-24 10:32:45
