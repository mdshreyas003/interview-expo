package com.example.blog.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Post post;

    @Column(nullable = false)
    private int voteValue; // 1 for upvote, -1 for downvote

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Constructors, getters, and setters

    public Vote() {
        this.createdAt = new Date();
    }

    public Vote(Post post, int voteValue) {
        this.post = post;
        this.voteValue = voteValue;
        this.createdAt = new Date();
    }

    // Getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", post=" + post +
                ", voteValue=" + voteValue +
                ", createdAt=" + createdAt +
                '}';
    }
}
