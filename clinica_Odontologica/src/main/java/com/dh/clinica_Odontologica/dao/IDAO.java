package com.dh.clinica_Odontologica.dao;



import java.util.List;

public interface IDAO<T>{

    T guardar(T t);
    T buscar(Integer id);
    List<T> listarTodos();
    void eliminar(Integer id);

    T buscarXEmail(String email);
}
