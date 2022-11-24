package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.conexion.DDBB;
import com.dh.clinica_Odontologica.dao.impl.OdontologoDAOH2;
import com.dh.clinica_Odontologica.dao.impl.PacienteDAOH2;
import com.dh.clinica_Odontologica.dao.impl.TurnoDAO;
import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.domain.Paciente;
import com.dh.clinica_Odontologica.domain.Turno;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TurnoServiceTest {

    private OdontologoService odontologoService;
    private PacienteService pacienteService;
    private TurnoService turnoService;

    private Turno turno1;

    private Turno turno2;



    @BeforeAll
    void crearTablaDB(){
        DDBB.crearDB();
    }

    @BeforeEach
    void inicializar(){
        odontologoService= new OdontologoService(new OdontologoDAOH2());
        pacienteService= new PacienteService(new PacienteDAOH2());
        turnoService= new TurnoService(new TurnoDAO());

        Domicilio domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
        Paciente paciente = new Paciente(888888, "Paz","Santiago", LocalDate.of(2022,11,3),"santi@gmail.com", domicilio);

        Domicilio domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        Paciente paciente1 = new Paciente(999999,"Perez", "Micaela", LocalDate.of(2021,12,5), "mika@gmail.com",domicilio1);

        Odontologo odontologo1=new Odontologo("348971960","Ramirez", "Juan");
        Odontologo odontologo2= new Odontologo("215478","Mendez","Pedro");
        Odontologo odontologo3= new Odontologo("14578","Puentes","Ignacio");

        turno1= new Turno(1,paciente1,odontologo3, LocalDate.of(2022,10,2));
        turno2= new Turno(2,paciente,odontologo2,LocalDate.of(2022,9,3));

        pacienteService.guardarPaciente(paciente1);
        pacienteService.guardarPaciente(paciente);

        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.guardarOdontologo(odontologo3);

    }

    @Order(2)
    @Test
    void listarTodosTurnos() {
        assertTrue(turnoService.listarTodosTurnos().size()>0);
        for(Turno turno: turnoService.listarTodosTurnos()){
            System.out.println(turno.toString());
        }
    }

    @Order(1)
    @Test
    void guardarTurno() {
        assertTrue(turnoService.guardarTurno(turno1)!=null);
        assertNotNull(turnoService.guardarTurno(turno2));
    }

    @Test
    void eliminarTurno() {
    }

    @Test
    void buscarTurnoXId() {
    }

    @Test
    void actualizarTurno() {
    }
}