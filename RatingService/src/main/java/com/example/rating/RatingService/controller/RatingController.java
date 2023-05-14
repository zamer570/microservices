package com.example.rating.RatingService.controller;

import com.example.rating.RatingService.entity.Rating;
import com.example.rating.RatingService.repository.RatingRepository;
import com.example.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<?> createRating(@RequestBody Rating rating){
         ratingService.create(rating);
         return ResponseEntity.ok("Created rating");
    }

    @GetMapping("/getRating")
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/getRatingByUserId/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUSerId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/getRatingByHotelId/{hotelId}")
    public ResponseEntity<Rating> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
