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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (9,5.00,4.00,5.00,3.00,4.25),(10,4.50,4.50,4.00,4.50,4.38),(11,1.00,2.00,3.00,4.00,2.50),(12,4.50,2.50,5.00,3.00,3.75),(13,4.00,3.00,2.00,0.50,2.38),(14,5.00,5.00,5.00,5.00,5.00),(15,2.00,3.00,4.00,1.00,2.50),(16,1.00,1.00,1.00,5.00,2.00),(17,5.00,5.00,2.00,4.00,4.00),(18,3.00,1.00,5.00,1.00,2.50),(19,5.00,2.00,4.50,1.50,3.25),(20,4.50,2.50,2.00,4.50,3.38),(21,2.50,3.50,4.00,3.00,3.25),(22,5.00,3.00,5.00,2.50,3.88),(23,3.50,3.00,3.50,4.50,3.63),(24,4.50,2.50,1.50,1.00,2.38),(25,5.00,3.00,5.00,5.00,4.50),(26,1.50,3.00,2.50,2.00,2.25),(27,0.50,0.50,0.50,0.50,0.50),(28,1.00,2.00,3.00,4.00,NULL),(29,3.50,2.50,5.00,5.00,NULL),(30,5.00,4.00,5.00,5.00,NULL),(31,5.00,5.00,5.00,5.00,NULL),(32,3.50,2.00,5.00,3.50,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,4,'Joãoa','(22)22222-2222','1988-11-14','111.111.111-11'),(2,5,'teste','(22)22222-2222','1995-05-06','123.123.123-12'),(3,6,'maria','(12)31231-2312','1880-07-12','123.123.123-11'),(4,7,'jose','(12)32132-1322','2002-07-12','123.654.656-54'),(5,8,'antonio','(22)22222-2222','2001-10-22','165.465.465-46'),(6,9,'tiago','(11)11111-1111','1111-11-11','111.112.111-11'),(7,10,'Davi','(12)45784-5122','2001-09-29','456.879.845-64'),(8,11,'ana','(12)32312-3123','2001-12-12','121.212.121-21'),(9,12,'cristiane','(12)32312-3123','2001-12-12','121.212.121-22'),(10,13,'julia','(12)32312-3123','2001-12-12','121.212.121-23'),(34,46,'Fulanoo','(22)22222-2222','1988-11-11','406.748.298-16'),(35,47,'aisudhiuasdui','(12)13131-2313','1992-01-16','405.241.538-84');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
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
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',1234,'Casa'),(2,'teste2','te','teste2','teste2','teste2',2,'Casa'),(3,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',321,'Casa'),(4,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',103,'Casa'),(5,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',153,'Casa'),(6,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',344,'Casa'),(7,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor123','Avenida Santo Antônio',256,'Casa'),(8,'12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',113,'Casa'),(9,'12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',156,'Casa'),(10,'12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',479,'Casa'),(12,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123,'Casa'),(21,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123,'Casa'),(22,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',366,'Casa'),(23,'01125-000','SP','São Paulo','Bom Retiro','Rua da Graça - de 2 ao fim - lado par',123,'Casa'),(24,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123,'Casa'),(37,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antonio',366,'Trabalho'),(46,'08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',12345,'aisudhiuasd');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
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
  PRIMARY KEY (`id_cliente`,`id_endereco`),
  KEY `id_endereco` (`id_endereco`),
  CONSTRAINT `cliente_endereco_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`ID`),
  CONSTRAINT `cliente_endereco_ibfk_2` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_endereco`
--

LOCK TABLES `cliente_endereco` WRITE;
/*!40000 ALTER TABLE `cliente_endereco` DISABLE KEYS */;
INSERT INTO `cliente_endereco` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(34,12),(1,37),(35,46);
/*!40000 ALTER TABLE `cliente_endereco` ENABLE KEYS */;
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
  `ocupado` tinyint(1) NOT NULL DEFAULT '0',
  `id_endereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CPF` (`CPF`),
  KEY `lavador_usuario` (`id_usuario`),
  KEY `FK_LavadorEndereco` (`id_endereco`),
  CONSTRAINT `FK_LavadorEndereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`ID`),
  CONSTRAINT `lavador_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lavador`
--

LOCK TABLES `lavador` WRITE;
/*!40000 ALTER TABLE `lavador` DISABLE KEYS */;
INSERT INTO `lavador` VALUES (1,14,'2017-05-07','Lavador Joaoa','(22)22222-2222','1890-03-03','111.111.111-11',0,21),(2,15,'2017-05-07','lavadora mariaa','(22)22222-2222','1970-01-01','111.111.111-13',0,22),(3,16,'2017-05-07','lavador pedro','(12)12121-2121','1999-12-12','124.578.451-22',0,12),(4,17,'2017-05-07','lavador jose','(54)65465-4654','1999-11-16','354.654.654-65',0,46);
/*!40000 ALTER TABLE `lavador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (2,'Fiat'),(3,'Ford'),(1,'GM'),(4,'Volkswagen');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_marca` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `porte` enum('PEQUENO','MEDIO','GRANDE') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `modelo_marca` (`id_marca`),
  CONSTRAINT `modelo_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (16,1,'Celta','PEQUENO'),(17,1,'Agile','PEQUENO'),(18,1,'Onix','PEQUENO'),(19,1,'Corsa','PEQUENO'),(20,1,'Classic','PEQUENO'),(21,1,'S10','GRANDE'),(22,1,'Track','MEDIO'),(23,1,'Silverado','GRANDE'),(24,1,'Captiva','MEDIO'),(25,1,'Astra','PEQUENO'),(26,1,'Blazer','MEDIO'),(27,1,'Chevette','PEQUENO'),(28,1,'Camaro','MEDIO'),(29,2,'Palio','PEQUENO'),(30,2,'Siena','PEQUENO'),(31,2,'Uno','PEQUENO'),(32,2,'Fiorino','PEQUENO'),(33,2,'Bravo','MEDIO'),(34,2,'Punto','MEDIO'),(35,2,'Toro','GRANDE'),(36,2,'Doblo','MEDIO'),(37,3,'Ka','PEQUENO'),(38,3,'Focus','MEDIO'),(39,3,'Fiesta','PEQUENO'),(40,3,'Ranger','GRANDE'),(41,3,'Ecosport','MEDIO'),(42,3,'Edge','GRANDE'),(43,3,'Fusion','MEDIO'),(44,3,'Mustang','MEDIO'),(45,4,'Fox','PEQUENO'),(46,4,'Gol','PEQUENO'),(47,4,'Amarok','GRANDE'),(48,4,'Golf','MEDIO'),(49,4,'Polo','MEDIO'),(50,4,'Saveiro','PEQUENO'),(51,4,'Voyage','PEQUENO');
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Limpa Estofados A Seco 5 Litros - Vonixxq','Limpa, tira manchas e deixa um agradável aromaq',1),(2,'Cristalizador De Vidros','500ml - Braclean',1),(3,'Kit Lavagem','A Seco 500ml + Toalha Microfibra - Braclean',1),(4,'Shampoo Detergente','Automotivo Lave Seco 500ml - Mills',1),(5,'Cristalizador De Vidros','Cristalizador De Vidros 500ml - Mills',1),(6,'Pano','Microfibra 50x60cm - Alcance',1),(7,'Bio W Lavagem','A Seco Concentrado 1 Litro Até 1:50 - Alcance',1),(8,'Auto Lava Seco',' 5 Litros - 3M',1),(9,'Limpeza De Rodas E Motores','Bio W - Alcance',1),(10,'Lavagem A Seco 5 Litros','Ecoflex Ultra - Vonixx',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'Aspiraçãoa','Aspiração completa do veículo.w',21.00,1),(2,'Lavagem a Seco Externa simples','Limpeza externa simples do veículo.',30.00,1),(3,'Lavagem a Seco Interna simples','Limpeza interior simples do veículo.',20.00,1),(4,'Lavagem a Seco Externa completa','Limpeza externa completa do veículo.',50.00,1),(5,'Lavagem a Seco Interna completa','Limpeza interior completa do veículo.',35.00,1),(6,'Cristalização','Cristalização externa do veículo.',110.00,1),(7,'Higienização','Higienização interior do veículo.',30.00,1),(8,'Lavagem de Motor','Lavagem de Motor',49.99,1),(9,'Enceramento','Camada de proteção e brilho por mais tempo.',99.99,1),(10,'Polimento ','Some com as manchas, riscos e imperfeições na pintura.',259.99,1);
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
INSERT INTO `servico_produtos` VALUES (1,2,5),(1,3,2),(2,2,4),(2,3,2),(2,6,4),(3,3,1),(3,5,1),(3,6,2),(4,1,4),(4,3,3),(4,4,5),(5,1,1),(5,5,2),(5,9,1),(6,1,2),(6,2,4),(6,3,1),(7,2,4),(7,3,2),(7,6,4),(8,3,1),(8,5,1),(8,6,2),(9,1,4),(9,3,3),(9,4,5),(10,1,1),(10,5,2),(10,9,1);
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
  `id_endereco` int(11) NOT NULL,
  `id_modelo` int(11) NOT NULL,
  `data_solicitacao` datetime NOT NULL,
  `status` enum('Em Analise','Agendado','Em Processo','Finalizado','Avaliado','Concluido','Cancelado') NOT NULL DEFAULT 'Em Analise',
  `valor_total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_lavador` (`id_lavador`),
  KEY `id_avaliacao` (`id_avaliacao`),
  KEY `id_endereco` (`id_endereco`),
  KEY `id_modelo` (`id_modelo`),
  CONSTRAINT `solicitacao_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`ID`),
  CONSTRAINT `solicitacao_ibfk_3` FOREIGN KEY (`id_lavador`) REFERENCES `lavador` (`ID`),
  CONSTRAINT `solicitacao_ibfk_4` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`ID`),
  CONSTRAINT `solicitacao_ibfk_5` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`ID`),
  CONSTRAINT `solicitacao_ibfk_6` FOREIGN KEY (`id_modelo`) REFERENCES `modelo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao`
--

LOCK TABLES `solicitacao` WRITE;
/*!40000 ALTER TABLE `solicitacao` DISABLE KEYS */;
INSERT INTO `solicitacao` VALUES (250,1,4,28,1,20,'2017-11-15 08:00:00','Avaliado',70.00),(251,1,2,29,37,20,'2017-11-21 08:00:00','Avaliado',50.00),(252,1,2,30,37,20,'2017-11-22 08:00:00','Avaliado',110.00),(253,1,3,31,37,20,'2017-11-22 08:00:00','Avaliado',35.00),(254,1,2,NULL,37,40,'2017-11-24 08:00:00','Cancelado',21.00),(255,1,4,NULL,37,16,'2017-11-24 08:00:00','Cancelado',20.00),(256,1,2,NULL,37,38,'2017-11-29 08:00:00','Cancelado',21.00),(257,1,4,NULL,1,17,'2017-11-29 08:00:00','Cancelado',51.00),(258,1,2,NULL,37,18,'2017-11-29 09:00:00','Cancelado',145.00),(259,1,4,NULL,37,38,'2017-11-29 11:00:00','Cancelado',21.00),(260,1,2,NULL,37,38,'2017-11-29 11:00:00','Cancelado',21.00),(261,1,NULL,NULL,37,38,'2017-11-29 11:00:00','Cancelado',21.00),(262,1,4,NULL,37,38,'2017-11-29 12:00:00','Cancelado',21.00),(263,1,2,NULL,37,38,'2017-11-29 12:00:00','Cancelado',21.00),(264,1,4,NULL,37,38,'2017-11-29 13:00:00','Cancelado',21.00),(265,1,2,NULL,37,38,'2017-11-29 13:00:00','Cancelado',21.00),(266,1,4,NULL,37,38,'2017-11-29 14:00:00','Cancelado',21.00),(267,1,2,NULL,37,38,'2017-11-29 14:00:00','Cancelado',21.00),(268,1,4,NULL,37,38,'2017-11-29 15:00:00','Cancelado',21.00),(269,1,2,NULL,37,38,'2017-11-29 15:00:00','Cancelado',21.00),(270,1,4,NULL,37,38,'2017-11-29 16:00:00','Cancelado',21.00),(271,1,2,NULL,37,38,'2017-11-29 16:00:00','Cancelado',21.00),(272,1,4,NULL,37,38,'2017-11-29 17:00:00','Cancelado',21.00),(273,1,2,NULL,37,38,'2017-11-29 17:00:00','Cancelado',21.00),(274,1,2,32,1,39,'2017-12-03 08:00:00','Avaliado',41.00),(275,35,4,NULL,46,18,'2017-12-05 08:00:00','Agendado',21.00),(276,1,4,NULL,37,19,'2017-12-13 08:00:00','Agendado',71.00);
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
INSERT INTO `solicitacao_servico` VALUES (254,1),(256,1),(257,1),(274,1),(275,1),(276,1),(257,2),(250,3),(255,3),(274,3),(250,4),(251,4),(276,4),(253,5),(258,5),(252,6),(258,6);
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ricardo@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42',1),(2,'rodrigo@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42',1),(3,'renan@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:43',1),(4,'rezeness@no-spam.ws','7c4a8d09ca3762af61e59520943dc26494f8941b',1,1,'2017-05-06 17:21:10',1),(5,'pedro@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-06 19:40:38',1),(6,'maria@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-06 20:26:04',1),(7,'jose@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-07 01:06:07',1),(8,'antonio@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-07 01:16:32',1),(9,'tiago@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-07 08:49:31',1),(10,'davi@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-07 08:50:02',1),(11,'ana@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-07 08:51:05',1),(12,'cristiane@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-07 08:51:28',1),(13,'julia@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-05-07 08:52:38',1),(14,'l1@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',2,0,'2017-05-07 08:53:05',1),(15,'l2@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',2,1,'2017-05-15 19:52:08',1),(16,'l3@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',2,0,'2017-05-15 19:52:59',1),(17,'l4@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',2,1,'2017-05-17 20:34:45',1),(46,'c123@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-08 21:09:34',1),(47,'aiusdhuiahsuid@no-spam.ws','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-12-02 18:47:52',1);
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

-- Dump completed on 2017-12-03  7:51:09
