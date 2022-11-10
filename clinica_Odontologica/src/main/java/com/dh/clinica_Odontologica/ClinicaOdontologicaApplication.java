package com.dh.clinica_Odontologica;

import com.dh.clinica_Odontologica.conexion.DDBB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		DDBB.crearDB();
	}

}
