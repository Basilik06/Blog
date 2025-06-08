package com.crud.demo.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.modelo.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

}
