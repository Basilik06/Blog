package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.modelo.Usuario;

public interface MonitoresRepository extends CrudRepository<Usuario, Integer> {
}
