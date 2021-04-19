package com.herokuapp.restfulbooker.url;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingUrl {

    public static final String BASE_URL = "https://restful-booker.herokuapp.com/";
    public static final String BOOKING = "booking";
    public static final String AUTH = "auth";
}
