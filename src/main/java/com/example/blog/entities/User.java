package com.example.blog.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "blogs_count")
    private int blogs;


    private String password;

    // Constructors, getters, setters, and other methods

    // Constructors
    public User() {
    }

    public User(String name, String email, int blogs, String password) {
        this.name = name;
        this.email = email;
        this.blogs = blogs;
        this.password = password;
    }

    // Getters and setters
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBlogs() {
        return blogs;
    }

    public void setBlogs(int blogs) {
        this.blogs = blogs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

