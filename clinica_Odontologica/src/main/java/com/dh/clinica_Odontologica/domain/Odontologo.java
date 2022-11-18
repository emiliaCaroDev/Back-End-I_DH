package com.dh.clinica_Odontologica.domain;

public class Odontologo {

    private Integer id;
    private String numeroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(Integer id, String numeroMatricula, String apellido, String nombre) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.apellido = apellido;
        this.nombre = nombre;

    }

    public Odontologo(String numeroMatricula, String apellido, String nombre) {
        this.numeroMatricula = numeroMatricula;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public Odontologo(){}

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
