package com.example.blog.controllers;

import com.example.blog.entities.Post;
import com.example.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    @GetMapping("/{pid}")
    public ResponseEntity<Post> getPostById(@PathVariable Long pid) {
        Post post = postService.getPostById(pid);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<Post> updatePost(@PathVariable Long pid, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(pid, post);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<Void> deletePost(@PathVariable Long pid) {
        boolean deleted = postService.deletePost(pid);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/search/byCompany/{company}")
    public List<Post> getPostsByCompany(@PathVariable String company) {
        return postService.getPostsByCompany(company);
    }

    @GetMapping("/search/byUser/{uid}")
    public List<Post> getPostsByUser(@PathVariable Long uid) {
        return postService.getPostsByUser(uid);
    }
    @GetMapping("/search/byRole/{role}")
    public List<Post> getPostsByRole(@PathVariable String role){
        return postService.getPostsByRole(role);
    }
}

