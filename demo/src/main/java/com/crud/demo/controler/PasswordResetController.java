package com.crud.demo.controler;

  import com.crud.demo.service.UserService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.*;

  @Controller
  public class PasswordResetController {
      @Autowired
      private UserService userService;

      @GetMapping("/forgot-password")
      public String showForgotPasswordForm() {
    	  return "landing-page/forgot-password";
      }

      @PostMapping("/forgot-password")
      public String processForgotPassword(@RequestParam("email") String email, Model model) {
          try {
              userService.createPasswordResetTokenForUser(email);
              model.addAttribute("message", "Se ha enviado un enlace de restablecimiento a su correo");
          } catch (Exception e) {
              model.addAttribute("error", e.getMessage());
          }
          return "landing-page/forgot-password";
      }

      @GetMapping("/reset-password")
      public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
          model.addAttribute("token", token);
          return "landing-page/reset-password";
      }

      @PostMapping("/reset-password")
      public String processResetPassword(
          @RequestParam("token") String token,
          @RequestParam("password") String password,
          Model model
      ) {
          try {
              userService.resetPassword(token, password);
              model.addAttribute("message", "Contraseña restablecida exitosamente");
          } catch (Exception e) {
              model.addAttribute("error", e.getMessage());
          }
          return "landing-page/login";
      }
  }