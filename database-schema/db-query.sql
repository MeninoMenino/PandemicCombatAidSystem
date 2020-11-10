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
quantity INTEGER NOT NULL
) ENGINE = innodb;

create table hospital_resource_join_table(
hospital_fk bigint,
hospital_resource_fk bigint,
FOREIGN KEY(hospital_fk) REFERENCES hospital(hospital_id),
FOREIGN KEY(hospital_resource_fk) REFERENCES hospital_resource(resource_id)
);

create table negotiation(
negotiation_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_first_hospital BIGINT NOT NULL,
id_second_hospital BIGINT NOT NULL,
negotiation_date_time datetime NOT NULL
);

#------------Fixed resources and values------------

create table resources(
name varchar(12) NOT NULL PRIMARY KEY,
value int NOT NULL
);

INSERT INTO resources VALUES("MÉDICO", 3);
INSERT INTO resources VALUES("ENFERMEIRO", 3);
INSERT INTO resources VALUES("RESPIRADOR", 5);
INSERT INTO resources VALUES("TOMÓGRAFO", 12);
INSERT INTO resources VALUES("AMBULÂNCIA", 10);
#--------------------------------------------------


SELECT * FROM hospital;
SELECT * FROM hospital_resource;
SELECT * FROM hospital_resource_join_table;
SELECT * FROM negotiation;
SELECT * FROM resources;