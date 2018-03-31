DROP DATABASE IF EXISTS murraywhiteins;
DROP USER IF EXISTS 'springuser'@'localhost';

CREATE DATABASE murraywhiteins;

CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'password';
GRANT all ON murraywhiteins.* to 'springuser'@'localhost';
USE murraywhiteins;

CREATE TABLE user (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(60) NOT NULL,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

	UNIQUE(email)
);

CREATE TABLE state (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	abbreviation VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE represented_company (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	phone VARCHAR(255) NOT NULL,
	url VARCHAR(255) NOT NULL,
	image VARCHAR(255) NOT NULL,
	sort_order int NULL,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE team_member (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	suffix VARCHAR(255),
	email VARCHAR(255) NOT NULL,
	extension VARCHAR(255),
	position VARCHAR(255),
	qualifications VARCHAR(255),
	description VARCHAR(1023),
	image VARCHAR(255),
	employment_date VARCHAR(255),
	sort_order int NULL,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE testimonial (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	author VARCHAR(255) NOT NULL,
	testimonial VARCHAR(4095) NOT NULL,
	date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	date_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

REVOKE all ON murraywhiteins.* FROM 'springuser'@'localhost';
GRANT select, insert, update, delete ON murraywhiteins.* TO 'springuser'@'localhost';
