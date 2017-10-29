-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: icarwash
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliacao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nota_pontualidade` decimal(3,2) DEFAULT NULL,
  `nota_servico` decimal(3,2) DEFAULT NULL,
  `nota_atendimento` decimal(3,2) DEFAULT NULL,
  `nota_agilidade` decimal(3,2) DEFAULT NULL,
  `nota_media` decimal(3,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (9,5.00,4.00,5.00,3.00,4.25),(10,4.50,4.50,4.00,4.50,4.38),(11,1.00,2.00,3.00,4.00,2.50),(12,4.50,2.50,5.00,3.00,3.75),(13,4.00,3.00,2.00,0.50,2.38),(14,5.00,5.00,5.00,5.00,5.00),(15,2.00,3.00,4.00,1.00,2.50),(16,1.00,1.00,1.00,5.00,2.00),(17,5.00,5.00,2.00,4.00,4.00),(18,3.00,1.00,5.00,1.00,2.50),(19,5.00,2.00,4.50,1.50,3.25),(20,4.50,2.50,2.00,4.50,3.38),(21,2.50,3.50,4.00,3.00,3.25),(22,5.00,3.00,5.00,2.50,3.88),(23,3.50,3.00,3.50,4.50,3.63),(24,4.50,2.50,1.50,1.00,2.38),(25,5.00,3.00,5.00,5.00,4.50),(26,1.50,3.00,2.50,2.00,2.25),(27,0.50,0.50,0.50,0.50,0.50);
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `dt_nascimento` date NOT NULL,
  `CPF` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CPF` (`CPF`),
  KEY `cliente_usuario` (`id_usuario`),
  CONSTRAINT `cliente_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,4,'João ','(11)11111-1111','1111-11-11','111.111.111-11'),(2,5,'pedro','123456789','1995-05-06','123.123.123-12'),(3,6,'maria','(12)31231-2312','1880-07-12','123.123.123-11'),(4,7,'jose','(12)32132-1322','2002-07-12','123.654.656-54'),(5,8,'antonio','(22)22222-2222','2001-10-22','165.465.465-46'),(6,9,'tiago','(11)11111-1111','1111-11-11','111.112.111-11'),(7,10,'Davi','(12)45784-5122','2001-09-29','456.879.845-64'),(8,11,'ana','(12)32312-3123','2001-12-12','121.212.121-21'),(9,12,'cristiane','(12)32312-3123','2001-12-12','121.212.121-22'),(10,13,'julia','(12)32312-3123','2001-12-12','121.212.121-23'),(33,45,'abc teste','(11)11111-1111','1111-11-11','405.241.538-84'),(34,46,'Fulano','(11)11111-1111','1111-11-11','406.748.298-16'),(36,54,'Adamastor','(99)99999-9999','1992-01-12','515.352.966-58'),(37,55,'Cosmo','11987647118','1993-06-29','074.621.288-70'),(38,57,'teste','(99)99999-9999','2007-07-08','608.080.442-57'),(41,58,'teste','(99)99999-9999','1999-12-11','655.446.350-05'),(44,60,'abc','(99)99999-9999','1999-11-10','851.661.380-15'),(46,67,'cliente 1','(99)99999-9999','1999-11-10','216.751.620-77'),(47,68,'Gol G3','(99)99999-9999','1999-12-11','129.265.190-36'),(48,70,'Qwert','(11)11111-1111','1800-11-11','885.243.130-64'),(55,77,'teste','(11)11111-1111','1111-11-11','451.782.722-42'),(56,78,'iasudhuais','(11)11111-1111','1111-11-11','654.624.014-93');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_endereco`
--

DROP TABLE IF EXISTS `cliente_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_endereco` (
  `id_cliente` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  UNIQUE KEY `unico` (`id_cliente`,`id_endereco`),
  KEY `FK_endereco` (`id_endereco`),
  CONSTRAINT `FK_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`ID`),
  CONSTRAINT `FK_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_endereco`
--

LOCK TABLES `cliente_endereco` WRITE;
/*!40000 ALTER TABLE `cliente_endereco` DISABLE KEYS */;
INSERT INTO `cliente_endereco` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(33,11),(34,12),(36,13),(37,14),(38,15),(41,16),(44,17),(46,18),(47,19),(48,20),(55,34),(56,35);
/*!40000 ALTER TABLE `cliente_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CEP` varchar(9) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',1234),(2,'teste2','te','teste2','teste2','teste2',2),(3,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',321),(4,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',103),(5,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',153),(6,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',344),(7,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor123','Avenida Santo Antônio',256),(8,'12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',113),(9,'12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',156),(10,'12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',479),(11,'11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123),(12,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',300),(13,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',366),(14,'11702530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123),(15,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',344),(16,'08745-300','SP','Mogi das Cruzes','Vila Bela Flor','Rua Nair',12),(17,'11703-530','SP','Praia Grande','Tupi','Rua Tupiniquins',10),(18,'11703-530','SP','Praia Grande','Tupi','Rua Tupiniquins',10),(19,'11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',10),(20,'11704-350','SP','Praia Grande','Ocian','Rua Mário Guido Ferrazo',123),(21,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(22,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',366),(23,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(24,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(25,'08745-112','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio123',1232),(26,'12312-300','SP','Jacareí123','Cidade Salvador123','Rua Mabito Shoji123',12312),(27,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',12345),(28,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',23456),(29,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',34567),(30,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',45678),(31,'11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123),(32,'11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123),(33,'11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123),(34,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',366),(35,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',133),(36,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lavador`
--

DROP TABLE IF EXISTS `lavador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lavador` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `dt_contrato` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `dt_nascimento` date NOT NULL,
  `CPF` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CPF` (`CPF`),
  KEY `lavador_usuario` (`id_usuario`),
  CONSTRAINT `lavador_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lavador`
--

LOCK TABLES `lavador` WRITE;
/*!40000 ALTER TABLE `lavador` DISABLE KEYS */;
INSERT INTO `lavador` VALUES (1,14,'2017-05-07','lavador joao','(11)11111-1111','1111-11-11','111.111.111-11'),(2,15,'2017-05-07','lavadora maria','(22)22222-2222','1516-10-22','111.111.111-13'),(3,16,'2017-05-07','lavador pedro','(12)12121-2121','1999-12-12','124.578.451-22'),(4,17,'2017-05-07','lavador jose','(54)65465-4654','1971-01-01','354.654.654-65'),(5,18,'2017-05-17','lavador antonio','(11)23321-3213','2000-12-12','123.123.213-21'),(6,19,'2017-05-17','lavador tiago','(21)68154-8154','1980-01-01','123.123.123-12'),(7,20,'2017-05-28','lavador davi','(11)90909-0909','1989-07-16','123.435.382-76'),(8,21,'2017-05-28','lavadora ana','(11)90909-0909','1989-07-16','123.435.382-77'),(9,22,'2017-05-28','lavadora cristiane','(11)90909-0909','1989-07-16','123.435.382-78'),(10,23,'2017-05-28','lavadora julia','(11)90909-0909','1989-07-16','123.435.382-79'),(11,51,'2017-10-08','abc teste','(11)11111-1111','1970-01-01','405.241.538-84'),(13,53,'2017-10-08','abc','(11)11111-1111','1111-11-11','705.727.540-43'),(14,56,'2017-10-21','Willian','98764718','1999-01-29','074.621.288-70'),(15,79,'2017-10-29','aisuhdiuasdh','(11)11111-1111','1111-11-11','164.696.767-40');
/*!40000 ALTER TABLE `lavador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lavador_endereco`
--

DROP TABLE IF EXISTS `lavador_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lavador_endereco` (
  `id_lavador` int(11) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  UNIQUE KEY `unico` (`id_lavador`,`id_endereco`),
  KEY `FK_enderecoo` (`id_endereco`),
  CONSTRAINT `FK_enderecoo` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`ID`),
  CONSTRAINT `FK_lavador` FOREIGN KEY (`id_lavador`) REFERENCES `lavador` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lavador_endereco`
--

LOCK TABLES `lavador_endereco` WRITE;
/*!40000 ALTER TABLE `lavador_endereco` DISABLE KEYS */;
INSERT INTO `lavador_endereco` VALUES (1,21),(2,22),(3,23),(4,24),(5,25),(6,26),(7,27),(8,28),(9,29),(10,30),(11,31),(13,32),(14,33),(15,36);
/*!40000 ALTER TABLE `lavador_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Limpa Estofados A Seco 5 Litros - Vonixx','Limpa, tira manchas e deixa um agradável aroma',1),(2,'Cristalizador De Vidros','500ml - Braclean',1),(3,'Kit Lavagem','A Seco 500ml + Toalha Microfibra - Braclean',1),(4,'Shampoo Detergente','Automotivo Lave Seco 500ml - Mills',1),(5,'Cristalizador De Vidros','Cristalizador De Vidros 500ml - Mills',1),(6,'Pano','Microfibra 50x60cm - Alcance',1),(7,'Bio W Lavagem','A Seco Concentrado 1 Litro Até 1:50 - Alcance',1),(8,'Auto Lava Seco',' 5 Litros - 3M',1),(9,'Limpeza De Rodas E Motores','Bio W - Alcance',1),(10,'Lavagem A Seco 5 Litros','Ecoflex Ultra - Vonixx',1),(11,'Limpa Estofados A Seco 5 Litros - Vonixx.','Limpa, tira manchas e deixa um agradável aroma',0),(30,'teste','teste',0),(31,'teste','teste',0),(32,'teste','teste',0),(33,'teste','teste',0),(34,'testeasidgyiuasdiuh','asiduhuiasdhasiud',0),(35,'abc','abc',0),(36,'abc','abc',0),(37,'Qwert','Qwert',0);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `valor` decimal(10,2) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'Aspiração','Aspiração completa do veículo.',20.00,1),(2,'Lavagem a Seco Externa simples','Limpeza externa simples do veículo.',30.00,1),(3,'Lavagem a Seco Interna simples','Limpeza interior simples do veículo.',20.00,1),(4,'Lavagem a Seco Externa completa','Limpeza externa completa do veículo.',50.00,1),(5,'Lavagem a Seco Interna completa','Limpeza interior completa do veículo.',35.00,1),(6,'Cristalização','Cristalização externa do veículo.',110.00,1),(7,'Higienização','Higienização interior do veículo.',30.00,1),(8,'Lavagem de Motor','Lavagem de Motor',49.99,1),(9,'Enceramento','Camada de proteção e brilho por mais tempo.',99.99,1),(10,'Polimento ','Some com as manchas, riscos e imperfeições na pintura.',259.99,1),(13,'aiusdhuiasdhiu','aisudhuiasdui',123.00,1);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico_produtos`
--

DROP TABLE IF EXISTS `servico_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico_produtos` (
  `id_servico` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`id_servico`,`id_produto`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `servico_produtos_ibfk_1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`ID`),
  CONSTRAINT `servico_produtos_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico_produtos`
--

LOCK TABLES `servico_produtos` WRITE;
/*!40000 ALTER TABLE `servico_produtos` DISABLE KEYS */;
INSERT INTO `servico_produtos` VALUES (1,3,2),(1,5,2),(2,2,4),(2,3,2),(2,6,4),(3,3,1),(3,5,1),(3,6,2),(4,1,4),(4,3,3),(4,4,5),(5,1,1),(5,5,2),(5,9,1),(6,1,2),(6,2,4),(6,3,1),(7,2,4),(7,3,2),(7,6,4),(8,3,1),(8,5,1),(8,6,2),(9,1,4),(9,3,3),(9,4,5),(10,1,1),(10,5,2),(10,9,1),(13,1,2),(13,2,5);
/*!40000 ALTER TABLE `servico_produtos` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao`
--

LOCK TABLES `solicitacao` WRITE;
/*!40000 ALTER TABLE `solicitacao` DISABLE KEYS */;
INSERT INTO `solicitacao` VALUES (152,34,NULL,NULL,'medio','2017-10-10 08:00:00','Cancelado',20.00),(153,34,NULL,NULL,'medio','2017-10-10 08:00:00','Cancelado',20.00),(154,34,NULL,NULL,'medio','2017-10-10 08:00:00','Cancelado',50.00),(155,34,4,10,'medio','2017-10-10 08:00:00','Avaliado',35.00),(156,34,1,9,'medio','2017-10-10 08:00:00','Avaliado',35.00),(157,34,2,11,'medio','2017-10-13 13:00:00','Avaliado',30.00),(158,36,2,NULL,'medio','2017-10-13 10:00:00','Finalizado',30.00),(159,34,NULL,NULL,'medio','2017-10-13 08:00:00','Cancelado',359.98),(160,34,1,16,'medio','2017-10-24 08:00:00','Avaliado',110.00),(161,34,4,18,'medio','2017-10-24 08:00:00','Avaliado',110.00),(162,34,NULL,NULL,'grande','2017-10-16 09:00:00','Cancelado',110.00),(163,34,NULL,NULL,'medio','2017-10-16 09:00:00','Cancelado',110.00),(164,34,2,17,'medio','2017-10-24 08:00:00','Avaliado',50.00),(165,34,3,15,'medio','2017-10-24 08:00:00','Avaliado',110.00),(166,34,4,19,'medio','2017-10-24 09:00:00','Avaliado',30.00),(167,34,NULL,NULL,'medio','2017-10-17 08:00:00','Cancelado',50.00),(168,34,1,20,'medio','2017-10-24 09:00:00','Avaliado',110.00),(169,34,3,25,'medio','2017-10-24 09:00:00','Avaliado',110.00),(170,34,2,24,'medio','2017-10-24 09:00:00','Avaliado',50.00),(171,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(172,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(173,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(174,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(175,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(176,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(177,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(178,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(179,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(180,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(181,34,NULL,NULL,'medio','2017-10-24 09:00:00','Cancelado',50.00),(182,34,2,13,'medio','2017-10-18 08:00:00','Avaliado',50.00),(183,34,3,12,'grande','2017-10-17 08:00:00','Avaliado',50.00),(184,34,NULL,NULL,'medio','2017-10-16 08:00:00','Cancelado',50.00),(185,34,NULL,NULL,'medio','2017-10-16 08:00:00','Cancelado',309.99),(186,34,NULL,NULL,'medio','2017-10-16 08:00:00','Cancelado',20.00),(187,34,NULL,NULL,'medio','2017-10-16 08:00:00','Cancelado',50.00),(188,34,NULL,NULL,'medio','2017-10-17 08:00:00','Cancelado',50.00),(189,34,3,22,'medio','2017-10-24 11:00:00','Avaliado',165.00),(190,34,4,21,'medio','2017-10-27 13:00:00','Avaliado',30.00),(191,34,1,23,'medio','2017-10-24 11:00:00','Avaliado',110.00),(192,34,4,14,'pequeno','2017-10-23 14:00:00','Avaliado',20.00),(193,34,2,NULL,'medio','2017-10-23 08:00:00','Finalizado',30.00),(194,34,4,NULL,'medio','2017-10-23 08:00:00','Finalizado',30.00),(195,34,1,26,'medio','2017-10-23 08:00:00','Avaliado',30.00),(196,34,4,NULL,'medio','2017-10-24 16:00:00','Finalizado',110.00),(197,34,3,NULL,'medio','2017-10-23 08:00:00','Finalizado',50.00),(198,34,2,NULL,'medio','2017-10-23 09:00:00','Finalizado',20.00),(199,34,1,NULL,'medio','2017-10-23 08:00:00','Finalizado',30.00),(200,34,1,27,'grande','2017-10-23 08:00:00','Avaliado',30.00),(201,34,1,NULL,'pequeno','2017-10-23 08:00:00','Finalizado',384.98),(202,34,1,NULL,'pequeno','2017-10-23 08:00:00','Finalizado',184.99),(203,34,NULL,NULL,'pequeno','2017-10-23 08:00:00','Agendado',20.00),(204,47,NULL,NULL,'pequeno','2017-10-23 08:00:00','Agendado',20.00),(205,37,1,NULL,'pequeno','2017-10-23 13:00:00','Agendado',50.00);
/*!40000 ALTER TABLE `solicitacao` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `solicitacao_servico` VALUES (152,1),(159,1),(192,1),(198,1),(201,1),(202,1),(203,1),(204,1),(205,1),(157,2),(158,2),(159,2),(166,2),(190,2),(193,2),(194,2),(195,2),(199,2),(200,2),(205,2),(153,3),(186,3),(189,3),(201,3),(154,4),(164,4),(167,4),(170,4),(171,4),(172,4),(173,4),(174,4),(175,4),(176,4),(177,4),(178,4),(179,4),(180,4),(181,4),(182,4),(183,4),(184,4),(185,4),(187,4),(188,4),(197,4),(202,4),(155,5),(156,5),(189,5),(201,5),(202,5),(160,6),(161,6),(162,6),(163,6),(165,6),(168,6),(169,6),(189,6),(191,6),(196,6),(202,7),(159,8),(201,8),(202,8),(159,10),(185,10),(201,10);
/*!40000 ALTER TABLE `solicitacao_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `senha` varchar(40) NOT NULL,
  `nivel` int(1) unsigned NOT NULL DEFAULT '1',
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `cadastro` datetime NOT NULL,
  `cadastro_completo` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `nivel` (`nivel`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ricardo@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42',1),(2,'rodrigo@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42',1),(3,'renan@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:43',1),(4,'joao@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 17:21:10',1),(5,'pedro@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 19:40:38',1),(6,'maria@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 20:26:04',1),(7,'jose@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:06:07',1),(8,'antonio@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:16:32',1),(9,'tiago@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:49:31',1),(10,'davi@hotmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:50:02',1),(11,'ana@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:05',1),(12,'cristiane@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:28',1),(13,'julia@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:52:38',1),(14,'l1@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-07 08:53:05',1),(15,'l2@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:08',1),(16,'l3@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:59',1),(17,'l4@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 20:34:45',1),(18,'l5@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:08:43',1),(19,'l6@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:35:20',1),(20,'l7@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:37:54',1),(21,'l8@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-28 14:43:00',1),(22,'l9@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:37:54',1),(23,'l10@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:37:54',1),(45,'c20@c20.com','8cb2237d0679ca88db6464eac60da96345513964',1,0,'2017-10-08 20:38:33',1),(46,'c123@c123.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-08 21:09:34',1),(51,'l21@l21.com','8cb2237d0679ca88db6464eac60da96345513964',2,0,'2017-10-08 21:35:54',0),(53,'c20asas@com','8cb2237d0679ca88db6464eac60da96345513964',2,0,'2017-10-08 21:44:01',0),(54,'teste@teste123.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-12 11:14:07',1),(55,'c1234@c1234.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-21 17:35:37',1),(56,'l51@icarwash.com','8cb2237d0679ca88db6464eac60da96345513964',2,0,'2017-10-21 17:44:20',1),(57,'aysdgyasdgy@auysdgyas.asd','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 14:01:04',1),(58,'c12345@c12345.com','343f8939de25f70dc999d9f4507338dd863de449',1,1,'2017-10-22 14:45:35',1),(59,'c1234@c12345.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 14:55:40',0),(60,'c12345@c1234.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 14:59:29',1),(61,'c12346@c1234.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 15:04:44',0),(62,'c1237@c1234.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 15:07:56',0),(63,'1uaisdhiua@asiudhias.asd','c06a34fea1fcd5582494d722d22aee23018e2055',1,1,'2017-10-22 15:11:39',0),(64,'11uaisdhiua@asiudhias.asd','c6db25043acf806ce84196ae1ca218b5addce2fd',1,1,'2017-10-22 15:12:07',0),(65,'121uaisdhiua@asiudhias.asd','ce1cf594a0a58ac11bbc2fe6ddaeb8b12d802239',1,1,'2017-10-22 15:15:13',0),(66,'c123@c1234.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 15:18:26',0),(67,'c1238@c1234.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 16:32:03',1),(68,'c1238@c1238.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-22 16:46:47',1),(69,'c123@c1123.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-28 20:16:20',0),(70,'Qwert@qwert.com','d033e22ae348aeb5660fc2140aec35850c4da997',1,1,'2017-10-29 00:43:19',1),(77,'c222@c222.com','8cb2237d0679ca88db6464eac60da96345513964',1,0,'2017-10-29 15:19:48',1),(78,'a8sdhiuasdiuasd@asdiuhiuasd.asd','8cb2237d0679ca88db6464eac60da96345513964',1,0,'2017-10-29 15:22:11',1),(79,'iuahsdiuasd@uiashdiuas.asd','8cb2237d0679ca88db6464eac60da96345513964',2,1,'2017-10-29 15:37:58',1);
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

-- Dump completed on 2017-10-29 16:31:04