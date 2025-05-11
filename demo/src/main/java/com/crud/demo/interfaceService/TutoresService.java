package com.crud.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.crud.demo.modelo.Tutor;

public interface TutoresService {
    public List<Tutor> listar();

    public Optional<Tutor> listarId(int id);

    public int save(Tutor t);

    public void delete(int id);
}