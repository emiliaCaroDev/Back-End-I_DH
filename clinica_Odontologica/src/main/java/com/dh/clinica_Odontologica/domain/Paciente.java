package com.dh.clinica_Odontologica.domain;

import java.time.LocalDate;

public class Paciente {
    //atributos
    private Integer id;
    private Integer DNI;
    private String apellido;
    private String nombre;
    private LocalDate fechaIngreso;
    private String email;
    private Domicilio domicilio;

    //constructore

    public Paciente(Integer id, Integer DNI, String apellido, String nombre, LocalDate fechaIngreso, String email, Domicilio domicilio) {
        this.id = id;
        this.DNI = DNI;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.domicilio = domicilio;
    }

    public Paciente(Integer DNI, String apellido, String nombre, LocalDate fechaIngreso, String email, Domicilio domicilio) {
        this.DNI = DNI;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.domicilio = domicilio;
    }

    public Paciente(){}

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


    //toString

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", DNI=" + DNI +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", email='" + email + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }
}
