package com.herokuapp.restfulbooker.api.booking.response;

import com.herokuapp.restfulbooker.api.booking.dto.BookingDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostBookingResponse {

    private int bookingid;
    private BookingDto booking;
}
