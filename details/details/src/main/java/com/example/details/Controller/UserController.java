package com.example.details.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.details.Model.User;
import com.example.details.Service.UserService;

import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UserController {
    
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // get All user data 
    @GetMapping("/user")
    public Optional<User> getMethodName() {
        Optional<User> user = userService.getAll();
        if(user.isEmpty()){
            return null;
        }
        return user;
    }

    // get the user data 
    @GetMapping("user/{id}")
public ResponseEntity<User> getUser(@PathVariable Integer id) {
    Optional<User> user = userService.getUser(id);
    if (user.isEmpty()) {
        return ResponseEntity.notFound().build();
    } else {
        return ResponseEntity.ok(user.get());
    }
}

 // Add a new user
 @PostMapping("/user")
 public ResponseEntity<User> addUser(@RequestBody User user) {
     User newUser = userService.addUser(user);
     return ResponseEntity.ok(newUser);
 }
 
 // Update an existing user
 @PutMapping("/user/{id}")
 public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
     Optional<User> existingUser = userService.getUser(id);
     if (existingUser.isEmpty()) {
         return ResponseEntity.notFound().build();
     } else {
         user.setId(id);
         User updatedUser = userService.updateUser(user);
         return ResponseEntity.ok(updatedUser);
     }
 }
    
    // Delete the user id and details 
    @DeleteMapping("user/{id}")
    public Optional<User> putupdate(@PathVariable Integer id) {
        Optional<User> user = userService.removeUser(id);
        return user;
        
    }
    
}
    
    
    
    
