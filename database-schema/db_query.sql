drop database pcas;
create database pcas;
use pcas;

create table hospital(
hospital_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
address VARCHAR(45) NOT NULL,
cnpj VARCHAR(45) NOT NULL,
localization VARCHAR(45) NOT NULL,
occupancy_rate FLOAT NOT NULL
) ENGINE = innodb;

create table hospital_resource(
resource_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
quantity INTEGER NOT NULL,
hospital_id BIGINT,
FOREIGN KEY(hospital_id) REFERENCES hospital(hospital_id)
) ENGINE = innodb;

SELECT * FROM hospital;
SELECT * FROM hospital_resource;