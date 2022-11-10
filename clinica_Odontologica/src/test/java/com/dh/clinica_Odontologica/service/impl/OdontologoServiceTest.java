package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.conexion.DDBB;
import com.dh.clinica_Odontologica.dao.impl.OdontologoDAOH2;
import com.dh.clinica_Odontologica.domain.Odontologo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OdontologoServiceTest {

    private OdontologoService odontologoService;
    private Odontologo odontologo;
    private Odontologo odontologo1;

    @BeforeAll
    void crearTablasDB(){
        DDBB.crearDB();
    }

    @BeforeEach
    void inicializar(){
        odontologoService= new OdontologoService(new OdontologoDAOH2());
        odontologo1=new Odontologo("MP3908","Mendez","Juan Pablo");
        odontologo= new Odontologo("MN10345","Galvan","Jose");

    }
    @Order(2)
    @Test
    void listarTodosOdontologos() {
        assertTrue(odontologoService.listarTodosOdontologos().size()>0);
        for (Object odonotlogo : odontologoService.listarTodosOdontologos()) {
            System.out.println(odonotlogo.toString());
        }
    }

    @Order(3)
    @Test
    void buscarOdontologoXId() {
        assertTrue(odontologoService.buscarOdontologoXId(1)!=null);
    }

    @Order(1)
    @Test
    void guardarOdontologo() {
        assertTrue(odontologoService.guardarOdontologo(odontologo1)!=null);
        assertNotNull(odontologoService.guardarOdontologo(odontologo));
    }
}