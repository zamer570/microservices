package com.example.HotelService.controller;


import com.example.HotelService.entities.Hotel;
import com.example.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    ResponseEntity createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity(hotelService.create(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/getHotels")
    ResponseEntity<List<Hotel>> getHotels(){
        return ResponseEntity.ok(hotelService.getAll());
    }

    @GetMapping("/getHotel")
    ResponseEntity<Hotel> getHotelById(@RequestParam String id){
        return ResponseEntity.ok(hotelService.get(id));
    }
}
