package com.dh.clinica_Odontologica.service;

import com.dh.clinica_Odontologica.domain.Turno;

import java.util.List;

public interface ITurnoService {

    List<Turno> listarTodosTurnos();
    Turno guardarTurno(Turno turno);
    void eliminarTurno(Integer id);
    Turno buscarTurnoXId(Integer id);
    Turno actualizarTurno(Turno turno);
}
