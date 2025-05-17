package com.crud.demo.interfaceService;

  import com.crud.demo.modelo.PasswordResetToken;
  import org.springframework.data.jpa.repository.JpaRepository;

  public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
      PasswordResetToken findByToken(String token);
  }