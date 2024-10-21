package com.micro.userservice.UserService;

import com.micro.userservice.UserService.Entity.Rating;
import com.micro.userservice.UserService.Entity.User;
import com.micro.userservice.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    //External Apis

    @PostMapping("/{id}/rating")
    public ResponseEntity<Rating> createRating(@PathVariable String id,@RequestBody Rating rating){
     Rating rating1 =  userService.createRating(id, rating) ;
     return ResponseEntity.ok(rating1);
    }
}
