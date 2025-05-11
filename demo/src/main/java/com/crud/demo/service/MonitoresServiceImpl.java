package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.interfaceService.MonitoresService;
import com.crud.demo.interfaces.MonitoresRepository;
import com.crud.demo.modelo.Usuario;

@Service
public class MonitoresServiceImpl implements MonitoresService {

    @Autowired
    private MonitoresRepository repo;

    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) repo.findAll();
    }

    @Override
    public Optional<Usuario> listarId(int id) {
        return repo.findById(id);
    }

    @Override
    public int save(Usuario m) {
        repo.save(m);
        return m.getIdmonitor();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
