package com.dh.clinica_Odontologica.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DDBB {

    private static Connection conn=null;

    public static void crearDB(){
        try {
            conn=obtenerConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection obtenerConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'src/main/java/com/dh/clinica_Odontologica/create.sql'","sa","");
    }
}
