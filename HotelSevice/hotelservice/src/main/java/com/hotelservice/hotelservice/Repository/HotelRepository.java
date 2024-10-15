package com.hotelservice.hotelservice.Repository;

import com.hotelservice.hotelservice.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
