package com.herokuapp.restfulbooker.api.booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingDatesDto {

    String checkin;
    String checkout;
}
