package com.example.blog.services;

import com.example.blog.entities.User;
import com.example.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long uid) {
        return userRepository.findById(uid).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long uid, User user) {
        if (userRepository.existsById(uid)) {
            user.setUid(uid);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long uid) {
        if (userRepository.existsById(uid)) {
            userRepository.deleteById(uid);
            return true;
        } else {
            return false;
        }
    }
}
