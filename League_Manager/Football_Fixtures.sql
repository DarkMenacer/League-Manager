-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: Football_Fixtures
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `Fixtures`
--

DROP TABLE IF EXISTS `Fixtures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Fixtures` (
  `Match_ID` int NOT NULL,
  `Home_Team` varchar(20) DEFAULT NULL,
  `Away_Team` varchar(20) DEFAULT NULL,
  `Kick_Off` datetime DEFAULT NULL,
  PRIMARY KEY (`Match_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fixtures`
--

LOCK TABLES `Fixtures` WRITE;
/*!40000 ALTER TABLE `Fixtures` DISABLE KEYS */;
INSERT INTO `Fixtures` VALUES (1,'Barcelona','Paris $aint Germain','2021-07-24 00:00:00'),(2,'Real Madrid','Barcelona','2021-10-24 16:00:00'),(3,'Ajax','Real Madrid','2021-05-25 00:00:00'),(4,'Paris $aint Germain','Ajax','2021-08-16 20:15:00'),(5,'Bayern Munich','Arsenal','2021-05-16 21:05:00'),(6,'Liverpool','Chelsea','2021-12-05 00:30:00'),(7,'Barcelona','Liverpool','2021-01-17 20:35:00'),(10,'Chelsea','Bayern Munich','2021-06-14 17:35:00');
/*!40000 ALTER TABLE `Fixtures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Home_Ground_info`
--

DROP TABLE IF EXISTS `Home_Ground_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Home_Ground_info` (
  `Stadium_Name` varchar(30) NOT NULL DEFAULT 'TBD',
  `Capacity` int DEFAULT '0',
  `Team_ID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Home_Ground_info`
--

LOCK TABLES `Home_Ground_info` WRITE;
/*!40000 ALTER TABLE `Home_Ground_info` DISABLE KEYS */;
INSERT INTO `Home_Ground_info` VALUES ('Allianz Arena',73689,5),('Anfield',67000,6),('Bernabeu',70000,3),('Camp Nou',94000,1),('Emirates',60260,11),('Johan Cruff Arena',55500,2),('Parc des Princes',70000,4),('Stanford Bridge',40000,8);
/*!40000 ALTER TABLE `Home_Ground_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Points_Table`
--

DROP TABLE IF EXISTS `Points_Table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Points_Table` (
  `Team_ID` int NOT NULL,
  `Team_Name` varchar(20) DEFAULT NULL,
  `Matches_Played` int DEFAULT NULL,
  `Points` int DEFAULT NULL,
  PRIMARY KEY (`Team_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Points_Table`
--

LOCK TABLES `Points_Table` WRITE;
/*!40000 ALTER TABLE `Points_Table` DISABLE KEYS */;
INSERT INTO `Points_Table` VALUES (1,'Barcelona',10,30),(2,'Ajax',10,27),(3,'Real Madrid',10,3),(4,'Paris $aint Germain',10,0),(5,'Bayern Munich',10,24),(6,'Liverpool',10,12),(8,'Chelsea',10,21),(11,'Arsenal',10,6);
/*!40000 ALTER TABLE `Points_Table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-08 18:06:11
