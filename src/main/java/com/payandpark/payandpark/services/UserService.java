package com.payandpark.payandpark.services;

import com.payandpark.payandpark.models.UserModel;
import com.payandpark.payandpark.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        UUID uuid = UUID.randomUUID();
        user.setId(uuid.toString());
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public UserModel updateUser(UserModel user) {
        return userRepository.save(user);
    }

    public boolean exists(String id) {
        return this.userRepository.existsById(id);
    }

    public Optional<UserModel> getById(String id) {
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public boolean deleteUser(String id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
