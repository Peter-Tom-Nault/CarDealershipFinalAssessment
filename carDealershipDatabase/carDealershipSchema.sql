drop database if exists carDealership;
create database carDealership;

use carDealership;

CREATE TABLE `Vehicle` (
  `VIN` varchar(17) PRIMARY KEY NOT NULL unique,
  `modelID` int,
  `modelYear` year,
  `exteriorColor` varcharacter(255),
  `interiorColor` varcharacter(255),
  `bodytype` varcharacter(255),
  `transmission` varcharacter(255),
  `msrp` decimal(10,2),
  `saleprice` decimal(10,2),
  `photo` varchar(255),
  `mileage` int,
  `description` mediumtext,
  `purchased` boolean,
  `featured` boolean
);

CREATE TABLE `manufacturer` (
  `id` mediumint PRIMARY KEY NOT NULL auto_increment,
  `name` varcharacter(255),
  `country` varcharacter(255)
);

CREATE TABLE `model` (
  `id` int PRIMARY KEY NOT NULL auto_increment,
  `modelName` varcharacter(255),
  `trim` varcharacter(255),
  `make` mediumint
);

CREATE TABLE `vehicleOptional` (
  `vehicleVin` varchar(255),
  `featureId` int
);

CREATE TABLE `optionalFeature` (
  `featureId` int PRIMARY KEY auto_increment,
  `name` varcharacter(255)
);



CREATE TABLE `user` (
  `userId` int primary key auto_increment,
  `username` varcharacter(255) unique,
  `accountType` int,
  `password` varchar(255),
  `email` varchar(255)
	
);

CREATE TABLE `accountTypes` (
  `accountTypeId` int PRIMARY KEY auto_increment,
  `accountType` varcharacter(255)
);

CREATE TABLE `special` (
`id` int primary key auto_increment,
`price` decimal(10,2),
`description` mediumtext
);

create table `specialModel` (
`specialId` int,
`modelId` int,
primary key(`specialId`, `modelId`)
);

create table `contactInformation` (
`firstName` varChar(50),
`lastName` varChar(50),
`message` mediumtext,
`email` varchar(255),
`phone` int
);

create table `purchase` (
`VIN` varchar(17),
`salespersonId` int, 
`date` date,
`purchasePrice` decimal (10,2),
`customerName` varchar(255),
`streetAddress` varchar(255),
`city` varchar(255),
`state` varchar(255),
`zip` int,
`email` varchar(255)
);


ALTER TABLE `Vehicle` ADD FOREIGN KEY (`modelID`) REFERENCES `model` (`id`);

ALTER TABLE `user` ADD FOREIGN KEY (`accountType`) REFERENCES `accountTypes` (`accountTypeId`);

Alter table `vehicleOptional` add primary key (`vehicleVin`, `featureId`);

ALTER TABLE `vehicleOptional` ADD FOREIGN KEY (`vehicleVin`) REFERENCES `Vehicle` (`VIN`);

ALTER TABLE `vehicleOptional` ADD FOREIGN KEY (`featureId`) REFERENCES `optionalFeature` (`featureId`);

ALTER TABLE `model` ADD FOREIGN KEY (`make`) REFERENCES `manufacturer` (`id`);

ALTER TABLE `specialModel` ADD FOREIGN KEY (`specialId`) REFERENCES `special` (`id`);

ALTER TABLE `specialModel` ADD FOREIGN KEY (`modelId`) REFERENCES `model` (`id`);

ALTER TABLE `purchase` add foreign key (`salespersonId`) references `user` (`userId`);

ALTER TABLE `purchase` add foreign key (`VIN`) references `Vehicle` (`VIN`);
