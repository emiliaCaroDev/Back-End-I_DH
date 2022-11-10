package com.dh.clinica_Odontologica.service;

import com.dh.clinica_Odontologica.domain.Odontologo;

import java.util.List;

public interface IOdontologoService {

    List<Odontologo> listarTodosOdontologos();
    Odontologo buscarOdontologoXId(Integer id);
    Odontologo guardarOdontologo(Odontologo odontologo);
}
