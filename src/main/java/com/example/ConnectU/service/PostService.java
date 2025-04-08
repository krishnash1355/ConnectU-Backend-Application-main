package com.example.ConnectU.service;

import com.example.ConnectU.model.Post;
import com.example.ConnectU.model.User;
import com.example.ConnectU.repository.IPostRepository;
import com.example.ConnectU.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    ITokenRepository tokenRepository;

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllPosts(String token) {
        User user = tokenRepository.findFirstByToken(token).getUser();
        List<Post> posts = postRepository.findByUser(user);
        return posts;
    }
}
