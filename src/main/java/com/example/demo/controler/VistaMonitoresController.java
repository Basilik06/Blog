package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.interfaceService.MonitoresService;

@Controller
public class VistaMonitoresController {

    @Autowired
    private MonitoresService service;

    @GetMapping("/monitores")
    public String verListaMonitores(Model model) {
        model.addAttribute("monitores", service.listar());
        return "lista-monitores"; // Nombre del archivo HTML en src/main/resources/templates
    }
}
