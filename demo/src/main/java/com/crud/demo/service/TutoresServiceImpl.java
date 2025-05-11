package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.interfaceService.TutoresService;
import com.crud.demo.interfaces.TutoresRepository;
import com.crud.demo.modelo.Tutor;

@Service
public class TutoresServiceImpl implements TutoresService {

    @Autowired
    private TutoresRepository repo;

    @Override
    public List<Tutor> listar() {
        return (List<Tutor>) repo.findAll();
    }

    @Override
    public Optional<Tutor> listarId(int id) {
        return repo.findById(id);
    }

    @Override
    public int save(Tutor t) {
        repo.save(t);
        return t.getIdtutor();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}