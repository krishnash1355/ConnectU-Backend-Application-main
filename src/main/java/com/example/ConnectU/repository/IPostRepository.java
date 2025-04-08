package com.example.ConnectU.repository;

import com.example.ConnectU.model.Post;
import com.example.ConnectU.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
}
