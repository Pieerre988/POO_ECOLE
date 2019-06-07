-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 07, 2019 at 05:14 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecole`
--

-- --------------------------------------------------------
--
-- Table structure for table `anneescolaire`
--
DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

--
-- Dumping data for table `anneescolaire`
--

INSERT INTO `anneescolaire` (`ID`) VALUES
(1),
(2);

-- --------------------------------------------------------
--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

--
-- Dumping data for table `discipline`
--

INSERT INTO `discipline` (`ID`, `Nom`) VALUES
(1, 'Poo Java'),
(2, 'Traitement du signal'),
(3, 'Probabilite et Statistique');

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

--
-- Dumping data for table `niveau`
--

INSERT INTO `niveau` (`ID`, `Nom`) VALUES
(1, 'ING1'),
(2, 'ING2'),
(3, 'ING3'),
(4, 'ING4'),
(5, 'ING5');

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) DEFAULT NULL,
  `Prenom` varchar(255) DEFAULT NULL,
  `Type` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`ID`, `Nom`, `Prenom`, `Type`) VALUES
(1, 'Ren', 'William', 0),
(2, 'Talmont', 'Adrien', 0),
(3, 'Philbert', 'Pierre', 0),
(4, 'Segado', 'Jean-Pierre', 1),
(5, 'Mokber', 'Arash', 1),
(6, 'Le Cor', 'Luc', 1);


-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_annee` int(11) DEFAULT NULL,
  `ID_niveau` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_annee) REFERENCES  anneescolaire (ID) ON DELETE CASCADE,
  FOREIGN KEY (ID_niveau) REFERENCES  niveau (ID) ON DELETE CASCADE
) ENGINE=InnoDB;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`ID`, `ID_annee`, `ID_niveau`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 2, 1),
(7, 2, 2),
(8, 2, 3),
(9, 2, 5),
(10, 2, 5);
-- --------------------------------------------------------
--
-- Table structure for table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) DEFAULT NULL,
  `debut` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `ID_annee` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_annee) REFERENCES  anneescolaire (ID) ON DELETE CASCADE
) ENGINE=InnoDB;

--
-- Dumping data for table `trimestre`
--

INSERT INTO `trimestre` (`ID`, `numero`, `debut`, `fin`, `ID_annee`) VALUES
(1, 1, '2018-09-01', '2018-12-31', 1),
(2, 2, '2019-01-01', '2019-03-31', 1),
(3, 3, '2019-04-01', '2019-06-30', 1),
(4, 1, '2019-09-01', '2019-12-31', 2),
(5, 2, '2020-01-01', '2020-03-31', 2),
(6, 3, '2020-04-01', '2020-06-30', 2);



-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_classe` int(11) DEFAULT NULL,
  `ID_eleve` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_classe) REFERENCES classe (ID) ON DELETE CASCADE,
  FOREIGN KEY (ID_eleve) REFERENCES  personne (ID) ON DELETE CASCADE
) ENGINE=InnoDB;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`ID`, `ID_classe`, `ID_eleve`) VALUES
(1, 3, 1),
(2, 5, 2),
(3, 7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Appréciation` varchar(255) NOT NULL DEFAULT 'Aucune.',
  `ID_trimestre` int(11) DEFAULT NULL,
  `ID_inscription` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_trimestre) REFERENCES trimestre (ID) ON DELETE CASCADE,
  FOREIGN KEY (ID_inscription) REFERENCES  inscription (ID) ON DELETE CASCADE
) ENGINE=InnoDB;

--
-- Dumping data for table `bulletin`
--

INSERT INTO `bulletin` (`ID`, `Appréciation`, `ID_trimestre`, `ID_inscription`) VALUES
(1, 'Aucune.', 1, 1),
(2, 'Aucune.', 1, 2),
(3, 'Aucune.', 1, 3),
(4, 'Aucune.', 2, 1),
(5, 'Aucune.', 2, 2),
(6, 'Aucune.', 2, 3),
(7, 'Aucune.', 3, 1),
(8, 'Aucune.', 3, 2),
(9, 'Aucune.', 3, 3);

-- --------------------------------------------------------
--
-- Table structure for table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_classe` int(11) DEFAULT NULL,
  `ID_discipline` int(11) DEFAULT NULL,
  `ID_prof` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_classe) REFERENCES  classe (ID) ON DELETE CASCADE,
  FOREIGN KEY (ID_discipline) REFERENCES  discipline (ID) ON DELETE CASCADE,
  FOREIGN KEY (ID_prof) REFERENCES personne (ID) ON DELETE CASCADE
) ENGINE=InnoDB;

--
-- Dumping data for table `enseignement`
--

INSERT INTO `enseignement` (`ID`, `ID_classe`, `ID_discipline`, `ID_prof`) VALUES
(1, 1, 1, 4),
(2, 1, 2, 5),
(3, 1, 3, 6);

-- --------------------------------------------------------
--
-- Table structure for table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `appreciation` varchar(255) NOT NULL DEFAULT 'Aucune.',
  `ID_bulletin` int(11) DEFAULT NULL,
  `ID_enseignement` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_bulletin) REFERENCES  bulletin (ID) ON DELETE CASCADE,
  FOREIGN KEY (ID_enseignement) REFERENCES  enseignement (ID) ON DELETE CASCADE
) ENGINE=InnoDB;
--
-- Dumping data for table `detailbulletin`
--

INSERT INTO `detailbulletin` (`ID`, `appreciation`, `ID_bulletin`, `ID_enseignement`) VALUES
(1, 'Aucune.', 1, 1),
(2, 'Aucune.', 1, 2),
(3, 'Aucune.', 1, 3),
(4, 'Aucune.', 2, 1),
(5, 'Aucune.', 2, 2),
(6, 'Aucune.', 2, 3),
(7, 'Aucune.', 3, 1),
(8, 'Aucune.', 3, 2),
(9, 'Aucune.', 3, 3),
(10, 'Aucune.', 4, 1),
(11, 'Aucune.', 4, 2),
(12, 'Aucune.', 4, 3),
(13, 'Aucune.', 5, 1),
(14, 'Aucune.', 5, 2),
(15, 'Aucune.', 5, 3),
(16, 'Aucune.', 6, 1),
(17, 'Aucune.', 6, 2),
(18, 'Aucune.', 6, 3),
(19, 'Aucune.', 7, 1),
(20, 'Aucune.', 7, 2),
(21, 'Aucune.', 7, 3),
(22, 'Aucune.', 8, 1),
(23, 'Aucune.', 8, 2),
(24, 'Aucune.', 8, 3),
(25, 'Aucune.', 9, 1),
(26, 'Aucune.', 9, 2),
(27, 'Aucune.', 9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `note` double DEFAULT NULL,
  `appreciation` varchar(255) NOT NULL DEFAULT 'Aucune.',
  `ID_detailbulletin` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (ID_detailbulletin) REFERENCES  detailbulletin (ID) ON DELETE CASCADE
) ENGINE=InnoDB;

--
-- Dumping data for table `evaluation`
--

INSERT INTO `evaluation` (`ID`, `note`, `appreciation`, `ID_detailbulletin`) VALUES
(1, 0, 'Aucune.', 1),
(2, 10, 'Aucune.', 2),
(3, 20, 'Aucune.', 3),
(4, 0, 'Aucune.', 4),
(5, 10, 'Aucune.', 5),
(6, 20, 'Aucune.', 6),
(7, 0, 'Aucune.', 7),
(8, 10, 'Aucune.', 8),
(9, 20, 'Aucune.', 9),
(10, 0, 'Aucune.', 10),
(11, 10, 'Aucune.', 11),
(12, 20, 'Aucune.', 12),
(13, 0, 'Aucune.', 13),
(14, 10, 'Aucune.', 14),
(15, 20, 'Aucune.', 15),
(16, 0, 'Aucune.', 16),
(17, 10, 'Aucune.', 17),
(18, 20, 'Aucune.', 18),
(19, 0, 'Aucune.', 19),
(20, 10, 'Aucune.', 20),
(21, 20, 'Aucune.', 21),
(22, 0, 'Aucune.', 22),
(23, 10, 'Aucune.', 23),
(24, 20, 'Aucune.', 24),
(25, 0, 'Aucune.', 25),
(26, 10, 'Aucune.', 26),
(27, 20, 'Aucune.', 27);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
