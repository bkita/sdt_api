package com.herokuapp.restfulbooker.api.booking.test;

import com.herokuapp.restfulbooker.api.booking.payload.PostBookingPayload;
import com.herokuapp.restfulbooker.api.booking.request.GetBookingRequest;
import com.herokuapp.restfulbooker.api.booking.request.GetBookingsRequest;
import com.herokuapp.restfulbooker.api.booking.request.PostBookingRequest;
import com.herokuapp.restfulbooker.api.booking.response.GetBookingResponse;
import com.herokuapp.restfulbooker.api.booking.response.GetBookingsResponse;
import com.herokuapp.restfulbooker.api.booking.response.PostBookingResponse;
import com.herokuapp.restfulbooker.api.booking.verification.GetBookingByIdVerification;
import com.herokuapp.restfulbooker.api.booking.verification.PostBookingVerification;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreateBookingE2ETest {

    private static int bookingId;
    private static PostBookingPayload payload;

    @BeforeAll
    public static void setup() {
        payload = PostBookingPayload.getDefaultPostBooking();
    }

    @Test
    @Order(1)
    void shouldCreateNewBooking() {
        PostBookingResponse response = PostBookingRequest.createBooking(payload);
        bookingId = response.getBookingid();
        PostBookingVerification.verifyCreateBookingResponse(response, payload); // TODO 1
    }

    @Test
    @Order(2)
    void shouldReturnBookingDetailsByBookingId() {
        GetBookingResponse response = GetBookingRequest.readBookingById(bookingId);
        GetBookingByIdVerification.verifyGetBookingByIdResponse(response, payload);
    }

    @Test
    @Order(3)
    void shouldReturnListOfBookingIdsWhichIncludesNewBookingId() {
        List<GetBookingsResponse> getBookingsResponse = GetBookingsRequest.readAllBookings();

        List<Integer> bookingIds = getBookingsResponse.stream()
                .map(GetBookingsResponse::getBookingid)
                .collect(Collectors.toList());

        assertThat(bookingIds.size()).isPositive();

        Integer newBookingId = getBookingsResponse.stream()
                .map(GetBookingsResponse::getBookingid)
                .filter(id -> id.equals(bookingId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Can not find com.herokuapp.restfulbooker.booking with given id", bookingId)));

//        assertThat(newBookingId).isEqualTo(bookingIds); // 3
        assertThat(newBookingId).isEqualTo(bookingId); // TODO do usunięcia
    }
}
