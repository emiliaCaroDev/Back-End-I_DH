package com.dh.clinica_Odontologica.dao.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Domicilio;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class DomicilioDAOH2 implements IDAO<Domicilio> {

    private static Connection conn= null;
    private static PreparedStatement ps= null;
    private static ResultSet rs=null;
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        try {
            conn=getConnection();
            ps=conn.prepareStatement("INSERT INTO DOMICILIOS(CALLE,NUMERO,LOCALIDAD,PROVINCIA) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2,domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();

            //key generada al guardar el Domicilio en la DDBB
            rs=ps.getGeneratedKeys();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
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
        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        Domicilio domicilio= null;
        try{
            conn=getConnection();
            ps=conn.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID= ?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            while(rs.next()){
                domicilio=new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> listarTodos() {
        List<Domicilio> listaDomicilios= new ArrayList<>();

        try{
            conn=getConnection();
            ps=conn.prepareStatement("SELECT * FROM DOMICILIOS");
            rs=ps.executeQuery();

            while (rs.next()){
                Domicilio domicilio=new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
                listaDomicilios.add(domicilio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaDomicilios;
    }

    @Override
    public void eliminar(Integer id) {
        try {
            conn=getConnection();
            ps=conn.prepareStatement("DELETE FROM DOMICILIOS WHERE ID=?");
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
            try{
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Domicilio buscarXEmail(String email) {
        return null;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        try{
            conn=getConnection();
            ps=conn.prepareStatement("UPDATE DOMICILIOS SET CALLE=?,NUMERO=?,LOCALIDAD=?,PROVINCIA=? WHERE ID=?");
            ps.setString(1,domicilio.getCalle());
            ps.setInt(2,domicilio.getNumero());
            ps.setString(3,domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.setInt(5,domicilio.getId());
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try{
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return domicilio;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test","sa","");
    }
}
