package com.crud.demo.controler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToInicio() {
        return "landing-page/index";
    }
     @GetMapping("/entrar")
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
    @GetMapping("/Post")
    public String redirectblogPost() {
        return "blog/post"; // sin ".html"
    }
    @GetMapping("/monitor")
    public String redirectblogMonitor() {
        return "blog/monitor"; // sin ".html"
    }
    @GetMapping("/perfil")
    public String redirectblogPerfil() {
        return "blog/perfil"; // sin ".html"
    }
    @GetMapping("/notificaciones")
    public String redirectblogNotificaciones() {
        return "blog/notificaciones"; // sin ".html"
    }
    @GetMapping("/config")
    public String redirectblogConfiguracion() {
        return "blog/configuracion"; // sin ".html"
    }
}