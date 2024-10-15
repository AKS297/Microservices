package com.ratingservice.RatingService.ServiceImpl;

import com.ratingservice.RatingService.Entity.Rating;
import com.ratingservice.RatingService.Repository.RatingRepository;
import com.ratingservice.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {
    
    @Autowired
    private RatingRepository repository;
    
    @Override
    public Rating createRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setId(ratingId);
        return repository.save(rating);
    }

    @Override
    public Rating getRating(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Rating> allRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getUserRatings(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getHotelRatings(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
