package com.example.ConnectU.repository;

import com.example.ConnectU.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);
}
