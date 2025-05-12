package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.FotosRepository;
import com.example.demo.interfaceService.FotosService;
import com.example.demo.modelo.fotos;

@Service
public class FotosServiceImpl implements FotosService {

    @Autowired
    private FotosRepository repository;

    @Override
    public int save(fotos f) {
        fotos saved = repository.save(f);
        return saved.getId();
    }

    @Override
    public List<fotos> listar() {
        return (List<fotos>) repository.findAll();
    }

    @Override
    public Optional<fotos> listarId(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
