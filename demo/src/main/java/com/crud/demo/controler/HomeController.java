package com.crud.demo.controler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToInicio() {
        return "landing-page/index";
    }
     @GetMapping("/login")
    public String redirectlogin() {
        return "landing-page/login"; // sin ".html"
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
    @GetMapping("/index_blog")
    public String redirectblog() {
        return "blog/index"; // sin ".html"
    }
}