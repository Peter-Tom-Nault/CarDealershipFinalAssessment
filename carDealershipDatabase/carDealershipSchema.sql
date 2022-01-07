-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 07, 2022 at 05:01 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cardealership`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounttypes`
--

DROP TABLE IF EXISTS `accounttypes`;
CREATE TABLE IF NOT EXISTS `accounttypes` (
  `accountTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `accountType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`accountTypeId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounttypes`
--

INSERT INTO `accounttypes` (`accountTypeId`, `accountType`) VALUES
(1, 'admin'),
(2, 'salesperson');

-- --------------------------------------------------------

--
-- Table structure for table `contactinformation`
--

DROP TABLE IF EXISTS `contactinformation`;
CREATE TABLE IF NOT EXISTS `contactinformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `message` mediumtext DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactinformation`
--

INSERT INTO `contactinformation` (`id`, `firstName`, `lastName`, `message`, `email`, `phone`) VALUES
(1, 'Alyssa', 'Moses', 'sit amet nulla. Donec', 'risus@outlook.net', 438525246),
(2, 'Stone', 'Sargent', 'metus urna convallis erat, eget tincidunt dui augue eu tellus.', 'natoque.penatibus.et@google.net', 451521244),
(3, 'Garrett', 'Farley', 'imperdiet nec, leo. Morbi neque tellus, imperdiet non,', 'mauris@google.couk', 568555125),
(4, 'Quinn', 'Fields', 'eu nibh vulputate mauris sagittis placerat.', 'praesent.eu.dui@yahoo.com', 745151122),
(5, 'Winter', 'Oneal', 'sem, vitae aliquam eros turpis non enim. Mauris quis turpis', 'nec.tempus.mauris@outlook.edu', 785152542);

-- --------------------------------------------------------

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE IF NOT EXISTS `manufacturer` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manufacturer`
--

INSERT INTO `manufacturer` (`id`, `name`, `country`) VALUES
(1, 'Benz', 'Germany'),
(2, 'BMW', 'Germany'),
(3, 'Lamborghini', 'Italy'),
(4, 'Land Rover', 'Italy'),
(5, 'Bentley', 'England'),
(6, 'Lamborghini', 'Italy'),
(7, 'Bugatti', 'France'),
(9, 'Chevrolet', 'America'),
(10, 'Dodge', 'America'),
(11, 'Fiat', 'Italy'),
(12, 'Lamborghini', 'Italy'),
(13, 'Maserati', 'Italy'),
(14, 'Abarth', 'Italy'),
(15, 'Alfa Romeo', 'Italy'),
(16, 'Datsun', 'Japan'),
(17, 'Jeep', 'America'),
(18, 'Kia', 'South Korea'),
(19, 'Lexus', 'Japan'),
(20, 'Porsche', 'Germany'),
(21, 'Tesla', 'America'),
(22, 'Toyota', 'Japan'),
(23, 'Nissan', 'Japan'),
(24, 'Mazda', 'Japan'),
(25, 'Volkswagen', 'Germany'),
(26, 'Mitsubishi', 'Japan');

-- --------------------------------------------------------

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
CREATE TABLE IF NOT EXISTS `model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modelName` varchar(255) DEFAULT NULL,
  `trim` varchar(255) DEFAULT NULL,
  `make` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `make` (`make`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `model`
--

INSERT INTO `model` (`id`, `modelName`, `trim`, `make`) VALUES
(1, '500', 'trim1', 1),
(2, '1000', 'trim2', 2),
(3, '560', 'trim3', 1);

-- --------------------------------------------------------

--
-- Table structure for table `optionalfeature`
--

DROP TABLE IF EXISTS `optionalfeature`;
CREATE TABLE IF NOT EXISTS `optionalfeature` (
  `featureId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`featureId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `optionalfeature`
--

INSERT INTO `optionalfeature` (`featureId`, `name`) VALUES
(1, 'Smartphone Integration'),
(2, 'Adaptive Cruise Control'),
(3, 'Smartphone Integration');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE IF NOT EXISTS `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `VIN` varchar(17) DEFAULT NULL,
  `salespersonId` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `purchasePrice` decimal(10,2) DEFAULT NULL,
  `customerName` varchar(255) DEFAULT NULL,
  `streetAddress` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `salespersonId` (`salespersonId`),
  KEY `VIN` (`VIN`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`id`, `VIN`, `salespersonId`, `date`, `purchasePrice`, `customerName`, `streetAddress`, `city`, `state`, `zip`, `email`) VALUES
(1, '14414AS45505AS', 1, '2020-12-10', '60000.61', 'Basil Mcgowan', 'P.O. Box 250, 3651 Urna. Av.', 'Urna', 'AZ', 40207, 'mus.aenean@aol.couk'),
(2, '15151SDAQW515', 2, '2021-12-10', '27000.25', 'Keegan Durham', 'St 7', 'P.O. Box 429, 8198 Est. Ave', 'TX', 54321, 'duis.mi.enim@icloud.org'),
(3, '4751SDAA131QW', 1, '2021-12-09', '75000.25', 'Mira Mullins', '454-7349 Sociosqu Rd.', 'New York', 'New York State', 3347, 'nunc.ullamcorper@aol.couk'),
(4, '02101796ASWFF', 2, '2020-12-09', '56000.25', 'Ali Chase', 'Ap #530-5638 Dolor St', 'Calbuco', 'CA', 33487, 'in@protonmail.org'),
(5, '4700DAA131QW5', 2, '2021-08-07', '45000.95', 'Axel Best', 'Ap #813-2663 Lorem St.', 'New York', 'New York State', 334547, 'ipsum@protonmail.edu'),
(6, '580343ASQ8783', 1, '2020-11-02', '52000.45', 'Haviva Bernard', '2096 Mattis Street', 'Arequipa', 'California', 586554, 'magna.a@hotmail.ca');

-- --------------------------------------------------------

--
-- Table structure for table `special`
--

DROP TABLE IF EXISTS `special`;
CREATE TABLE IF NOT EXISTS `special` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` mediumtext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `special`
--

INSERT INTO `special` (`id`, `description`) VALUES
(1, 'Unsold Cars & Vehicles - Get Approved From Home\r\nStep 1 - We Find You A Great Deal. Step 2 - Financing Approved. Step 3 - You Get Your Car. Apply Now - Instant Pre-approval - Affordable Financing Regardless Of Your Credit Score. Online Pre-Approvals. Canada - Wide Approvals. Financing Available. 24/7 Support.'),
(2, '0 Down Car Deals - Vehicle Financing Pre-Approval\r\nFind your credit profile and loan pre-approval and save 45 minutes at the dealership. Get financing options, interest rates & be connected with a reputable dealer nearby. Buy a car smarter and faster with AutoVerify. Request A Demo. Click the button below.'),
(3, 'Pick a Car, Pick a Payment - Free Door-to-Door Delivery\r\neCarmony makes Car-Buying Easy and Online. Pick a Car and Get Started. Online At-Home Car-Buying is the Future thanks to eCarmony. Pick a Car to Get Started. Vehicle Selection. We Deliver. Credit Rebuilding Program. Any Credit Accepted.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `accountType` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username` (`username`),
  KEY `accountType` (`accountType`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `username`, `accountType`, `password`, `email`) VALUES
(5, 'Noelle', 2, 'JKX71OCL2KR', 'risus.odio@google.edu'),
(4, 'Yoshi', 1, 'PUU16QPL3LU', 'imperdiet.dictum@google.couk'),
(6, 'Allistair', 2, 'CHE67NIH7XD', 'orci.phasellus@aol.com'),
(7, 'Anastasia', 1, 'KPE98TOH8VP', 'lacinia.at@aol.org'),
(8, 'Amit', 2, 'STS12NZC6EL', 'dolor.donec@google.ca');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `VIN` varchar(17) NOT NULL,
  `modelID` int(11) DEFAULT NULL,
  `modelYear` int(11) DEFAULT NULL,
  `exteriorColor` varchar(255) DEFAULT NULL,
  `interiorColor` varchar(255) DEFAULT NULL,
  `bodytype` varchar(255) DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  `msrp` decimal(10,2) DEFAULT NULL,
  `saleprice` decimal(10,2) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `mileage` int(11) DEFAULT NULL,
  `description` mediumtext DEFAULT NULL,
  `purchased` tinyint(1) DEFAULT NULL,
  `featured` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`VIN`),
  KEY `modelID` (`modelID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`VIN`, `modelID`, `modelYear`, `exteriorColor`, `interiorColor`, `bodytype`, `transmission`, `msrp`, `saleprice`, `photo`, `mileage`, `description`, `purchased`, `featured`) VALUES
('14414AS45505AS', 1, 2020, 'blue', 'black', 'SUV', 'Automatic', '123.25', '25000.65', '1.png', 1200, 'A wide range of engines has been used experimentally and in automotive production.', 0, 1),
('15151SDAQW515', 2, 2021, 'black', 'white', 'Sedan', 'Manual', '456.25', '15000.65', '2.png', 500, 'Automotive body designs are frequently categorized according to the number of doors, the arrangement of seats, and the roof structure. ', 0, 0),
('4751SDRT131QW', 3, 2019, 'white', 'yellow', 'Sedan', 'Automatic', '12.25', '65000.65', '4.jpg', 2000, 'New technical developments are recognized to be the key to successful competition.', 1, 0),
('580343ASQ8783', 3, 2018, 'red', 'green', 'SUV', 'Manual', '125.25', '22000.45', '6.jpg', 200, 'Passenger cars have emerged as the primary means of family transportation, with an estimated 1.4 billion in operation worldwide', 1, 0),
('590QSASQ8783', 1, 2019, 'white', 'black', 'Convertible', 'Semi-automatic', '78000.99', '75000.99', '3.png', 500, 'The technology of the car industry is rapidly evolving. The vehicles of today are getting smarter, safer, and can intuitively adapt to their surroundings', 0, 1),
('890HJASQ8747', 2, 2020, 'white', 'brown', 'Sports Car', 'Semi-automatic', '58000.99', '55200.99', '9.png', 2000, ' Adaptive Cruise Control and Automatic Emergency Braking', 1, 0),
('811HJASQ8783', 3, 2021, 'blue', 'brown', 'Sports Car', 'Automatic', '75000.99', '65500.99', '7.png', 1200, ' Navigation Systems & Smartphone Integration', 0, 0),
('812HJASQ8552', 3, 2021, 'red', 'black', 'Sedan', 'Automatic', '78000.99', '75500.99', '8.png', 200, ' Heated and Ventilated Seats', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `vehicleoptional`
--

DROP TABLE IF EXISTS `vehicleoptional`;
CREATE TABLE IF NOT EXISTS `vehicleoptional` (
  `vehicleVin` varchar(255) NOT NULL,
  `featureId` int(11) NOT NULL,
  PRIMARY KEY (`vehicleVin`,`featureId`),
  KEY `featureId` (`featureId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicleoptional`
--

INSERT INTO `vehicleoptional` (`vehicleVin`, `featureId`) VALUES
('02101796ASWFF', 1),
('14414AS45505AS', 1),
('15151SDAQW515', 2),
('4700DAA131QW5', 3),
('4751SDAA131QW', 1),
('580343ASQ8783', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
