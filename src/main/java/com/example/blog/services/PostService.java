package com.example.blog.services;

import com.example.blog.entities.Post;
import com.example.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long pid) {
        return postRepository.findById(pid).orElse(null);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long pid, Post post) {
        if (postRepository.existsById(pid)) {
            post.setPid(pid);
            return postRepository.save(post);
        } else {
            return null;
        }
    }

    public boolean deletePost(Long pid) {
        if (postRepository.existsById(pid)) {
            postRepository.deleteById(pid);
            return true;
        } else {
            return false;
        }
    }
    public List<Post> getPostsByCompany(String company) {
        return postRepository.findByCompany(company);
    }

    public List<Post> getPostsByUser(Long uid) {
        return postRepository.findByUser_Uid(uid);
    }
}
