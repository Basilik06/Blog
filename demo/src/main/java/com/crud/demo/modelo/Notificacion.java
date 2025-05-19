package com.crud.demo.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_notificacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // Cambiado de "id" a "id_usuario"
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "id_publicacion", nullable = true)
    private Publicacion publicacion;

    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_seguidor", nullable = true)
    private User seguidor;

    private String tipo_notificacion;

    private String mensaje;

    private LocalDateTime fecha_notificacion;

    private boolean leida;

    // Getters y Setters

    public Long getId_notificacion() {
        return id_notificacion;
    }

    public void setId_notificacion(Long id_notificacion) {
        this.id_notificacion = id_notificacion;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public User getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(User seguidor) {
        this.seguidor = seguidor;
    }

    public String getTipo_notificacion() {
        return tipo_notificacion;
    }

    public void setTipo_notificacion(String tipo_notificacion) {
        this.tipo_notificacion = tipo_notificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha_notificacion() {
        return fecha_notificacion;
    }

    public void setFecha_notificacion(LocalDateTime fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    public boolean isLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }
}