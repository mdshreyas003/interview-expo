package com.example.blog.services;

import com.example.blog.entities.Post;
import com.example.blog.entities.User;
import com.example.blog.repositories.PostRepository;
import com.example.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long pid) {
        return postRepository.findById(pid).orElse(null);
    }

    public Post createPost(Post post) {


        postRepository.save(post);
        User user = userRepository.findById(post.getUser().getUid()).orElse(null);
        user.setBlogs(user.getBlogs()+1);
        userRepository.save(user);
        return post;
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
            Post post = postRepository.findById(pid).orElse(null);
            User user = userRepository.findById(post.getUser().getUid()).orElse(null);
            user.setBlogs(user.getBlogs()-1);
            userRepository.save(user);
            postRepository.deleteById(pid);
            return true;
        } else {
            return false;
        }
    }
    public List<Post> getPostsByCompany(String company) {
        return postRepository.findByCompanyIgnoreCase(company);
    }

    public List<Post> getPostsByUser(Long uid) {
        return postRepository.findByUser_Uid(uid);
    }
    public List<Post> getPostsByRole(String role){
        return postRepository.findByRoleIgnoreCase(role);
    }
}
