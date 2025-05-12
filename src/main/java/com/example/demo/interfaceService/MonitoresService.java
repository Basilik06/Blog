package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.example.demo.modelo.Usuario;

public interface MonitoresService {
    public List<Usuario> listar();

    public Optional<Usuario> listarId(int id);

    public int save(Usuario m);

    public void delete(int id);
}
