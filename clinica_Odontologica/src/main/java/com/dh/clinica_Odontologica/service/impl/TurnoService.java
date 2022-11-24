package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Turno;
import com.dh.clinica_Odontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private IDAO<Turno> turnoDao;

    @Autowired
    public TurnoService(IDAO<Turno> turnoDao) {
        this.turnoDao = turnoDao;
    }


    @Override
    public List<Turno> listarTodosTurnos() {
        return turnoDao.listarTodos();
    }

    @Override
    public Turno guardarTurno(Turno turno) {
        return turnoDao.guardar(turno);
    }

    @Override
    public void eliminarTurno(Integer id) {
        turnoDao.eliminar(id);
    }

    @Override
    public Turno buscarTurnoXId(Integer id) {
        return turnoDao.buscarXId(id);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoDao.actualizar(turno);
    }
}
