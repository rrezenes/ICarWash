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
-- Table structure for table `lavador`
--

DROP TABLE IF EXISTS `lavador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lavador` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `dt_contrato` date NOT NULL,
  `email` varchar(255),
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `dt_nascimento` date NOT NULL,
  `CPF` varchar(255) NOT NULL,
  `CEP` varchar(9) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CPF` (`CPF`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lavador`
--

LOCK TABLES `lavador` WRITE;
/*!40000 ALTER TABLE `lavador` DISABLE KEYS */;
INSERT INTO `lavador` VALUES 
(1,'2017-05-07','lavadorjoao@icarwash.com','lavador joao','(11)11111-1111','1111-11-11','111.111.111-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),
(2,'2017-05-07','lavadoramaria@icarwash.com','lavadora maria','(22)22222-2222','1516-10-22','111.111.111-13','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',366),
(3,'2017-05-07','lavadorpedro@icarwash.com','lavador pedro','(12)12121-2121','1999-12-12','124.578.451-22','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),
(4,'2017-05-07','lavadorjose@icarwash.com','lavador jose','(54)65465-4654','1971-01-01','354.654.654-65','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),
(5,'2017-05-17','lavadorantonio@icarwash.com','lavador antonio','(11)23321-3213','2000-12-12','123.123.213-21','08745-112','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio123',1232),
(6,'2017-05-17','lavadortiago@icarwash.com','lavador tiago','(21)68154-8154','1980-01-01','123.123.123-12','12312-300','SP','Jacareí123','Cidade Salvador123','Rua Mabito Shoji123',12312),
(7,'2017-05-28','lavadordavi@icarwash.com','lavador davi','(11)90909-0909','1989-07-16','123.435.382-76','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',12345),
(8,'2017-05-28','lavadoraana@icarwash.com','lavadora ana','(11)90909-0909','1989-07-16','123.435.382-77','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',23456),
(9,'2017-05-28','lavadorcristiane@icarwash.com','lavadora cristiane','(11)90909-0909','1989-07-16','123.435.382-78','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',34567),
(10,'2017-05-28','lavadorjulia@icarwash.com','lavadora julia','(11)90909-0909','1989-07-16','123.435.382-79','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',45678);

/*!40000 ALTER TABLE `lavador` ENABLE KEYS */;
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
