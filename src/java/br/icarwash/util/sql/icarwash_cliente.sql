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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES 
(1,'joao@gmail.com','joao','(11)11111-1111','1111-11-11','111.111.111-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),
(2,'pedro@yahoo.com','pedro','123456789','1995-05-06','123.123.123-12','teste2','te','teste2','teste2','teste2',2),
(3,'maria@gmail.com','maria','(12)31231-2312','1880-07-12','123.123.123-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',321),
(4,'jose@yahoo.com','jose','(12)32132-1322','2002-07-12','123.654.656-54','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',103),
(5,'antonio@gmail.com','antonio','(22)22222-2222','2001-10-22','165.465.465-46','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',153),
(6,'tiago@gmail.com','tiago','(11)11111-1111','1111-11-11','111.112.111-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',344),
(7,'davi@hotmail.com','davi','(12)45784-5122','2001-09-29','456.879.845-64','08745-310','SP','Mogi das Cruzes','Vila Bela Flor123','Avenida Santo Antônio',256),
(8,'ana@yahoo.com','ana','(12)32312-3123','2001-12-12','121.212.121-21','12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',113),
(9,'cristiane@yahoo.com','cristiane','(12)32312-3123','2001-12-12','121.212.121-22','12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',156),
(10,'julia@gmail.com','julia','(12)32312-3123','2001-12-12','121.212.121-23','12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',479);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
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
