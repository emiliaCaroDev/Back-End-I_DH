package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.conexion.DDBB;
import com.dh.clinica_Odontologica.dao.impl.DomicilioDAOH2;
import com.dh.clinica_Odontologica.domain.Domicilio;
import org.junit.jupiter.api.*;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DomicilioServiceTest {

    private DomicilioService domicilioService;
    private Domicilio domicilio;
    private Domicilio domicilio1;

    @BeforeAll
    void crearTablasDB(){
        DDBB.crearDB();
    }

    @BeforeEach
    void inicializar(){
        domicilioService= new DomicilioService(new DomicilioDAOH2());
        domicilio = new Domicilio("Av Avellaneda", 333, "CABA", "Buenos Aires");
        domicilio1= new Domicilio("Av Santa fe", 444, "CABA", "Buenos Aires");
    }

    @Order(4)
    @Test
    void listarTodosDomicilio() {
        assertTrue(domicilioService.listarTodosDomicilio().size()>0);
        for(Object domicilio: domicilioService.listarTodosDomicilio()){
            System.out.println(domicilio.toString());
        }
    }

    @Order(2)
    @Test
    void buscarDomicilioXId() {
        assertNotNull(domicilioService.buscarDomicilioXId(1));
    }

    @Order(1)
    @Test
    void guardarDomicilio() {
        domicilioService.guardarDomicilio(domicilio);
        assertNotNull(domicilioService.guardarDomicilio(domicilio1));
    }


    @Order(3)
    @Test
    void eliminarDomicilio(){
        domicilioService.eliminarDomicilio(2);
        assertNull(domicilioService.buscarDomicilioXId(2));
    }
}