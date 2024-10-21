package com.micro.userservice.UserService.External.Service;

import com.micro.userservice.UserService.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("rating/")
    public Rating createRating(@RequestBody Rating rating);
}
