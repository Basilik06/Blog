package com.crud.demo.interfaces;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.demo.modelo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndContrasena(String email, String contrasena);
    Optional<User> findByEmail(String email);

}