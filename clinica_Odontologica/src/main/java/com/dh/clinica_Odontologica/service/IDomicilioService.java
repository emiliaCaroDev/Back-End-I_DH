package com.dh.clinica_Odontologica.service;

import com.dh.clinica_Odontologica.domain.Domicilio;
import com.dh.clinica_Odontologica.domain.Odontologo;

import java.util.List;

public interface IDomicilioService {

    List<Domicilio> listarTodosDomicilio();
    Domicilio buscarDomicilioXId(Integer id);
    Domicilio guardarDomicilio(Domicilio domicilio);

    void eliminarDomicilio(Integer id);
}
