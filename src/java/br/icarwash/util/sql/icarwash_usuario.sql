-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: icarwash
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(25) NOT NULL,
  `senha` varchar(40) NOT NULL,
  `nivel` int(1) unsigned NOT NULL DEFAULT '1',
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `cadastro` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `nivel` (`nivel`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES 
(1,'ricardo','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42'),
(2,'rodrigo','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42'),
(3,'renan','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:43'),

(4,'c1','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 17:21:10'),
(5,'c2','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 19:40:38'),
(6,'c3','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 20:26:04'),
(7,'c4','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:06:07'),
(8,'c5','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:16:32'),
(9,'c6','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:49:31'),
(10,'c7','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:50:02'),
(11,'c8','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:05'),
(12,'c9','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:28'),
(13,'c10','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:52:38'),

(14,'l1','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-07 08:53:05'),
(15,'l2','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:08'),
(16,'l3','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:59'),
(17,'l4','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 20:34:45'),
(18,'l5','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:08:43'),
(19,'l6','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:35:20'),
(20,'l7','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:37:54'),
(21,'l8','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-28 14:43:00'),
(22,'l9','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:37:54'),
(23,'l10','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:37:54');

/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-02 13:00:53
