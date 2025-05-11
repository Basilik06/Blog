package com.crud.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.crud.demo.modelo.fotos;

public interface FotosService {
    public int save(fotos f);

    public List<fotos> listar();

    public Optional<fotos> listarId(int id);

    public void delete(int id);
}
