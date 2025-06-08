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
    @GetMapping("/post")
    public String redirectblogPost() {
        return "blog/post"; // sin ".html"
    }
     @GetMapping("/nuevo_post")
    public String redirectblogCrearPost() {
        return "blog/crear_post"; // sin ".html"
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


    @GetMapping("/monitor-usuario")
    public String redirectblogMonitorU() {
        return "blog/usuario/monitor-usuario"; // sin ".html"
    }
    @GetMapping("/perfil-usuario")
    public String redirectblogPerfilU() {
        return "blog/usuario/perfil-usuario"; // sin ".html"
    }
     @GetMapping("/post-usuario")
    public String redirectblogPostU() {
        return "blog/usuario/post-usuario"; // sin ".html"
    }
     @GetMapping("/notificaciones-usuario")
    public String redirectblogNotificacionesU() {
        return "blog/usuario/notificaciones"; // sin ".html"
    }
    @GetMapping("/config-usuario")
    public String redirectblogConfiguracionU() {
        return "blog/usuario/configuracion"; // sin ".html"
    }
}