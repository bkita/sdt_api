package com.herokuapp.restfulbooker.api.booking.payload;

import com.herokuapp.restfulbooker.api.booking.dto.BookingDatesDto;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class PostBookingPayload {

    String firstname;
    String lastname;
    BigDecimal totalprice;
    int depositpaid; // TODO boolean
    String additionalneeds;
    BookingDatesDto bookingdates;

    public static PostBookingPayload getDefaultPostBooking() {
        BookingDatesDto bookingDatesDto = new BookingDatesDto();
        bookingDatesDto.setCheckin("2021-01-01");
        bookingDatesDto.setCheckout("2021-02-02");

        return builder()
                .firstname("Jo")
                .lastname("Black")
                .totalprice(BigDecimal.valueOf(100))
                .depositpaid(100)
                .additionalneeds("Sauna and spa")
                .bookingdates(bookingDatesDto)
                .build();
    }
}
