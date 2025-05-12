package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monitores")
public class Usuario {

    @Id
    private int Idmonitor;

    private String Nombres;
    private String Apellidos;
    private String telefono;
    private String correo;
    private Integer semestre;
    private String areapoyo;
    private String proacademico;

    // Getters y setters
    public int getIdmonitor() {
        return Idmonitor;
    }

    public void setIdmonitor(int idmonitor) {
        Idmonitor = idmonitor;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getAreapoyo() {
        return areapoyo;
    }

    public void setAreapoyo(String areapoyo) {
        this.areapoyo = areapoyo;
    }

    public String getProacademico() {
        return proacademico;
    }

    public void setProacademico(String proacademico) {
        this.proacademico = proacademico;
    }
}