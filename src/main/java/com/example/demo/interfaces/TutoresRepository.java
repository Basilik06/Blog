package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.modelo.Tutor;

public interface TutoresRepository extends CrudRepository<Tutor, Integer> {
}