package com.example.UserService.services.impl;

import com.example.UserService.entities.Hotel;
import com.example.UserService.entities.Rating;
import com.example.UserService.entities.User;
import com.example.UserService.exceptions.ResourceNotFoundException;
import com.example.UserService.repositories.UserRepository;
import com.example.UserService.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not present for userId "+ userId));
        List<Rating> rating = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject("http://RATING-SERVICE/rating/getRatingByUserId/" + userId, Rating[].class)));
        System.out.println(rating);
        List<Rating> ratingWithHotel= rating.stream().peek(rating1 -> {
            Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/getHotel?id={id}",Hotel.class,rating1.getHotelId());
            rating1.setHotel(hotel);
        }).collect(Collectors.toList());

        user.setRating(ratingWithHotel);
        return user;
    }

    @Override
    public String deleteUser(String userId) {
        return null;
    }

    @Override
    public String updateUser(User user) {
        return null;
    }
}
