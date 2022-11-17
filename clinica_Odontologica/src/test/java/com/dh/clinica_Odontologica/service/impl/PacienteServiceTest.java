package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.conexion.DDBB;
import com.dh.clinica_Odontologica.dao.impl.PacienteDAOH2;
import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.domain.Paciente;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {

    private PacienteService pacienteService;

    private Paciente paciente;
    private Domicilio domicilio;
    private Paciente paciente1;
    private Domicilio domicilio1;

    @BeforeAll
    void crearTablaDB(){
        DDBB.crearDB();
    }

    @BeforeEach
    void inicializar(){
        pacienteService= new PacienteService(new PacienteDAOH2());
        domicilio = new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
        paciente = new Paciente(888888, "Paz","Santiago", LocalDate.of(2022,11,3),"santi@gmail.com", domicilio);
        domicilio1 = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        paciente1 = new Paciente(999999,"Micaela", "Perez", LocalDate.of(2021,12,5), "mika@gmail.com",domicilio1);

    }

    @Order(5)
    @Test
    void listarTodosPacientes() {
        assertTrue(pacienteService.listarTodosPacientes().size()>0);
       for(Object paciente: pacienteService.listarTodosPacientes()){
           System.out.println(paciente.toString());
       }

    }

    @Order(2)
    @DisplayName("Debera devolver un Paciente cuando el email es correcto")
    @Test
    void buscarXEmail() {
        assertTrue(pacienteService.buscarXEmail("santi@gmail.com")!=null);
        System.out.println("paciente encontrado: " +pacienteService.buscarXEmail("santi@gmail.com"));
    }



    @Order(1)
    @Test
    void guardarPaciente(){
        assertTrue(pacienteService.guardarPaciente(paciente)!=null);
        assertTrue(pacienteService.guardarPaciente(paciente1)!=null);
    }

    @Order(3)
    @Test
    void eliminarPaciente(){
        pacienteService.eliminarPaciente(2);
        assertNull(pacienteService.buscarXId(2));
    }

    @Order(4)
    @Test
    void actualizarPaciente(){
        pacienteService.actualizarPaciente(paciente);
    }
}