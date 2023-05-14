package com.example.rating.RatingService.service;

import com.example.rating.RatingService.entity.Rating;
import com.example.rating.RatingService.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    public void create(Rating rating){
        ratingRepository.save(rating);
    }

    public List<Rating> getAllRating(){
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingByUserId(String userId){
        return ratingRepository.findByUserId(userId);
    }

    public Rating getRatingByHotelId(String hotelId){
        return ratingRepository.findByHotelId(hotelId);
    }
}
