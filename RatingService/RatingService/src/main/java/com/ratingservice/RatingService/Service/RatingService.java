package com.ratingservice.RatingService.Service;

import com.ratingservice.RatingService.Entity.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);

    public Rating getRating(String id);

    public List<Rating> allRatings();

    public List<Rating> getUserRatings(String userId);

    public List<Rating> getHotelRatings(String hotelId);

}
