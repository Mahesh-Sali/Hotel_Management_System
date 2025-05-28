package com.jsp.HotelManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.HotelManagementSystem.dto.Hotel;

public interface Hotelrepo extends JpaRepository<Hotel, Integer>
{
	@Query("select h from Hotel h where h.hotel_id=?1")
    public Hotel getHotelbyid(int hid);
}
