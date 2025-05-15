package com.crud.demo.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.demo.interfaces.UserRepository;
import com.crud.demo.modelo.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository usuarioRepository;  // Inyección fuera del método

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {

        Optional<User> userOpt = usuarioRepository.findByEmailAndContrasena(email, password);

        if (userOpt.isPresent()) {
            int user = userOpt.get().getRol();
            if (user == 1) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/cliente/inicio";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Credenciales inválidas");
            return "redirect:/entrar";
        }
    }

    @GetMapping("/admin/dashboard")
    public String adminHome() {
        return "admin/index";  // vista admin/index.html
    }

    @GetMapping("/cliente/inicio")
    public String clienteHome() {
        return "blog/index";  // vista cliente/inicio.html
    }
}