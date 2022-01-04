drop database if exists carDealership;
create database carDealership;

use carDealership;

CREATE TABLE `Vehicle` (
  `VIN` varchar(17) PRIMARY KEY NOT NULL unique,
  `makeID` mediumint,
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
  `description` mediumtext
);

CREATE TABLE `manufacturer` (
  `id` mediumint PRIMARY KEY NOT NULL auto_increment,
  `name` varcharacter(255),
  `country` varcharacter(255)
);

CREATE TABLE `model` (
  `id` int PRIMARY KEY NOT NULL auto_increment,
  `modelName` varcharacter(255),
  `trim` varcharacter(255)
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
  `password` varchar(255)
);

CREATE TABLE `accountTypes` (
  `accountTypeId` int PRIMARY KEY auto_increment,
  `accountType` varcharacter(255)
);

ALTER TABLE `Vehicle` ADD FOREIGN KEY (`makeID`) REFERENCES `manufacturer` (`id`);

ALTER TABLE `Vehicle` ADD FOREIGN KEY (`modelID`) REFERENCES `model` (`id`);

ALTER TABLE `user` ADD FOREIGN KEY (`accountType`) REFERENCES `accountTypes` (`accountTypeId`);

Alter table `vehicleOptional` add primary key (`vehicleVin`, `featureId`);

ALTER TABLE `vehicleOptional` ADD FOREIGN KEY (`vehicleVin`) REFERENCES `Vehicle` (`VIN`);

ALTER TABLE `vehicleOptional` ADD FOREIGN KEY (`featureId`) REFERENCES `optionalFeature` (`featureId`);
