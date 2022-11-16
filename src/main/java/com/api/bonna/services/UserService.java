package com.api.bonna.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.bonna.models.UserModel;
import com.api.bonna.repositories.UserRepository;

// @EntityScan("com.api.bonna.models.UserModel")
@Service
public class UserService {
    @Autowired(required = false)
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel postUsers(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }
    
    public  ArrayList<UserModel> getByPrioridad(Integer prioridad) {
        return userRepository.findByPrioridad(prioridad);
    }

    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);

            return true;

        } catch(Exception err){
            return false;
        }
    }
}
