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
-- Table structure for table `solicitacao`
--

DROP TABLE IF EXISTS `solicitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_lavador` int(11) DEFAULT NULL,
  `id_avaliacao` int(11) DEFAULT NULL,
  `porte` varchar(8) NOT NULL,
  `data_solicitacao` datetime NOT NULL,
  `status` enum('Em Analise','Agendado','Em Processo','Finalizado','Avaliado','Concluido','Cancelado') NOT NULL DEFAULT 'Em Analise',
  `valor_total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_lavador` (`id_lavador`),
  KEY `id_avaliacao` (`id_avaliacao`),
  CONSTRAINT `solicitacao_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`ID`),
  CONSTRAINT `solicitacao_ibfk_3` FOREIGN KEY (`id_lavador`) REFERENCES `lavador` (`ID`),
  CONSTRAINT `solicitacao_ibfk_4` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao`
--

LOCK TABLES `solicitacao` WRITE;
/*!40000 ALTER TABLE `solicitacao` DISABLE KEYS */;
/*INSERT INTO `solicitacao` VALUES (24,1,NULL,NULL,'medio','2017-05-12 00:00:00','Cancelado',140.00),(25,1,NULL,NULL,'grande','2017-05-19 00:00:00','Cancelado',180.01),(42,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Em Analise',30.00),(43,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Em Processo',30.00),(44,1,NULL,NULL,'pequeno','2017-05-10 00:00:00','Cancelado',30.00),(45,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Em Processo',193.01),(46,1,NULL,NULL,'pequeno','2017-05-18 00:00:00','Cancelado',2391.01),(47,1,NULL,NULL,'pequeno','2017-05-18 00:00:00','Cancelado',2391.01),(48,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Cancelado',2391.01),(49,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Cancelado',2391.01),(50,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Cancelado',2391.01),(51,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Cancelado',2391.01),(52,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Cancelado',2391.01),(53,1,NULL,NULL,'pequeno','2017-05-17 00:00:00','Cancelado',2391.01),(54,1,NULL,NULL,'medio','2017-03-08 00:00:00','Cancelado',1019.00),(55,1,NULL,NULL,'medio','2017-05-20 00:00:00','Cancelado',1302.01),(56,1,NULL,NULL,'medio','2017-05-10 00:00:00','Agendado',80.00),(57,1,NULL,NULL,'medio','2017-05-20 00:00:00','Agendado',20.00),(58,10,NULL,NULL,'medio','2017-05-18 00:00:00','Cancelado',60.00),(59,10,NULL,NULL,'medio','2017-05-02 00:00:00','Cancelado',20.00),(60,10,NULL,NULL,'pequeno','2017-05-11 00:00:00','Cancelado',30.00),(61,10,NULL,NULL,'medio','2017-05-10 00:00:00','Cancelado',20.00),(62,10,NULL,NULL,'medio','2017-05-18 00:00:00','Em Analise',20.00),(63,10,NULL,NULL,'medio','2017-05-03 09:45:55','Agendado',110.00),(64,10,NULL,NULL,'grande','2017-05-31 13:45:07','Em Analise',100.01);
/*!40000 ALTER TABLE `solicitacao` ENABLE KEYS */;
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
