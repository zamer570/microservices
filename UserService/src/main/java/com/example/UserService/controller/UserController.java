package com.example.UserService.controller;

import com.example.UserService.entities.User;
import com.example.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

}
