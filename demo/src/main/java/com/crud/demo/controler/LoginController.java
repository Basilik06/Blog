package com.crud.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.demo.interfaces.NotificacionRepository;
import com.crud.demo.interfaces.PublicacionRepository;
import com.crud.demo.interfaces.UserRepository;
import com.crud.demo.modelo.Notificacion;
import com.crud.demo.modelo.Publicacion;
import com.crud.demo.modelo.User;
import com.crud.demo.utils.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	@Autowired
	private PublicacionRepository publicacionRepository;
	@Autowired
	private UserRepository usuarioRepository;
	@Autowired
	private NotificacionRepository  NotificacionRepository;
	@Autowired
	private JwtUtil jwtUtil;
	String vemail="";
	String vpassword="";
	
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpServletResponse response,
			RedirectAttributes redirectAttributes, Model model) {
		vemail=email;
		vpassword=password;
		User user = usuarioRepository.findByEmailAndContrasena(email, password).orElse(null);

		if (user != null) {
			String token = jwtUtil.generateToken(email);

			Cookie cookie = new Cookie("jwt", token);
			cookie.setHttpOnly(true);
			cookie.setPath("/");
			cookie.setMaxAge(3600); // 1 hora
			response.addCookie(cookie);
			System.out.println("Cookie JWT generada para el usuario: " + email);
			int rol = user.getRol();
			if (rol == 1) {
				return "redirect:/admin/dashboard";
			} else if( rol==2) {
                return "redirect:/cliente/inicio";
			}else {
				return "redirect:/cliente/inicio-usuario";
			}
		} else {
			redirectAttributes.addFlashAttribute("error", "Acceso inválido. Por favor, inténtelo otra vez.");
			return "redirect:/entrar";
		}
	}

	@GetMapping("/admin/dashboard")
	public String adminHome(Model model) {
		String displayName = getLoggedUserDisplayName();
		model.addAttribute("displayName", displayName != null ? displayName : "Usuario no identificado");
		return "admin/index";
	}

	@GetMapping("/cliente/inicio")
	public String clienteHome(Model model) {
		User user = usuarioRepository.findByEmailAndContrasena(vemail, vpassword).orElse(null);
		 List<Publicacion> publicaciones = publicacionRepository.findAll();
		 List<Notificacion> noti=NotificacionRepository.findNotificacionesNoLeidasPorUsuario(user.getId());
		 model.addAttribute("notificaciones", noti);
		 model.addAttribute("posts", publicaciones);

		return "blog/index";
	}
@GetMapping("/cliente/inicio-usuario")
	public String clienteHome2(Model model) {
		User user = usuarioRepository.findByEmailAndContrasena(vemail, vpassword).orElse(null);
		 List<Publicacion> publicaciones = publicacionRepository.findAll();
		 List<Notificacion> noti=NotificacionRepository.findNotificacionesNoLeidasPorUsuario(user.getId());
		 model.addAttribute("notificaciones", noti);
		 model.addAttribute("posts", publicaciones);

		return "blog/usuario/index-usuario";
	}
	@GetMapping("/custom-logout")
	public String logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("jwt", null);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		System.out.println("Cookie JWT eliminada al cerrar sesión");
		return "redirect:/entrar";
	}

	private String getLoggedUserDisplayName() {
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			if (userDetails != null) {
				String username = userDetails.getUsername();
				return username.split("@")[0];
			}
		} catch (Exception e) {
			System.out.println("Error al obtener el usuario autenticado: " + e.getMessage());
		}
		return null;
	}
}