drop database if exists carDealership;
create database carDealership;

use carDealership;

CREATE TABLE `Vehicle` (
  `VIN` varchar(17) PRIMARY KEY NOT NULL unique,
  `modelID` int,
  `modelYear` int,
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
`description` mediumtext
);


create table `contactInformation` (
`id` int primary key auto_increment,
`firstName` varChar(50),
`lastName` varChar(50),
`message` mediumtext,
`email` varchar(255),
`phone` int
);

create table `purchase` (
`id` int primary key auto_increment,
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

ALTER TABLE `purchase` add foreign key (`salespersonId`) references `user` (`userId`);

ALTER TABLE `purchase` add foreign key (`VIN`) references `Vehicle` (`VIN`);


INSERT INTO accounttypes(accountType) values('admin');
INSERT INTO accounttypes(accountType) values('salesperson');

INSERT INTO manufacturer(`name`, `country`) values('Benz', 'Germany');
INSERT INTO manufacturer(`name`, `country`) values('BMW', 'Germany');

INSERT INTO model(`modelName`, `trim`, `make`) values('500', 'trim1', '1');
INSERT INTO model(`modelName`, `trim`, `make`) values('1000', 'trim2', '2');
INSERT INTO model(`modelName`, `trim`, `make`) values('560', 'trim3', '1');

INSERT INTO optionalfeature(`name`) values('feature1');
INSERT INTO optionalfeature(`name`) values('feature2');
INSERT INTO optionalfeature(`name`) values('feature3');

INSERT INTO user(`username`, `accountType`, `password`, `email`) values('user1', 1, '12345', 'user1@gmail.com');
INSERT INTO user(`username`, `accountType`, `password`, `email`) values('user2', 2, '54321', 'user2@gmail.com');
INSERT INTO user(`username`, `accountType`, `password`, `email`) values('user3', 2, '98765', 'user3@gmail.com');

INSERT INTO vehicle(`VIN`, `modelID`, `modelYear`, `exteriorColor`, `interiorColor`, `bodytype`, `transmission`, `msrp`, `saleprice`, `photo`, `mileage`, `description`, `purchased`, `featured`) values('1234khjg12341', 1, 2020, 'blue', 'black', 'bodytype1', 'transmission1', 123.25, 25000.65, 'g.jpg', 1200, 'You Dont believe it1', false, true);
INSERT INTO vehicle(`VIN`, `modelID`, `modelYear`, `exteriorColor`, `interiorColor`, `bodytype`, `transmission`, `msrp`, `saleprice`, `photo`, `mileage`, `description`, `purchased`, `featured`) values('4321xcds12341', 2, 2021, 'black', 'white', 'bodytype2', 'transmission2', 456.25, 15000.65, 'h.jpg', 500, 'You Dont believe it2', false, false);
INSERT INTO vehicle(`VIN`, `modelID`, `modelYear`, `exteriorColor`, `interiorColor`, `bodytype`, `transmission`, `msrp`, `saleprice`, `photo`, `mileage`, `description`, `purchased`, `featured`) values('5555khjg12341', 3, 2019, 'white', 'yellow', 'bodytype3', 'transmission3', 12.25, 65000.65, 'i.jpg', 2000, 'You Dont believe it3', true, false);
INSERT INTO vehicle(`VIN`, `modelID`, `modelYear`, `exteriorColor`, `interiorColor`, `bodytype`, `transmission`, `msrp`, `saleprice`, `photo`, `mileage`, `description`, `purchased`, `featured`) values('5555khjg55555', 3, 2018, 'red', 'green', 'bodytype1', 'transmission2', 125.25, 22000.45, 'l.jpg', 200, 'You Dont believe it4', true, false);

INSERT INTO vehicleoptional(`vehiclevin`, `featureId`) values('1234khjg12341', 1);
INSERT INTO vehicleoptional(`vehiclevin`, `featureId`) values('1234khjg12341', 2);
INSERT INTO vehicleoptional(`vehiclevin`, `featureId`) values('4321xcds12341', 3);
INSERT INTO vehicleoptional(`vehiclevin`, `featureId`) values('4321xcds12341', 2);
INSERT INTO vehicleoptional(`vehiclevin`, `featureId`) values('4321xcds12341', 1);
INSERT INTO vehicleoptional(`vehiclevin`, `featureId`) values('5555khjg12341', 1);

INSERT INTO special(`description`) values('15% discount on everything');
INSERT INTO special(`description`) values('25% discount on everything');
INSERT INTO special(`description`) values('35% discount on everything');

INSERT INTO purchase(`VIN`, `salespersonId`, `date`, `purchasePrice`, `customerName`, `streetAddress`, `city`, `state`, `zip`, `email`) values('5555khjg12341', 1, '2020-12-10', 60000.61, 'someone1', 'street1', 'city1', 'state1', 12345, 'someone1@yahoo.com');
INSERT INTO purchase(`VIN`, `salespersonId`, `date`, `purchasePrice`, `customerName`, `streetAddress`, `city`, `state`, `zip`, `email`) values('5555khjg55555', 2, '2021-12-10', 27000.25, 'someone2', 'street2', 'city2', 'state2', 54321, 'someone2@gmail.com');
