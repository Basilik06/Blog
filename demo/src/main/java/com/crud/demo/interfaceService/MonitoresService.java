package com.crud.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.crud.demo.modelo.Usuario;

public interface MonitoresService {
    public List<Usuario> listar();

    public Optional<Usuario> listarId(int id);

    public int save(Usuario m);

    public void delete(int id);
}
