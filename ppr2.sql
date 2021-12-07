-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: patrickspartyrental
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CUSTOMER_ID` int NOT NULL,
  `CUSTOMER_FNAME` varchar(45) NOT NULL,
  `CUSTOMER_LNAME` varchar(45) NOT NULL,
  `CUSTOMER_PHONE` varchar(10) NOT NULL,
  `CUSTOMER_EMAIL` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`),
  UNIQUE KEY `CUSTOMER_ID` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (20211,'Jane','Doe','5865550123','janedoe@gmail.com'),(20212,'John','Doe','5865550321','johndoe@gmail.com'),(20213,'Don','Joe','5865552212','donathonjoseph@gmail.com'),(20214,'James','Atkinson','5865550321','johndoe@gmail.com'),(20215,'Jack','Joyce','8105551821','johndoe@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `Employee_ID` int NOT NULL,
  `Employee_FName` varchar(45) NOT NULL,
  `Employee_LName` varchar(45) DEFAULT NULL,
  `Employee_Phone` varchar(10) NOT NULL,
  PRIMARY KEY (`Employee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Patrick','Packan','2125552309'),(2,'Anthony','Kost','3134873982'),(3,'Trent','Toyryla','5865552543'),(4,'Dom','Sarpac','2125553432');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `party`
--

DROP TABLE IF EXISTS `party`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `party` (
  `Party_ID` int NOT NULL,
  `Customer_ID` int NOT NULL,
  `Location` varchar(100) NOT NULL,
  `Setup_Date` date DEFAULT NULL,
  `Takedown_Date` date DEFAULT NULL,
  `Cost` decimal(8,2) DEFAULT NULL,
  `Tables` int DEFAULT NULL,
  `Chairs` int DEFAULT NULL,
  PRIMARY KEY (`Party_ID`),
  KEY `Customer_ID` (`Customer_ID`),
  CONSTRAINT `party_ibfk_1` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `party`
--

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES (102,20211,'555 Avenue Drive, Rochester, MI 48309','2022-06-10','2022-06-12',950.00,6,48),(103,20212,'566  Oakland Ct., Rochester, MI 48309','2022-06-10','2022-06-12',540.00,8,64),(104,20213,'112  Chapman Blvd., Washington, MI 48065','2022-06-10','2022-06-12',950.00,6,48),(105,20214,'121  Anchor Point, Washington, MI 48065','2022-06-10','2022-06-12',540.00,8,48),(106,20215,'1882  Jameson Ct., Macomb, MI 48042','2022-06-10','2022-06-12',1080.00,10,80);
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheduling`
--

DROP TABLE IF EXISTS `scheduling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scheduling` (
  `Employee_ID` int NOT NULL,
  `Work_Day_Date` date NOT NULL,
  PRIMARY KEY (`Employee_ID`,`Work_Day_Date`),
  KEY `Work_Day_Date` (`Work_Day_Date`),
  CONSTRAINT `scheduling_ibfk_1` FOREIGN KEY (`Employee_ID`) REFERENCES `employee` (`Employee_ID`),
  CONSTRAINT `scheduling_ibfk_2` FOREIGN KEY (`Work_Day_Date`) REFERENCES `workday` (`Work_Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduling`
--

LOCK TABLES `scheduling` WRITE;
/*!40000 ALTER TABLE `scheduling` DISABLE KEYS */;
INSERT INTO `scheduling` VALUES (1,'2022-06-10'),(2,'2022-06-10'),(4,'2022-06-10'),(2,'2022-06-12'),(3,'2022-06-12'),(4,'2022-06-12');
/*!40000 ALTER TABLE `scheduling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tent`
--

DROP TABLE IF EXISTS `tent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tent` (
  `Tent_ID` int NOT NULL,
  `Size` varchar(20) NOT NULL,
  `Num_Stakes` int NOT NULL,
  `Num_Poles` int NOT NULL,
  `Square_Footage` int DEFAULT NULL,
  PRIMARY KEY (`Tent_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tent`
--

LOCK TABLES `tent` WRITE;
/*!40000 ALTER TABLE `tent` DISABLE KEYS */;
INSERT INTO `tent` VALUES (20111,'20X40',16,12,800),(20196,'20X20',12,8,400),(20201,'20X40',16,12,800),(20324,'20X40',16,12,800),(20422,'20X30',14,10,600),(20565,'20X40',16,12,800),(20616,'20X40',16,12,800),(20835,'20X20',12,8,400);
/*!40000 ALTER TABLE `tent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tent_rental`
--

DROP TABLE IF EXISTS `tent_rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tent_rental` (
  `TENT_ID` int NOT NULL,
  `PARTY_ID` int NOT NULL,
  KEY `PARTY_ID` (`PARTY_ID`),
  CONSTRAINT `tent_rental_ibfk_1` FOREIGN KEY (`PARTY_ID`) REFERENCES `party` (`Party_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tent_rental`
--

LOCK TABLES `tent_rental` WRITE;
/*!40000 ALTER TABLE `tent_rental` DISABLE KEYS */;
INSERT INTO `tent_rental` VALUES (20111,102),(20201,102),(20616,103),(20835,104),(20422,104),(20324,105),(20196,106);
/*!40000 ALTER TABLE `tent_rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workday`
--

DROP TABLE IF EXISTS `workday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workday` (
  `Work_Date` date NOT NULL,
  `Start_Time` varchar(45) DEFAULT NULL,
  `End_Time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Work_Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workday`
--

LOCK TABLES `workday` WRITE;
/*!40000 ALTER TABLE `workday` DISABLE KEYS */;
INSERT INTO `workday` VALUES ('2022-06-10','8:00AM','3:00PM'),('2022-06-12','8:00AM','3:00PM');
/*!40000 ALTER TABLE `workday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workorder`
--

DROP TABLE IF EXISTS `workorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workorder` (
  `Work_Date` date NOT NULL,
  `Party_ID` int NOT NULL,
  `Setup` tinyint NOT NULL,
  `Takedown` tinyint NOT NULL,
  `Order_Number` int DEFAULT NULL,
  PRIMARY KEY (`Work_Date`,`Party_ID`,`Setup`,`Takedown`),
  KEY `Party_ID` (`Party_ID`),
  CONSTRAINT `workorder_ibfk_1` FOREIGN KEY (`Work_Date`) REFERENCES `workday` (`Work_Date`),
  CONSTRAINT `workorder_ibfk_2` FOREIGN KEY (`Party_ID`) REFERENCES `party` (`Party_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workorder`
--

LOCK TABLES `workorder` WRITE;
/*!40000 ALTER TABLE `workorder` DISABLE KEYS */;
INSERT INTO `workorder` VALUES ('2022-06-10',102,1,0,5),('2022-06-10',103,1,0,4),('2022-06-10',104,1,0,3),('2022-06-10',105,1,0,2),('2022-06-10',106,1,0,1),('2022-06-12',102,0,1,5),('2022-06-12',103,0,1,4),('2022-06-12',104,0,1,3),('2022-06-12',105,0,1,2),('2022-06-12',106,0,1,1);
/*!40000 ALTER TABLE `workorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-25  2:30:32
