package com.crud.demo.modelo;

import java.time.LocalDateTime;
import java.util.List;

public class PublicacionDTO {
    private String titulo;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private String nombreAutor;
    private List<String> nombresFotos;

    // Constructor
    public PublicacionDTO(String titulo, String contenido, LocalDateTime fechaPublicacion, String nombreAutor, List<String> nombresFotos) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.nombreAutor = nombreAutor;
        this.nombresFotos = nombresFotos;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public List<String> getNombresFotos() {
		return nombresFotos;
	}

	public void setNombresFotos(List<String> nombresFotos) {
		this.nombresFotos = nombresFotos;
	}

 
}