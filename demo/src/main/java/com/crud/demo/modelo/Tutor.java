package com.crud.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tutores")
public class Tutor {

    @Id
    private int Idtutor;

    private String Nombres;
    private String Apellidos;
    private String Telefono;
    private String Correo;
    private Integer Semestre;
    private String Areapoyo;
    private String Proacademico;

    // Getters y setters
    public int getIdtutor() {
        return Idtutor;
    }

    public void setIdtutor(int idtutor) {
        Idtutor = idtutor;
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
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Integer getSemestre() {
        return Semestre;
    }

    public void setSemestre(Integer semestre) {
        Semestre = semestre;
    }

    public String getAreapoyo() {
        return Areapoyo;
    }

    public void setAreapoyo(String areapoyo) {
        Areapoyo = areapoyo;
    }

    public String getProacademico() {
        return Proacademico;
    }

    public void setProacademico(String proacademico) {
        Proacademico = proacademico;
    }
}