package com.driveai.documentsms.services;

import com.driveai.documentsms.models.User;
import com.driveai.documentsms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findById(int id){
        return userRepository.findById(id).get();
    }

    public User findByUsername(String username){
        return userRepository.findFirstByUsername(username);
    }
}
