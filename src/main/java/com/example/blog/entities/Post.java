package com.example.blog.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;


    private String title;


    @Column(columnDefinition = "TEXT")
    private String description;


    private String company;


    private String role;


    private String salary;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
//    @JoinColumn(name = "uid", nullable = false)
    private User user;
    // Constructors, getters, setters, and other methods

    // Constructors
    public Post() {
    }

    public Post(String title, String description, String company, String role, String salary, String content, User user) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.role = role;
        this.salary = salary;
        this.content = content;
        this.user = user;
    }

    // Getters and setters
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
