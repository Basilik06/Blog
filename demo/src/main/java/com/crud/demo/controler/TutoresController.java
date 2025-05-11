package com.crud.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crud.demo.interfaceService.TutoresService;
import com.crud.demo.modelo.Tutor;

@RestController
@RequestMapping("/api/tutores")
@CrossOrigin(origins = "*")
public class TutoresController {

    @Autowired
    private TutoresService service;

    @GetMapping
    public List<Tutor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Tutor> listarId(@PathVariable int id) {
        return service.listarId(id);
    }

    @PostMapping
    public int save(@RequestBody Tutor t) {
        return service.save(t);
    }

    @PutMapping("/{id}")
    public int update(@RequestBody Tutor t, @PathVariable int id) {
        t.setIdtutor(id);
        return service.save(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}