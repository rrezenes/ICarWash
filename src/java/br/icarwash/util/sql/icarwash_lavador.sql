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
  `email` varchar(255) NOT NULL,
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
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lavador`
--

LOCK TABLES `lavador` WRITE;
/*!40000 ALTER TABLE `lavador` DISABLE KEYS */;
INSERT INTO `lavador` VALUES (2,'2017-05-07','teste@teste.com.br','adadasdasd','(11)11111-1111','1111-11-11','111.111.111-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(3,'2017-05-07','teste2@teste.com.br','adadasdasd','(22)22222-2222','1516-10-22','111.111.111-13','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',366),(4,'2017-05-07','teste4@teste.com','teste4','(12)12121-2121','1999-12-12','124.578.451-22','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(6,'2017-05-07','teste13254654321','teste13254654','(54)65465-4654','1971-01-01','354.654.654-65','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(7,'2017-05-17','aisudhauisdhui@sajdgaysu.asdas123','adadasdasdqw123','(11)23321-3213','2000-12-12','123.123.213-21','08745-112','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio123',1232),(8,'2017-05-17','aisudhauisdhui@s123','asassassasa123','(21)68154-8154','1980-01-01','123.123.123-12','12312-300','SP','Jacareí123','Cidade Salvador123','Rua Mabito Shoji123',123123313),(9,'2017-05-28','emaillavador@email.com','Lavadir Silva','(11)90909-0909','1989-07-16','123.435.382-76','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',12345);
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
