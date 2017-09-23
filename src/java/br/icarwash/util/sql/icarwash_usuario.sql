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
  `email` varchar(100) NOT NULL UNIQUE,
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
(1,'ricardo@icarwash.com','ricardo','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42'),
(2,'rodrigo@icarwash.com','rodrigo','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42'),
(3,'renan@icarwash.com','renan','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:43'),

(4,'joao@gmail.com', 'c1','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 17:21:10'),
(5,'pedro@yahoo.com','c2','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 19:40:38'),
(6,'maria@gmail.com','c3','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 20:26:04'),
(7,'jose@yahoo.com','c4','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:06:07'),
(8,'antonio@gmail.com','c5','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:16:32'),
(9,'tiago@gmail.com','c6','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:49:31'),
(10,'davi@hotmail.com','c7','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:50:02'),
(11,'ana@yahoo.com','c8','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:05'),
(12,'cristiane@yahoo.com','c9','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:28'),
(13,'julia@gmail.com','c10','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:52:38'),

(14,'lavadorjoao@icarwash.com','l1','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-07 08:53:05'),
(15,'lavadoramaria@icarwash.com','l2','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:08'),
(16,'lavadorpedro@icarwash.com','l3','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:59'),
(17,'lavadorjose@icarwash.com','l4','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 20:34:45'),
(18,'lavadorantonio@icarwash.com','l5','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:08:43'),
(19,'lavadortiago@icarwash.com','l6','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:35:20'),
(20,'lavadordavi@icarwash.com','l7','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:37:54'),
(21,'lavadoraana@icarwash.com','l8','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-28 14:43:00'),
(22,'lavadorcristiane@icarwash.com','l9','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:37:54'),
(23,'lavadorjulia@icarwash.com','l10','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 21:37:54');

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
