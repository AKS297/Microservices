package com.ratingservice.RatingService.Controller;

import com.ratingservice.RatingService.Entity.Rating;
import com.ratingservice.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating saveRating = ratingService.createRating(rating);
        return new  ResponseEntity<>(saveRating, HttpStatus.CREATED);
    }

    @GetMapping("/getRating/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable String id){
        Rating getRating = ratingService.getRating(id);
        return ResponseEntity.ok(getRating);
    }

    @GetMapping("/allRatings")
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> allRatings = ratingService.allRatings();
        return ResponseEntity.ok(allRatings);
    }

    @GetMapping("/userRatings/{userId}")
    public ResponseEntity<List<Rating>> getUserRatings(@PathVariable String userId){
        List<Rating> userRatings = ratingService.getUserRatings(userId);
        return ResponseEntity.ok(userRatings);
    }

    @GetMapping("/hotelRatings/{hotelId}")
    public ResponseEntity<List<Rating>> getHotelRatings(@PathVariable String hotelId){
        List<Rating> hotelRatings = ratingService.getHotelRatings(hotelId);
        return ResponseEntity.ok(hotelRatings);
    }

}
