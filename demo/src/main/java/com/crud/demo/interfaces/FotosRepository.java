package com.crud.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.crud.demo.modelo.fotos;

public interface FotosRepository extends CrudRepository<fotos, Integer> {
    // Aquí puedes añadir métodos personalizados si quieres después
}
