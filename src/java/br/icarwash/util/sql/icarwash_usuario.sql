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
INSERT INTO `usuario` VALUES (1,'ricardo','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42'),(2,'rodrigo','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42'),(3,'renan','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:43'),(4,'cliente','40bd001563085fc35165329ea1ff5c5ecbdbbeef',3,1,'2017-05-06 17:21:10'),(8,'teste2','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,0,'2017-05-06 19:40:38'),(11,'qwerty','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,0,'2017-05-06 20:26:04'),(12,'testela','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:06:07'),(13,'teste4','901d6751c6d43adfdc8fdd7f0a51d3fd34c7ae2e',2,0,'2017-05-07 01:16:32'),(14,'teste3','5458cb00631fc6748f9d3a52cf6c22ae9b232e91',1,1,'2017-05-07 08:49:31'),(16,'teste10','5458cb00631fc6748f9d3a52cf6c22ae9b232e91',1,1,'2017-05-07 08:50:02'),(17,'abc','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:05'),(19,'abcd','da39a3ee5e6b4b0d3255bfef95601890afd80709',1,0,'2017-05-07 08:51:28'),(20,'teste123','5458cb00631fc6748f9d3a52cf6c22ae9b232e91',2,1,'2017-05-07 08:52:38'),(22,'teste1235465','45eca596d6f36ca6b4b2ec18338c998c04e1fd1d',2,1,'2017-05-07 08:53:05'),(23,'abccdb','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-15 19:52:08'),(25,'abccdbqweqwe','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,0,'2017-05-15 19:52:59'),(26,'adminasas','4d9012b4a77a9524d675dad27c3276ab5705e5e8',1,0,'2017-05-17 20:34:45'),(27,'asdasdwwe','19b58543c85b97c5498edfd89c11c3aa8cb5fe51',2,0,'2017-05-17 21:08:43'),(28,'teste112','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,0,'2017-05-17 21:35:20'),(29,'teste1234','7b52009b64fd0a2a49e6d8a939753077792b0554',2,0,'2017-05-17 21:37:54'),(30,'la','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-28 14:43:00');
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
