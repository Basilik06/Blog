package com.crud.demo.service;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.mail.javamail.JavaMailSender;
  import org.springframework.mail.javamail.MimeMessageHelper;
  import org.springframework.stereotype.Service;
  import jakarta.mail.MessagingException;
  import jakarta.mail.internet.MimeMessage;

  @Service
  public class EmailService {
      @Autowired
      private JavaMailSender mailSender;

      public void sendPasswordResetEmail(String to, String token) throws MessagingException {
          MimeMessage message = mailSender.createMimeMessage();
          MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

          String resetUrl = "http://localhost:8081/reset-password?token=" + token;

          helper.setTo(to);
          helper.setFrom("efrainbotello11@gmail.com"); // Usa el correo verificado o dominio autenticado
          helper.setSubject("Restablecer tu contraseña");
          helper.setText(
              "<h1>Restablecer contraseña</h1>" +
              "<p>Haz clic en el siguiente enlace para restablecer tu contraseña:</p>" +
              "<a href='" + resetUrl + "'>Restablecer contraseña</a>" +
              "<p>Este enlace expirará en 24 horas.</p>" +
              "<p>Si no solicitaste este cambio, ignora este correo.</p>",
              true
          );

          mailSender.send(message);
      }
  }