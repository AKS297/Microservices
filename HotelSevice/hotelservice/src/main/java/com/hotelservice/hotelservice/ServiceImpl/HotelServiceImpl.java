package com.hotelservice.hotelservice.ServiceImpl;

import com.hotelservice.hotelservice.Entity.Hotel;
import com.hotelservice.hotelservice.Repository.HotelRepository;
import com.hotelservice.hotelservice.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
