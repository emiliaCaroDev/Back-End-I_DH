DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
NUMERO_MATRICULA VARCHAR(50) NOT NULL,
APELLIDO  VARCHAR(100) NOT NULL,
NOMBRE VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS DOMICILIOS;
CREATE TABLE DOMICILIOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CALLE VARCHAR(100) NOT NULL,
NUMERO VARCHAR(100) NOT NULL,
LOCALIDAD VARCHAR(100) NOT NULL,
PROVINCIA VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS PACIENTES;
CREATE TABLE PACIENTES(
ID INT AUTO_INCREMENT PRIMARY KEY,
DNI INT NOT NULL,
APELLIDO VARCHAR(100) NOT NULL,
NOMBRE VARCHAR(100) NOT NULL,
FECHA_INGRESO DATE,
EMAIL VARCHAR(100) NOT NULL,
ID_DOMICILIO INT
);


