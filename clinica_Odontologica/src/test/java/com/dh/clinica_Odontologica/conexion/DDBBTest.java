package com.dh.clinica_Odontologica.conexion;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DDBBTest {


    @Test
    void pruebaObtenerConnection() throws SQLException, ClassNotFoundException {
        DDBB.crearDB();
        assertTrue(DDBB.obtenerConnection()!=null);
    }
}