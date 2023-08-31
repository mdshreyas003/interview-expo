package com.example.blog.repositories;

import com.example.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//@Query("select p from posts p where p.company =:company")
    List<Post> findByCompanyIgnoreCase(String company);
//@Query("select p from posts p where p.uid =:uid")
    List<Post> findByUser_Uid(Long uid);
    List<Post> findByRoleIgnoreCase(String role);
}