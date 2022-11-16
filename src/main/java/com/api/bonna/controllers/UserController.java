package com.api.bonna.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.bonna.models.UserModel;
import com.api.bonna.services.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUser(){
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel postUser(@RequestBody UserModel user){
        return this.userService.postUsers(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.userService.getByPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "Se elimino el usuario de id: " + id;
        } else {
            return "No se pudo eliminar al usuario de id: " + id;
        }
    }
}
