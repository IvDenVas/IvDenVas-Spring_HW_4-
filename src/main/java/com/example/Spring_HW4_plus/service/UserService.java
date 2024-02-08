package com.example.Spring_HW4_plus.service;

import com.example.Spring_HW4_plus.model.User;
import com.example.Spring_HW4_plus.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User getOne(int id) {
        return userRepository.getOne(id);
    }
    public User update(User user) {
        return userRepository.update(user);
    }
}