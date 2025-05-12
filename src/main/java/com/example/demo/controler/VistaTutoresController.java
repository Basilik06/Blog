package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.interfaceService.TutoresService;

@Controller
public class VistaTutoresController {

    @Autowired
    private TutoresService service;

    @GetMapping("/tutores")
    public String verListaTutores(Model model) {
        model.addAttribute("tutores", service.listar());
        return "lista-tutores"; // Nombre del archivo HTML en src/main/resources/templates
    }
}