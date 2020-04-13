package com.passion.saveit.app.controller;

import com.passion.saveit.app.model.User;
import com.passion.saveit.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<User> updatedUser(@RequestParam long id,@RequestBody User user){
        return new ResponseEntity<>(service.updateUser(id,user),HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@RequestParam long id){
        service.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
