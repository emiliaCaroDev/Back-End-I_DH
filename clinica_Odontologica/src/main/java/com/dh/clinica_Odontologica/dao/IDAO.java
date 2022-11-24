package com.dh.clinica_Odontologica.dao;



import java.util.List;

public interface IDAO<T>{

    T guardar(T t);
    T buscarXId(Integer id);
    List<T> listarTodos();
    void eliminar(Integer id);

    T buscarXEmail(String email);

    T actualizar(T t);
}
