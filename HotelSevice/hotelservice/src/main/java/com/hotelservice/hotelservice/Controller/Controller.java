package com.hotelservice.hotelservice.Controller;

import com.hotelservice.hotelservice.Entity.Hotel;
import com.hotelservice.hotelservice.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class Controller {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/registerHotel")
    public ResponseEntity<Hotel> registerHotel(@RequestBody Hotel hotel){
        Hotel registeredHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<>(registeredHotel, HttpStatus.CREATED);
    }

    @GetMapping("/fetchHotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
      Hotel fetchHotel = hotelService.getHotel(hotelId);
      return ResponseEntity.ok(fetchHotel);
    }

    @GetMapping("/fetchAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotelDetails = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotelDetails);
    }

}
