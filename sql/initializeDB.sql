-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: dbs_climate_action
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aqi`
--

use database climate_change;
DROP TABLE IF EXISTS `aqi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aqi` (
  `aqi_id` varchar(3) NOT NULL,
  `measuring_year` int NOT NULL,
  `aqi_metric` int unsigned NOT NULL,
  `reporting_city` varchar(20) NOT NULL,
  `reporting_date` date NOT NULL,
  PRIMARY KEY (`aqi_id`,`measuring_year`,`reporting_city`),
  UNIQUE KEY `aqi_id` (`aqi_id`),
  CONSTRAINT `aqi_ibfk_1` FOREIGN KEY (`aqi_id`) REFERENCES `state` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aqi`
--

LOCK TABLES `aqi` WRITE;
/*!40000 ALTER TABLE `aqi` DISABLE KEYS */;
INSERT INTO `aqi` VALUES ('AZ',2020,53,'Tuscon','2020-11-21'),('FL',2019,43,'Jacksonville','2019-03-15'),('IL',2020,41,'Bloomington','2020-08-15'),('NV',2018,48,'Reno','2018-06-29'),('NY',2018,54,'NewYork','2018-05-10');
/*!40000 ALTER TABLE `aqi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carbon_dioxide`
--

DROP TABLE IF EXISTS `carbon_dioxide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carbon_dioxide` (
  `co_id` varchar(3) NOT NULL,
  `emission_year` int NOT NULL,
  `co_metric` decimal(6,2) NOT NULL,
  PRIMARY KEY (`co_id`,`emission_year`),
  UNIQUE KEY `co_id` (`co_id`),
  CONSTRAINT `carbon_dioxide_ibfk_1` FOREIGN KEY (`co_id`) REFERENCES `state` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carbon_dioxide`
--

LOCK TABLES `carbon_dioxide` WRITE;
/*!40000 ALTER TABLE `carbon_dioxide` DISABLE KEYS */;
INSERT INTO `carbon_dioxide` VALUES ('AZ',2017,85.60),('FL',2017,226.60),('IL',2017,201.10),('NV',2017,36.20),('NY',2017,156.70);
/*!40000 ALTER TABLE `carbon_dioxide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deforestation`
--

DROP TABLE IF EXISTS `deforestation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deforestation` (
  `def_id` varchar(3) NOT NULL,
  `year` int NOT NULL,
  `def_metric` decimal(10,2) NOT NULL,
  PRIMARY KEY (`def_id`,`year`),
  UNIQUE KEY `def_id` (`def_id`),
  CONSTRAINT `deforestation_ibfk_1` FOREIGN KEY (`def_id`) REFERENCES `state` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deforestation`
--

LOCK TABLES `deforestation` WRITE;
/*!40000 ALTER TABLE `deforestation` DISABLE KEYS */;
INSERT INTO `deforestation` VALUES ('AZ',2020,18744.44),('FL',2020,0.24),('IL',2020,382.14),('NV',2020,272.79),('NY',2020,3310.15);
/*!40000 ALTER TABLE `deforestation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
INSERT INTO `entity1` VALUES ('draghu3','12345','draghu3@uic.edu'),('jega2','54321','jega2@uic.edu'),('onurag1','qwerty','onurag1@uic.edu'),('sayush2','abcde','sayush@uic.edu');
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `natural_disaster`
--

DROP TABLE IF EXISTS `natural_disaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `natural_disaster` (
  `n_id` int NOT NULL,
  `disaster_name` varchar(20) NOT NULL,
  `occurence_date` date NOT NULL,
  `damage_cost` decimal(8,3) NOT NULL,
  PRIMARY KEY (`n_id`),
  UNIQUE KEY `n_id` (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `natural_disaster`
--

LOCK TABLES `natural_disaster` WRITE;
/*!40000 ALTER TABLE `natural_disaster` DISABLE KEYS */;
INSERT INTO `natural_disaster` VALUES (1,'tornado','2021-12-10',3.900),(2,'earthquake','2019-07-04',5.300),(3,'hurricane','2021-06-30',65.250),(4,'hurricane','2019-08-24',5.100),(5,'wildfire','2018-11-08',26.340);
/*!40000 ALTER TABLE `natural_disaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `population`
--

DROP TABLE IF EXISTS `population`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `population` (
  `p_id` varchar(3) NOT NULL,
  `recorded_year` int NOT NULL,
  `p_value` int unsigned NOT NULL,
  PRIMARY KEY (`p_id`,`recorded_year`),
  UNIQUE KEY `p_id` (`p_id`),
  CONSTRAINT `population_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `state` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `population`
--

LOCK TABLES `population` WRITE;
/*!40000 ALTER TABLE `population` DISABLE KEYS */;
INSERT INTO `population` VALUES ('AZ',2017,3003855),('FL',2017,20977089),('IL',2020,12667017),('NV',2020,3138259),('NY',2021,19835913);
/*!40000 ALTER TABLE `population` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `code` varchar(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `area` int unsigned NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES ('AZ','Arizona',113998),('FL','Florida',65758),('IL','Illinois',57915),('NV','Nevada',110567),('NY','New York',54556);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_natural_disaster`
--

DROP TABLE IF EXISTS `state_natural_disaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state_natural_disaster` (
  `code` varchar(3) NOT NULL,
  `n_id` int NOT NULL,
  PRIMARY KEY (`code`,`n_id`),
  UNIQUE KEY `code` (`code`),
  KEY `n_id` (`n_id`),
  CONSTRAINT `state_natural_disaster_ibfk_1` FOREIGN KEY (`code`) REFERENCES `state` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `state_natural_disaster_ibfk_2` FOREIGN KEY (`n_id`) REFERENCES `natural_disaster` (`n_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_natural_disaster`
--

LOCK TABLES `state_natural_disaster` WRITE;
/*!40000 ALTER TABLE `state_natural_disaster` DISABLE KEYS */;
INSERT INTO `state_natural_disaster` VALUES ('IL',1),('AZ',2),('NV',2),('NY',3),('FL',4);
/*!40000 ALTER TABLE `state_natural_disaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('draghu3','12345','draghu3@uic.edu'),('jega2','54321','jega2@uic.edu'),('onurag1','qwerty','onurag1@uic.edu'),('sayush2','abcde','sayush@uic.edu');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-31 21:22:10
