package com.pro.service;

import java.util.List;

import com.pro.dto.BookingDTO;
import com.pro.pojos.Booking;

public interface BookingService {

	Booking createBooking(BookingDTO bookingDTO);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    void deleteBooking(Long id);
}
