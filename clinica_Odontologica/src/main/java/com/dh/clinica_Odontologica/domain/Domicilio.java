package com.dh.clinica_Odontologica.domain;

public class Domicilio {

    //atributos
    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

    //constructores
    public Domicilio(Integer id, String calle, Integer numero, String localidad,String provincia) {
        this.id = id;
        this.calle = calle;
        this.localidad = localidad;
        this.numero = numero;
        this.provincia = provincia;
    }

    public Domicilio(String calle, Integer numero, String localidad,String provincia) {
        this.calle = calle;
        this.localidad = localidad;
        this.numero = numero;
        this.provincia = provincia;
    }

    public Domicilio(){}


// getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    //toString

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", localidad='" + localidad + '\'' +
                ", numero=" + numero +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
