-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: danang-home
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
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `id` bigint NOT NULL,
  `average_price` double DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,100,'2023-09-24 15:33:28','kv hai chau','hai chau',NULL,'2023-09-24 15:33:28',_binary '\0'),(2,200,'2023-09-24 15:33:28','kv thanh khe','thanh khe',NULL,'2023-09-24 15:33:28',_binary '\0'),(3,300,'2023-09-24 15:33:28','kv son tra','son tra',NULL,'2023-09-24 15:33:28',_binary '\0'),(4,300,'2023-09-24 15:33:28','kv lien chieu','lien chieu',NULL,'2023-09-24 15:33:28',_binary '\0'),(5,300,'2023-09-24 15:33:28','kv hoa vang','hoa vang',NULL,'2023-09-24 15:33:28',_binary '\0'),(6,3001,'2023-09-24 15:33:28','kv hoang sa','hoang sa',NULL,'2023-09-24 15:33:28',_binary '\0');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (41);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id` bigint NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'2023-09-22 15:54:18','80000.0',NULL,'2023-09-24 15:54:18',2,_binary '\0'),(2,'2023-09-21 15:54:18','90000.0',NULL,'2023-09-24 15:54:18',2,_binary '\0'),(3,'2023-09-23 15:54:18','90000.0',NULL,'2023-09-24 15:54:18',2,_binary '\0'),(4,'2023-09-24 15:54:18','80000.0',NULL,'2023-09-24 15:54:18',2,_binary '\0'),(5,'2023-09-24 15:54:18','80000.0',NULL,'2023-09-24 15:54:18',2,_binary '\0'),(6,'2023-09-24 15:54:26','90000.0',NULL,'2023-09-24 15:54:26',2,_binary '\0'),(7,'2023-09-24 15:54:30','80000.0',NULL,'2023-09-24 15:54:30',2,_binary '\0'),(8,'2023-09-24 16:27:56','1.2E7',NULL,'2023-09-24 16:27:56',1,_binary '\0'),(9,'2023-09-24 16:28:01','1.8E7',NULL,'2023-09-24 16:28:01',1,_binary '\0'),(10,'2023-09-24 16:30:03','7000000.0',NULL,'2023-09-24 16:30:03',1,_binary '\0');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home`
--

DROP TABLE IF EXISTS `home`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home` (
  `id` bigint NOT NULL,
  `acreage` double DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `district_id` bigint DEFAULT NULL,
  `price` double DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home`
--

LOCK TABLES `home` WRITE;
/*!40000 ALTER TABLE `home` DISABLE KEYS */;
INSERT INTO `home` VALUES (1,800,'2023-09-24 15:52:05','kv Hai chau',1,80000,NULL,'2023-09-24 15:52:05',_binary '\0'),(2,300,'2023-09-24 15:52:14','kv Thanh Khê',2,90000,NULL,'2023-09-24 15:52:14',_binary '\0'),(3,300,'2023-09-24 15:52:25','kv Lien Chieu',4,90000,NULL,'2023-09-24 15:52:25',_binary '\0'),(4,60000,'2023-09-24 16:26:50','kv son tra',3,18000000,NULL,'2023-09-24 16:26:50',_binary '\0'),(5,60000,'2023-09-24 16:27:06','kv Thanh Khe',2,12000000,NULL,'2023-09-24 16:27:06',_binary '\0'),(6,70000,'2023-09-24 16:29:16','kv Hai Chau',1,7000000,NULL,'2023-09-24 16:29:16',_binary '\0');
/*!40000 ALTER TABLE `home` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2023-09-24 07:24:18','quangtan1197@gmail.com','TanHQ','123456',NULL,'2023-09-24 07:24:18',NULL),(2,'2023-09-24 07:24:18','quangtan11972@gmail.com','TanHQ1','123456',NULL,'2023-09-24 07:24:18',NULL);
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

-- Dump completed on 2023-09-24 16:51:30
