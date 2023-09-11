package com.payandpark.payandpark.controllers;


import com.payandpark.payandpark.models.UserModel;
import com.payandpark.payandpark.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") String id){
        return this.userService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPhone(@PathParam("phone") String phone) {
        return this.userService.getByPhone(phone);
    }

    @PostMapping()
    public ResponseEntity<UserModel> add(@RequestBody UserModel user) {
        if(user.getId() == null || this.userService.exists(user.getId())){
            return ResponseEntity.ok(this.userService.saveUser(user));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping()
    public ResponseEntity<UserModel> update(@RequestBody UserModel user) {
        if(user.getId() != null && this.userService.exists(user.getId())){
            return ResponseEntity.ok(this.userService.updateUser(user));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(path = "/{user_id}")
    public String deleteById(@PathVariable("user_id") String id) {
        boolean ok = this.userService.deleteUser(id);

        if (ok) {
            return "User has been deleted: " + id;
        } else {
            return "Oh oh, something went wrong...";
        }

    }

}
