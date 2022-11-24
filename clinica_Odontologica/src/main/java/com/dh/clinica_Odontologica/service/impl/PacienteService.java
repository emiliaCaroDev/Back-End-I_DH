package com.dh.clinica_Odontologica.service.impl;

import com.dh.clinica_Odontologica.dao.IDAO;
import com.dh.clinica_Odontologica.domain.Paciente;
import com.dh.clinica_Odontologica.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService implements IPacienteService {

    private IDAO<Paciente> pacienteDao;

    //constructor
    public PacienteService(IDAO<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    /*public PacienteService(){}*/

    @Override
    public List<Paciente> listarTodosPacientes() {
        return pacienteDao.listarTodos();
    }

    @Override
    public Paciente buscarXEmail(String email) {
        return pacienteDao.buscarXEmail(email);
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteDao.guardar(paciente);
    }

    @Override
    public void eliminarPaciente(Integer id) {
        pacienteDao.eliminar(id);
    }

    @Override
    public Paciente buscarXId(Integer id) {
        return pacienteDao.buscarXId(id);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteDao.actualizar(paciente);
    }
}
