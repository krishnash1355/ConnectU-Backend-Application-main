package com.example.ConnectU.repository;

import com.example.ConnectU.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String token);
}
