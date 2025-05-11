package com.crud.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crud.demo.interfaceService.MonitoresService;
import com.crud.demo.modelo.Usuario;

@RestController
@RequestMapping("/api/monitores")
@CrossOrigin(origins = "*")
public class MonitoresController {

    @Autowired
    private MonitoresService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> listarId(@PathVariable int id) {
        return service.listarId(id);
    }

    @PostMapping
    public int save(@RequestBody Usuario m) {
        return service.save(m);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody Usuario m, @PathVariable int id) {
        m.setIdmonitor(id);
        return service.save(m);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
