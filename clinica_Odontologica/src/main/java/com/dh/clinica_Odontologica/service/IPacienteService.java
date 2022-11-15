package com.dh.clinica_Odontologica.service;

import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.domain.Paciente;

import java.util.List;

public interface IPacienteService{
    List<Paciente> listarTodosPacientes();
    Paciente buscarXEmail(String email);

    Paciente guardarPaciente(Paciente paciente);

    void eliminarPaciente(Integer id);

    Paciente buscarXId(Integer id);
}
