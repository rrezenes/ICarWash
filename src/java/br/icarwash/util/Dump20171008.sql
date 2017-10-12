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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
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
  `CEP` varchar(9) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CPF` (`CPF`),
  KEY `cliente_usuario` (`id_usuario`),
  CONSTRAINT `cliente_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,4,'joao','(11)11111-1111','1111-11-11','111.111.111-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(2,5,'pedro','123456789','1995-05-06','123.123.123-12','teste2','te','teste2','teste2','teste2',2),(3,6,'maria','(12)31231-2312','1880-07-12','123.123.123-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',321),(4,7,'jose','(12)32132-1322','2002-07-12','123.654.656-54','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',103),(5,8,'antonio','(22)22222-2222','2001-10-22','165.465.465-46','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',153),(6,9,'tiago','(11)11111-1111','1111-11-11','111.112.111-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',344),(7,10,'davi','(12)45784-5122','2001-09-29','456.879.845-64','08745-310','SP','Mogi das Cruzes','Vila Bela Flor123','Avenida Santo Antônio',256),(8,11,'ana','(12)32312-3123','2001-12-12','121.212.121-21','12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',113),(9,12,'cristiane','(12)32312-3123','2001-12-12','121.212.121-22','12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',156),(10,13,'julia','(12)32312-3123','2001-12-12','121.212.121-23','12312-301','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio13',479),(33,45,'abc teste','(11)11111-1111','1111-11-11','405.241.538-84','11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123),(34,46,'asdasdasdasd','(11)11111-1111','1111-11-11','406.748.298-16','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',300);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
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
  `CEP` varchar(9) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CPF` (`CPF`),
  KEY `lavador_usuario` (`id_usuario`),
  CONSTRAINT `lavador_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lavador`
--

LOCK TABLES `lavador` WRITE;
/*!40000 ALTER TABLE `lavador` DISABLE KEYS */;
INSERT INTO `lavador` VALUES (1,14,'2017-05-07','lavador joao','(11)11111-1111','1111-11-11','111.111.111-11','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(2,15,'2017-05-07','lavadora maria','(22)22222-2222','1516-10-22','111.111.111-13','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',366),(3,16,'2017-05-07','lavador pedro','(12)12121-2121','1999-12-12','124.578.451-22','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(4,17,'2017-05-07','lavador jose','(54)65465-4654','1971-01-01','354.654.654-65','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',123),(5,18,'2017-05-17','lavador antonio','(11)23321-3213','2000-12-12','123.123.213-21','08745-112','SP','Mogi das Cruzes123','Vila Bela Flor123','Avenida Santo Antônio123',1232),(6,19,'2017-05-17','lavador tiago','(21)68154-8154','1980-01-01','123.123.123-12','12312-300','SP','Jacareí123','Cidade Salvador123','Rua Mabito Shoji123',12312),(7,20,'2017-05-28','lavador davi','(11)90909-0909','1989-07-16','123.435.382-76','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',12345),(8,21,'2017-05-28','lavadora ana','(11)90909-0909','1989-07-16','123.435.382-77','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',23456),(9,22,'2017-05-28','lavadora cristiane','(11)90909-0909','1989-07-16','123.435.382-78','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',34567),(10,23,'2017-05-28','lavadora julia','(11)90909-0909','1989-07-16','123.435.382-79','08745-310','SP','Mogi das Cruzes','Vila Bela Flor','Avenida Santo Antônio',45678),(11,51,'2017-10-08','abc teste','(11)11111-1111','1970-01-01','405.241.538-84','11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123),(13,53,'2017-10-08','abc','(11)11111-1111','1111-11-11','705.727.540-43','11702-530','SP','Praia Grande','Aviação','Avenida General Marcondes Salgado',123);
/*!40000 ALTER TABLE `lavador` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Limpa Estofados A Seco 5 Litros - Vonixx','Limpa, tira manchas e deixa um agradável aroma',1),(2,'Cristalizador De Vidros','500ml - Braclean',1),(3,'Kit Lavagem','A Seco 500ml + Toalha Microfibra - Braclean',1),(4,'Shampoo Detergente','Automotivo Lave Seco 500ml - Mills',1),(5,'Cristalizador De Vidros','Cristalizador De Vidros 500ml - Mills',1),(6,'Pano','Microfibra 50x60cm - Alcance',1),(7,'Bio W Lavagem','A Seco Concentrado 1 Litro Até 1:50 - Alcance',1),(8,'Auto Lava Seco',' 5 Litros - 3M',1),(9,'Limpeza De Rodas E Motores','Bio W - Alcance',1),(10,'Lavagem A Seco 5 Litros','Ecoflex Ultra - Vonixx',1),(11,'teste','teste',0);
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
INSERT INTO `servico` VALUES (1,'Aspiração completa','Aspiração completa do veículo.',20.00,1),(2,'Lavagem a Seco Externa simples','Limpeza externa simples do veículo.',30.00,1),(3,'Lavagem a Seco Interna simples','Limpeza interior simples do veículo.',20.00,1),(4,'Lavagem a Seco Externa completa','Limpeza externa completa do veículo.',50.00,1),(5,'Lavagem a Seco Interna completa','Limpeza interior completa do veículo.',35.00,1),(6,'Cristalização','Cristalização externa do veículo.',110.00,1),(7,'Higienização','Higienização interior do veículo.',30.00,1),(8,'Lavagem de Motor','Lavagem de Motor',49.99,1),(9,'Enceramento','Camada de proteção e brilho por mais tempo.',99.99,1),(10,'Polimento ','Some com as manchas, riscos e imperfeições na pintura.',259.99,1);
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
INSERT INTO `servico_produtos` VALUES (1,1,2),(1,2,4),(1,3,1),(2,2,4),(2,3,2),(2,6,4),(3,3,1),(3,5,1),(3,6,2),(4,1,4),(4,3,3),(4,4,5),(5,1,1),(5,5,2),(5,9,1),(6,1,2),(6,2,4),(6,3,1),(7,2,4),(7,3,2),(7,6,4),(8,3,1),(8,5,1),(8,6,2),(9,1,4),(9,3,3),(9,4,5),(10,1,1),(10,5,2),(10,9,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacao`
--

LOCK TABLES `solicitacao` WRITE;
/*!40000 ALTER TABLE `solicitacao` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ricardo@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42',1),(2,'rodrigo@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:42',1),(3,'renan@icarwash.com','d033e22ae348aeb5660fc2140aec35850c4da997',3,1,'2017-03-25 13:36:43',1),(4,'joao@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 17:21:10',1),(5,'pedro@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 19:40:38',1),(6,'maria@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-06 20:26:04',1),(7,'jose@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:06:07',1),(8,'antonio@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 01:16:32',1),(9,'tiago@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:49:31',1),(10,'davi@hotmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:50:02',1),(11,'ana@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:05',1),(12,'cristiane@yahoo.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:51:28',1),(13,'julia@gmail.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',1,1,'2017-05-07 08:52:38',1),(14,'lavadorjoao@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-07 08:53:05',1),(15,'lavadoramaria@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:08',1),(16,'lavadorpedro@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-15 19:52:59',1),(17,'lavadorjose@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,1,'2017-05-17 20:34:45',1),(18,'lavadorantonio@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:08:43',1),(19,'lavadortiago@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:35:20',1),(20,'lavadordavi@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:37:54',1),(21,'lavadoraana@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-28 14:43:00',1),(22,'lavadorcristiane@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:37:54',1),(23,'lavadorjulia@icarwash.com','40bd001563085fc35165329ea1ff5c5ecbdbbeef',2,0,'2017-05-17 21:37:54',1),(45,'c20@c20.com','8cb2237d0679ca88db6464eac60da96345513964',1,0,'2017-10-08 20:38:33',1),(46,'c123@c123.com','8cb2237d0679ca88db6464eac60da96345513964',1,1,'2017-10-08 21:09:34',0),(51,'l21@l21.com','8cb2237d0679ca88db6464eac60da96345513964',2,1,'2017-10-08 21:35:54',0),(53,'c20asas@com','8cb2237d0679ca88db6464eac60da96345513964',2,1,'2017-10-08 21:44:01',0);
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

-- Dump completed on 2017-10-08 22:57:21
