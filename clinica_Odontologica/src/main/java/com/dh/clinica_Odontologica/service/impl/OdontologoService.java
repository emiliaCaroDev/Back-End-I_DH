package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Odontologo;
import com.dh.clinica_Odontologica.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OdontologoService implements IOdontologoService {

    private final IDAO<Odontologo> odontologoDao;

    public OdontologoService(IDAO<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

   /*public OdontologoService(){}*/

    @Override
    public List<Odontologo> listarTodosOdontologos() {

        return odontologoDao.listarTodos();
    }

    @Override
    public Odontologo buscarOdontologoXId(Integer id) {
        return odontologoDao.buscarXId(id);
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);
    }

    @Override
    public void eliminarOdontologo(Integer id) {
        odontologoDao.eliminar(id);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoDao.actualizar(odontologo);
    }
}
