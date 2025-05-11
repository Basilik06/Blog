package com.crud.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.crud.demo.modelo.Usuario;

public interface MonitoresRepository extends CrudRepository<Usuario, Integer> {
}
