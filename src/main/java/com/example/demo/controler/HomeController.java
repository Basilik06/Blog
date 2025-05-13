package com.example.demo.controler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToInicio() {
        return "blog/index";
    }
     @GetMapping("/login")
    public String redirectlogin() {
        return "blog/login"; // sin ".html"
    }

    @GetMapping("/index_crud")
    public String redirectadmin() {
        return "admin/index"; // sin ".html"
    }
    @GetMapping("/lista-monitores")
    public String mostrarListaMonitores() {
        return "admin/lista-monitores"; // sin ".html"
    }
    @GetMapping("/usuarios-monitores")
    public String redirectusuarios() {
        return "admin/usuarios"; // sin ".html"
    }
}