package com.micro.userservice.UserService.Service;

import com.micro.userservice.UserService.Entity.Rating;
import com.micro.userservice.UserService.Entity.User;

import java.util.List;

public interface UserService {

    public User registerUser(User user);
    public User getUser(String id);
    public List<User> getAllUsers();

    //External APIs
    //Post Rating

    public Rating createRating(String Id,Rating rating);

}
