CREATE DATABASE IF NOT EXISTS clinica;
USE clinica;
DROP TABLE IF EXISTS dentistas;
CREATE TABLE dentistas (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre varchar(225) NOT NULL,
    apellido varchar(255) NOT NULL,
    nro_matricula int NOT NULL
);

