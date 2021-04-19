package com.herokuapp.restfulbooker.api.booking.response;

import com.herokuapp.restfulbooker.api.booking.dto.BookingDatesDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PatchBookingResponse {

    private String firstname;
    private String lastname;
    private BigDecimal totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    private BookingDatesDto bookingdates;
}
