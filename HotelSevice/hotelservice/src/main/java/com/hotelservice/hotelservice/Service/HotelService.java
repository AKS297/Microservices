package com.hotelservice.hotelservice.Service;

import com.hotelservice.hotelservice.Entity.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel createHotel(Hotel hotel);

    public Hotel getHotel(String id);

    public List<Hotel> getAllHotels();
}
