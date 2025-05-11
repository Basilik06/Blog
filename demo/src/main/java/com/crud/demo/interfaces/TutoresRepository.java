package com.crud.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.crud.demo.modelo.Tutor;

public interface TutoresRepository extends CrudRepository<Tutor, Integer> {
}