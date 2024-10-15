package com.micro.userservice.UserService.UserServiceImpl;

import com.micro.userservice.UserService.Entity.Hotel;
import com.micro.userservice.UserService.Entity.Rating;
import com.micro.userservice.UserService.Entity.User;
import com.micro.userservice.UserService.Repository.UserRepository;
import com.micro.userservice.UserService.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User registerUser(User user) {
        String generateUserId = UUID.randomUUID().toString();
        User saveUser = new User();
        saveUser.setUserId(generateUserId);
        saveUser.setName(user.getName());
        saveUser.setAbout(user.getAbout());
        saveUser.setEmail(user.getEmail());
        saveUser.setPassword(user.getPassword());
        userRepository.save(saveUser);
       return saveUser;
    }

    @Override
    public User getUser(String id) {
        User user = userRepository.findById(id).orElseThrow();
        Rating[] list = restTemplate.getForObject("http://RATING-SERVICE/rating/userRatings/7da7f25c-8870-47e3-930a-8d2f40dd9f74", Rating[].class);
        List<Rating> ratings = Arrays.stream(list).toList();
        logger.info("{} ",ratings);

        //   ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/fetchHotel/" +rating.getHotelId(), Hotel.class);

       List<Rating> ratingList = ratings.stream().map( rating -> {
           ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/fetchHotel/" +rating.getHotelId(), Hotel.class);
           Hotel hotel = forEntity.getBody();
           rating.setHotel(hotel);
           return rating;
               }).collect(Collectors.toList());
       user.setUserRatings(ratings);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
       List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
}
