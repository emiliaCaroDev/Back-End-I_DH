package com.dh.clinica_Odontologica.dao.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Turno;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Component
public class TurnoDAO implements IDAO<Turno> {

    List<Turno> listaTurnos;
    public TurnoDAO(){
     listaTurnos = new ArrayList<>();
    }


    @Override
    public Turno guardar(Turno turno) {
        listaTurnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscarXId(Integer id) {
        Turno turnoBuscado = null;
        Iterator<Turno> iter = listaTurnos.iterator();
        while (iter.hasNext()) {
            Turno turno = iter.next();
            if (turno.getId() == id) {
                turnoBuscado = turno;
            }
        }
        return turnoBuscado;
    }

    @Override
    public List<Turno> listarTodos() {
        return listaTurnos;
    }

    @Override
    public void eliminar(Integer id) {
        if (buscarXId(id) != null) {
            listaTurnos.remove(buscarXId(id));
        }
    }

    @Override
    public Turno buscarXEmail(String email) {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) {
        Turno turnoAModificar = buscarXId(turno.getId());
        int indexDelTurnoAModificar = listaTurnos.indexOf(turnoAModificar);
        listaTurnos.set(indexDelTurnoAModificar, turno);
        return turnoAModificar;
    }
}
