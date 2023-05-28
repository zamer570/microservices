package com.example.UserService.external.services;

import com.example.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("RATING-SERVICE")
public interface RatingService {

    @PostMapping("/rating/create")
    String createRating(@RequestBody Rating rating);
}
