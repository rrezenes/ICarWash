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
-- Table structure for table `solicitacao_servico`
--

DROP TABLE IF EXISTS `solicitacao_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacao_servico` (
  `id_solicitacao` int(11) NOT NULL,
  `id_servico` int(11) NOT NULL,
  PRIMARY KEY (`id_solicitacao`,`id_servico`),
  KEY `id_servico` (`id_servico`),
  CONSTRAINT `solicitacao_servico_ibfk_1` FOREIGN KEY (`id_solicitacao`) REFERENCES `solicitacao` (`ID`),
  CONSTRAINT `solicitacao_servico_ibfk_2` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao_servico`
--

LOCK TABLES `solicitacao_servico` WRITE;
/*!40000 ALTER TABLE `solicitacao_servico` DISABLE KEYS */;
/*INSERT INTO `solicitacao_servico` VALUES (24,6),(25,6),(45,6),(46,6),(47,6),(48,6),(49,6),(50,6),(51,6),(52,6),(53,6),(54,6),(55,6),(56,6),(57,6),(59,6),(61,6),(62,6),(64,6),(43,7),(44,7),(46,7),(47,7),(48,7),(49,7),(50,7),(51,7),(52,7),(53,7),(58,7),(60,7),(24,8),(25,8),(46,8),(47,8),(48,8),(49,8),(50,8),(51,8),(52,8),(53,8),(55,8),(63,8),(46,9),(47,9),(48,9),(49,9),(50,9),(51,9),(52,9),(53,9),(56,9),(58,9),(64,9),(25,10),(45,10),(46,10),(47,10),(48,10),(49,10),(50,10),(51,10),(52,10),(53,10),(55,10),(64,10),(24,15),(46,18),(47,18),(48,18),(49,18),(50,18),(51,18),(52,18),(53,18),(56,18),(45,19),(46,19),(47,19),(48,19),(49,19),(50,19),(51,19),(52,19),(53,19),(55,19),(46,22),(47,22),(48,22),(49,22),(50,22),(51,22),(52,22),(53,22),(54,22),(46,23),(47,23),(48,23),(49,23),(50,23),(51,23),(52,23),(53,23),(55,23);
/*!40000 ALTER TABLE `solicitacao_servico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-02 13:00:55
