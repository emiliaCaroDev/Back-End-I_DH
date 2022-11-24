package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.service.IDomicilioService;

import java.util.List;

public class DomicilioService implements IDomicilioService {

    private IDAO<Domicilio> domicilioDao;

    public DomicilioService(IDAO<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }

    /*public DomicilioService(){
        domicilioDao =  new DomicilioDAOH2();
    }*/

    @Override
    public List<Domicilio> listarTodosDomicilio() {
        return domicilioDao.listarTodos();
    }

    @Override
    public Domicilio buscarDomicilioXId(Integer id) {
        return domicilioDao.buscarXId(id);
    }

    @Override
    public Domicilio guardarDomicilio(Domicilio domicilio) {
        return domicilioDao.guardar(domicilio);
    }

    @Override
    public void eliminarDomicilio(Integer id) {
        domicilioDao.eliminar(id);
    }


}
