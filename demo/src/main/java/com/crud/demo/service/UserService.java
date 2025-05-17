package com.crud.demo.service;

import com.crud.demo.modelo.PasswordResetToken;
import com.crud.demo.modelo.User;
import com.crud.demo.interfaceService.PasswordResetTokenRepository;
import com.crud.demo.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    public void createPasswordResetTokenForUser(String email) throws Exception {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new Exception("Usuario no encontrado"));

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(user, token);
        tokenRepository.save(resetToken);

        emailService.sendPasswordResetEmail(user.getEmail(), token);
    }

    public void resetPassword(String token, String newPassword) throws Exception {
        PasswordResetToken resetToken = tokenRepository.findByToken(token);

        if (resetToken == null || resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new Exception("Token inválido o expirado");
        }

        User user = resetToken.getUser();
        user.setContrasena(newPassword); // Almacena la contraseña en texto plano
        userRepository.save(user);

        tokenRepository.delete(resetToken);
    }
}