package com.dh.clinica_Odontologica;

import com.dh.clinica_Odontologica.conexion.DDBB;
import com.dh.clinica_Odontologica.dao.impl.OdontologoDAOH2;
import com.dh.clinica_Odontologica.dao.impl.PacienteDAOH2;
import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.domain.Paciente;
import com.dh.clinica_Odontologica.service.impl.OdontologoService;
import com.dh.clinica_Odontologica.service.impl.PacienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		DDBB.crearDB();

		PacienteService pacienteService= new PacienteService(new PacienteDAOH2());
		OdontologoService odontologoService= new OdontologoService(new OdontologoDAOH2());
		Domicilio domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
		Paciente paciente = new Paciente(888888, "Paz","Santiago", LocalDate.of(2022,11,3),"santi@gmail.com", domicilio);
		Domicilio domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
		Paciente paciente1 = new Paciente(999999,"Perez", "Micaela", LocalDate.of(2021,12,5), "mika@gmail.com",domicilio1);
		pacienteService.guardarPaciente(paciente1);
		pacienteService.guardarPaciente(paciente);
		odontologoService.guardarOdontologo(new Odontologo("348971960","Ramirez", "Juan"));
		odontologoService.guardarOdontologo(new Odontologo("215478","Mendez","Pedro"));
		odontologoService.guardarOdontologo(new Odontologo("14578","Puentes","Ignacio"));

	}

}
