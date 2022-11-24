package com.dh.clinica_Odontologica.dao.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Odontologo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.dh.clinica_Odontologica.dao.impl.PacienteDAOH2.getConnection;

@Component
public class OdontologoDAOH2 implements IDAO<Odontologo> {

    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        try {
            conn = obtenerConnection();
            ps = conn.prepareStatement("INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA,APELLIDO,NOMBRE)VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getApellido());
            ps.setString(3, odontologo.getNombre());

            ps.executeUpdate();
            //id Odontolog generado
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarXId(Integer id) {
        Odontologo odontologo= null;
        try {
            conn=obtenerConnection();
            ps=conn.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            while(rs.next()){
                odontologo= new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {

        List listaOdontologos = new ArrayList<>();
        try {
            conn = obtenerConnection();
            ps = conn.prepareStatement("SELECT * FROM ODONTOLOGOS");
            rs = ps.executeQuery();

            while (rs.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setNumeroMatricula(rs.getString(2));
                odontologo.setApellido(rs.getString(3));
                odontologo.setNombre(rs.getString(4));
                listaOdontologos.add(odontologo);
            }

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaOdontologos;

    }

    @Override
    public void eliminar(Integer id) {
        try {
                conn=obtenerConnection();
                ps=conn.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
                ps.setInt(1,id);
                ps.execute();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    public Odontologo buscarXEmail(String email) {
        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        try {
            conn=obtenerConnection();
            ps=conn.prepareStatement("UPDATE ODONTOLOGOS SET NUMERO_MATRICULA=?,APELLIDO=?,NOMBRE=? WHERE ID=?");
            ps.setString(1,odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getApellido());
            ps.setString(3, odontologo.getNombre());
            ps.setInt(4,odontologo.getId());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    private static Connection obtenerConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");


    }

}
