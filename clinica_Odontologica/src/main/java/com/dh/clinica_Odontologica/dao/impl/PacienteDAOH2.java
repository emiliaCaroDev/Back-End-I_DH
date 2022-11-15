package com.dh.clinica_Odontologica.dao.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.domain.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class PacienteDAOH2 implements IDAO<Paciente> {

    private static  Connection conn=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs= null;

    private DomicilioDAOH2 domicilioDAOH2;
    private Domicilio domicilio;


    @Override
    public Paciente guardar(Paciente paciente) {

        domicilioDAOH2= new DomicilioDAOH2();
        Domicilio domicilioAGuardar= new Domicilio();
        try {
            conn=getConnection();
            ps=conn.prepareStatement("INSERT INTO PACIENTES(DNI,APELLIDO,NOMBRE,FECHA_INGRESO,EMAIL,ID_DOMICILIO) VALUES(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,paciente.getDNI());
            ps.setString(2,paciente.getApellido());
            ps.setString(3, paciente.getNombre());
            ps.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            ps.setString(5,paciente.getEmail());
            domicilioAGuardar= domicilioDAOH2.guardar(paciente.getDomicilio());
            ps.setInt(6,domicilioAGuardar.getId());
            ps.execute();
            //key generada al guardar paciente en la ddbb
            rs=ps.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
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

        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        Paciente paciente= null;
        DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
        try {
            conn=getConnection();
            ps=conn.prepareStatement("SELECT * FROM PACIENTES WHERE ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            while(rs.next()){
                paciente= new Paciente(rs.getInt(1),rs.getInt(2),rs.getString(3),
                        rs.getString(4),rs.getDate(5).toLocalDate(),rs.getString(6),domicilioDAOH2.buscar(rs.getInt(7)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        List<Paciente> listaPacientes= new ArrayList<>();
        DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
        try {
            conn=getConnection();
            ps=conn.prepareStatement("SELECT * FROM PACIENTES");
            rs=ps.executeQuery();

            while(rs.next()){
                Paciente paciente= new Paciente(rs.getInt(1),rs.getInt(2),rs.getString(3),
                        rs.getString(4),rs.getDate(5).toLocalDate(),rs.getString(6),domicilioDAOH2.buscar(rs.getInt(7)));
                listaPacientes.add(paciente);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPacientes;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            conn=getConnection();
            ps= conn.prepareStatement("DELETE FROM PACIENTES WHERE ID=?");
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
    public Paciente buscarXEmail(String email) {
        Paciente paciente= null;
        DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
        try {
            conn=getConnection();
            ps=conn.prepareStatement("SELECT * FROM PACIENTES WHERE EMAIL=?");
            ps.setString(1,email);
            rs=ps.executeQuery();

            while(rs.next()){
                paciente= new Paciente(rs.getInt(1),rs.getInt(2),rs.getString(3),
                        rs.getString(4),rs.getDate(5).toLocalDate(),rs.getString(6),domicilioDAOH2.buscar(rs.getInt(7)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return paciente;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }
}
