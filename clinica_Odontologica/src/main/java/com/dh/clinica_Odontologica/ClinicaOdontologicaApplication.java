package com.dh.clinica_Odontologica;

import com.dh.clinica_Odontologica.conexion.DDBB;
import com.dh.clinica_Odontologica.dao.impl.OdontologoDAOH2;
import com.dh.clinica_Odontologica.dao.impl.PacienteDAOH2;
import com.dh.clinica_Odontologica.dao.impl.TurnoDAO;
import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.domain.Paciente;
import com.dh.clinica_Odontologica.domain.Turno;
import com.dh.clinica_Odontologica.service.impl.OdontologoService;
import com.dh.clinica_Odontologica.service.impl.PacienteService;
import com.dh.clinica_Odontologica.service.impl.TurnoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		DDBB.crearDB();

		Domicilio domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
		Paciente paciente = new Paciente(888888, "Paz","Santiago", LocalDate.of(2022,11,3),"santi@gmail.com", domicilio);

		Domicilio domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
		Paciente paciente1 = new Paciente(999999,"Perez", "Micaela", LocalDate.of(2021,12,5), "mika@gmail.com",domicilio1);

		PacienteService pacienteService= new PacienteService(new PacienteDAOH2());
		pacienteService.guardarPaciente(paciente1);
		pacienteService.guardarPaciente(paciente);

		Odontologo odontologo1=new Odontologo("348971960","Ramirez", "Juan");
		Odontologo odontologo2= new Odontologo("215478","Mendez","Pedro");
		Odontologo odontologo3= new Odontologo("14578","Puentes","Ignacio");
		OdontologoService odontologoService= new OdontologoService(new OdontologoDAOH2());
		odontologoService.guardarOdontologo(odontologo1);
		odontologoService.guardarOdontologo(odontologo2);
		odontologoService.guardarOdontologo(odontologo3);


		Turno turno1= new Turno(1,paciente1,odontologo3,LocalDate.of(2022,10,2));
		Turno turno2= new Turno(2,paciente,odontologo2,LocalDate.of(2022,9,3));
		TurnoService turnoService= new TurnoService(new TurnoDAO());
		turnoService.guardarTurno(turno1);
		turnoService.guardarTurno(turno2);


	}

}
