DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS(
ID INT AUTO_INCREMENT PRIMARY KEY,
NUMERO_MATRICULA VARCHAR(50) NOT NULL,
NOMBRE VARCHAR(100) NOT NULL,
APELLIDO VARCHAR(100) NOT NULL
);

INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA,NOMBRE,APELLIDO) VALUES('MP3908','Juan','Mendez');