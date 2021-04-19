package com.herokuapp.restfulbooker.api.booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BookingDto {

    String firstname;
    String lastname;
    BigDecimal totalprice;
    boolean depositpaid;
    String additionalneeds;
    BookingDatesDto bookingdates;
}
