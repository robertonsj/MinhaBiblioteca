-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_meuslivros
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_assuntos`
--

DROP TABLE IF EXISTS `tb_assuntos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_assuntos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `assunto` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_assuntos`
--

LOCK TABLES `tb_assuntos` WRITE;
/*!40000 ALTER TABLE `tb_assuntos` DISABLE KEYS */;
INSERT INTO `tb_assuntos` VALUES (1,'Linguagem de Programação'),(2,'Banco de Dados'),(3,'Lingua inglesa'),(4,'Outros TI'),(5,'Sátira');
/*!40000 ALTER TABLE `tb_assuntos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_autores`
--

DROP TABLE IF EXISTS `tb_autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_autores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `nacionalidade` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_autores`
--

LOCK TABLES `tb_autores` WRITE;
/*!40000 ALTER TABLE `tb_autores` DISABLE KEYS */;
INSERT INTO `tb_autores` VALUES (1,'Kathy Sierra','americana'),(2,'Bert Bates','americano'),(3,'Marcos Martins','brasileiro'),(4,'Chris Date','britânico'),(5,'Raymond Murphy','americano'),(6,'Mayb Andrade','brasileira'),(8,'Eric Matthes','canadense');
/*!40000 ALTER TABLE `tb_autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_editoras`
--

DROP TABLE IF EXISTS `tb_editoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_editoras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(70) NOT NULL,
  `cnpj` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_editoras`
--

LOCK TABLES `tb_editoras` WRITE;
/*!40000 ALTER TABLE `tb_editoras` DISABLE KEYS */;
INSERT INTO `tb_editoras` VALUES (1,'Atlas','111'),(2,'Érica','333'),(3,'OReilly','555'),(4,'Elsevier','777'),(5,'Cambridge Univerity Press','999'),(7,'Companhia das Letras','1515'),(8,'Novatec Editora','1717');
/*!40000 ALTER TABLE `tb_editoras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_livros`
--

DROP TABLE IF EXISTS `tb_livros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_livros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `data_public` date DEFAULT NULL,
  `preco` decimal(5,2) DEFAULT NULL,
  `num_pag` int DEFAULT NULL,
  `assunto_id` int NOT NULL,
  `editora_id` int NOT NULL,
  `ISBN` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ISBN` (`ISBN`),
  KEY `assunto_id` (`assunto_id`),
  KEY `editora_id` (`editora_id`),
  CONSTRAINT `tb_livros_ibfk_1` FOREIGN KEY (`assunto_id`) REFERENCES `tb_assuntos` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tb_livros_ibfk_2` FOREIGN KEY (`editora_id`) REFERENCES `tb_editoras` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_livros`
--

LOCK TABLES `tb_livros` WRITE;
/*!40000 ALTER TABLE `tb_livros` DISABLE KEYS */;
INSERT INTO `tb_livros` VALUES (13,'Head First Java','2005-02-19',366.60,688,1,3,'222'),(14,'English Grammar In Use','2010-01-01',104.30,688,3,5,'444'),(16,'Sistemas de Banco de Dados','2021-01-27',281.69,1419,2,4,'666'),(17,'Teste de Software','2010-05-22',55.60,143,4,1,'888'),(18,'Intensivo de Python','2017-08-21',92.11,685,1,8,'1010');
/*!40000 ALTER TABLE `tb_livros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_livrosautores`
--

DROP TABLE IF EXISTS `tb_livrosautores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_livrosautores` (
  `autor_id` int NOT NULL,
  `livro_id` int NOT NULL,
  PRIMARY KEY (`autor_id`,`livro_id`),
  KEY `livro_id` (`livro_id`),
  CONSTRAINT `tb_livrosautores_ibfk_1` FOREIGN KEY (`autor_id`) REFERENCES `tb_autores` (`id`),
  CONSTRAINT `tb_livrosautores_ibfk_2` FOREIGN KEY (`livro_id`) REFERENCES `tb_livros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_livrosautores`
--

LOCK TABLES `tb_livrosautores` WRITE;
/*!40000 ALTER TABLE `tb_livrosautores` DISABLE KEYS */;
INSERT INTO `tb_livrosautores` VALUES (1,13),(2,13),(5,14),(4,16),(3,17);
/*!40000 ALTER TABLE `tb_livrosautores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-15 16:33:28
