package com.example.UserService.external.services;

import com.example.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("hotel/getHotel")
    Hotel getHotel(@RequestParam String id);
}
