-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 11. Feb 2021 um 09:23
-- Server Version: 5.6.14
-- PHP-Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `alien_defence`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `levels`
--

CREATE TABLE IF NOT EXISTS `levels` (
  `P_level_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `background` varchar(100) NOT NULL,
  `duration` int(11) NOT NULL,
  PRIMARY KEY (`P_level_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=4 ;

--
-- Daten für Tabelle `levels`
--

INSERT INTO `levels` (`P_level_id`, `name`, `background`, `duration`) VALUES
(1, 'Level 1', 'background_1.jpg', 10000),
(2, 'Level 2', 'background_2.jpg', 5000),
(3, 'Level 3', 'background_10.jpg', 10000);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `targets`
--

CREATE TABLE IF NOT EXISTS `targets` (
  `P_target_id` int(11) NOT NULL AUTO_INCREMENT,
  `F_level_id` int(11) NOT NULL,
  `x_position` int(11) NOT NULL,
  `y_position` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `image_address` varchar(100) NOT NULL,
  PRIMARY KEY (`P_target_id`),
  KEY `FK LEVELS ID` (`F_level_id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=60 ;

--
-- Daten für Tabelle `targets`
--

INSERT INTO `targets` (`P_target_id`, `F_level_id`, `x_position`, `y_position`, `width`, `height`, `time`, `duration`, `image_address`) VALUES
(40, 1, 100, 100, 150, 50, 1000, 2000, 'ufo_1.png'),
(41, 1, 500, 100, 150, 50, 2000, 2000, 'ufo_2.png'),
(44, 1, 800, 800, 150, 50, 3000, 2000, 'ufo_3.png'),
(51, 1, 600, 400, 150, 50, 4000, 1000, 'ufo_4.png'),
(52, 1, 200, 400, 150, 50, 5000, 1500, 'ufo_5.png'),
(53, 1, 1000, 800, 150, 50, 6000, 1000, 'ufo_3.png'),
(54, 1, 500, 500, 150, 50, 7000, 1000, 'ufo_1.png'),
(55, 2, 600, 400, 150, 50, 1000, 2000, 'ufo_3.png'),
(56, 2, 400, 600, 150, 50, 2000, 2000, 'ufo_2.png'),
(57, 3, 600, 400, 150, 50, 1000, 1000, 'ufo_3.png'),
(58, 3, 600, 400, 150, 50, 6000, 1000, 'ufo_3.png'),
(59, 3, 100, 300, 400, 150, 4000, 1000, 'ufo_3.png');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `attempts`
--

CREATE TABLE IF NOT EXISTS `attempts` (
  `P_attempt_id` int(11) NOT NULL AUTO_INCREMENT,
  `F_user_id` int(11) NOT NULL,
  `F_level_id` int(11) NOT NULL,
  `shots` int(11) NOT NULL,
  `hits` int(11) NOT NULL,
  `reaction_time` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  PRIMARY KEY (`P_attempt_id`),
  KEY `FK PARTICIPANTS ID` (`F_user_id`),
  KEY `FK LEVELS2 ID` (`F_level_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=333 ;

--
-- Daten für Tabelle `attempt`
--

INSERT INTO `attempts` (`P_attempt_id`, `F_user_id`, `F_level_id`, `shots`, `hits`, `reaction_time`, `date`, `time`) VALUES
(278, 1, 3, 3, 2, 2214, '2020-08-15', '09:23:32'),
(279, 1, 3, 3, 3, -942, '2020-08-15', '09:24:04'),
(299, 1, 3, 3, 2, 3533, '2020-08-15', '10:16:46'),
(300, 1, 3, 5, 2, 2451, '2020-08-15', '10:17:21'),
(303, 1, 3, 5, 3, -979, '2020-08-15', '10:32:21'),
(304, 1, 3, 9, 2, 878, '2020-08-15', '10:32:49'),
(313, 1, 2, 2, 1, 571, '2020-08-15', '13:56:01'),
(314, 1, 2, 4, 2, 1101, '2020-08-15', '14:21:01'),
(315, 1, 1, 10, 4, 514, '2020-08-15', '14:21:30'),
(316, 1, 2, 3, 2, 724, '2020-08-15', '14:23:59'),
(317, 1, 2, 0, 0, 0, '2020-08-15', '16:03:36'),
(318, 1, 2, 4, 2, 651, '2020-08-15', '16:23:43'),
(319, 1, 2, 6, 2, 1262, '2020-08-15', '17:09:40'),
(320, 1, 2, 6, 2, 784, '2020-08-15', '17:11:35'),
(321, 1, 2, 3, 1, 1857, '2020-08-15', '17:11:51'),
(322, 1, 1, 7, 6, 1021, '2021-02-09', '10:15:41'),
(323, 1, 1, 6, 6, 664, '2021-02-09', '10:16:19'),
(324, 1, 1, 5, 5, 1000, '2021-02-09', '15:14:03'),
(325, 1, 1, 20, 7, 300, '2021-02-09', '15:14:45'),
(326, 1, 1, 5, 5, 703, '2021-02-09', '15:57:42'),
(327, 1, 1, 0, 0, 0, '2021-02-09', '16:20:42'),
(328, 1, 1, 7, 7, 622, '2021-02-09', '17:37:38'),
(329, 1, 3, 2, 2, -1772, '2021-02-09', '17:37:57'),
(330, 1, 1, 27, 6, 935, '2021-02-10', '15:34:13'),
(331, 1, 1, 7, 7, 660, '2021-02-10', '15:44:01'),
(332, 1, 1, 3, 3, 1013, '2021-02-11', '08:39:39');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `P_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `sur_name` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `street` varchar(100) NOT NULL,
  `house_number` varchar(6) NOT NULL,
  `postal_code` char(5) NOT NULL,
  `city` varchar(100) NOT NULL,
  `login_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salary_expectations` int(100) NOT NULL,
  `marital_status` varchar(100) NOT NULL,
  `final_grade` decimal(3,2) NOT NULL,
  PRIMARY KEY (`P_user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=6 ;

--
-- Daten für Tabelle `users`
--

INSERT INTO `users` (`P_user_id`, `first_name`, `sur_name`, `birthday`, `street`, `house_number`, `postal_code`, `city`, `login_name`, `password`, `salary_expectations`, `marital_status`, `final_grade`) VALUES
(1, 'Mike', 'Leveltester', '2000-10-25', 'Testweg', '1', '10245', 'Berlin', 'test', 'pass', 36000, 'Roboter', '1.00'),
(2, 'MC', 'A', '1998-02-03', 'Brooklynstreet', '2', '10113', 'NYC', 'user', 'pass', 100000, 'ledig', '2.40'),
(3, 'Susanne', 'K�nig', '2001-12-25', 'Hasenweg', '4', '08900', 'Bretnig-Hauswalde', 'susi', 'pass', 20000, 'verheirate', '2.90'),
(4, 'Jan', 'Jonas', '2004-02-29', 'Galihag', '111C', '10317', 'Berlin', 'jan', 'pass', 44444, 'ledig', '1.00'),
(5, 'Felix', 'DelSande', '1985-04-01', 'Lerchenweg', '23', '10245', 'Berlin', 'felix', 'pass', 36000, 'ledig', '3.70');

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `targets`
--
ALTER TABLE `targets`
  ADD CONSTRAINT `FK LEVELS ID` FOREIGN KEY (`F_level_id`) REFERENCES `levels` (`P_level_id`);
  
ALTER TABLE `attempts`
  ADD CONSTRAINT `FK LEVEL ID` FOREIGN KEY (`F_level_id`) REFERENCES `levels` (`P_level_id`);
  
ALTER TABLE `attempts`
  ADD CONSTRAINT `FK USER ID` FOREIGN KEY (`F_user_id`) REFERENCES `users` (`P_user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
