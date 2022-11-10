package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.dao.impl.OdontologoDAOH2;
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

    public OdontologoService(){
        odontologoDao= new OdontologoDAOH2();
    }

    @Override
    public List<Odontologo> listarTodosOdontologos() {

        return odontologoDao.listarTodos();
    }

    @Override
    public Odontologo buscarOdontologoXId(Integer id) {
        return odontologoDao.buscar(id);
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);
    }
}
