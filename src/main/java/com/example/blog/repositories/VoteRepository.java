package com.example.blog.repositories;

import com.example.blog.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    // You can add custom query methods here if needed.
    List<Vote> findByPost_Pid(Long pid);
}
