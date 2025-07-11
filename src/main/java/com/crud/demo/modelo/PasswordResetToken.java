package com.crud.demo.modelo;

  import jakarta.persistence.*;
  import java.time.LocalDateTime;

  @Entity
  public class PasswordResetToken {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String token;

      @OneToOne
      private User user;

      private LocalDateTime expiryDate;

      public PasswordResetToken() {}

      public PasswordResetToken(User user, String token) {
          this.user = user;
          this.token = token;
          this.expiryDate = LocalDateTime.now().plusHours(24); // Expira en 24 horas
      }

      // Getters y setters
      public Long getId() { return id; }
      public void setId(Long id) { this.id = id; }
      public String getToken() { return token; }
      public void setToken(String token) { this.token = token; }
      public User getUser() { return user; }
      public void setUser(User user) { this.user = user; }
      public LocalDateTime getExpiryDate() { return expiryDate; }
      public void setExpiryDate(LocalDateTime expiryDate) { this.expiryDate = expiryDate; }
  }