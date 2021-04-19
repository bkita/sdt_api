package com.herokuapp.restfulbooker.api.booking.test;

import com.herokuapp.restfulbooker.api.auth.payload.PostAuthPayload;
import com.herokuapp.restfulbooker.api.auth.request.PostAuthRequest;
import com.herokuapp.restfulbooker.api.booking.payload.PostBookingPayload;
import com.herokuapp.restfulbooker.api.booking.request.DeleteBookingRequest;
import com.herokuapp.restfulbooker.api.booking.request.GetBookingsRequest;
import com.herokuapp.restfulbooker.api.booking.request.PostBookingRequest;
import com.herokuapp.restfulbooker.api.booking.response.GetBookingsResponse;
import com.herokuapp.restfulbooker.api.booking.response.PostBookingResponse;
import com.herokuapp.restfulbooker.api.booking.verification.PostBookingVerification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteBookingTest {

    private static int bookingId;
    private static PostBookingPayload payload;
    private static String token;

    @BeforeAll
    public static void setup() {
        payload = PostBookingPayload.getDefaultPostBooking();
        token = PostAuthRequest.createAuthToken(PostAuthPayload.getDefaultAuthPayload()).getToken();
    }

    @Test
    void shouldDeleteExistingBooking() {
        PostBookingResponse response = PostBookingRequest.createBooking(payload);
        bookingId = response.getBookingid();
        PostBookingVerification.verifyCreateBookingResponse(response, payload);

        assertThat(getAllBookingIds()).contains(bookingId);

        int deleteStatusCode = DeleteBookingRequest.deleteBooking(bookingId, token);
        assertThat(deleteStatusCode).isEqualTo(HttpStatus.SC_NO_CONTENT); // TODO SC_OK

        assertThat(getAllBookingIds()).doesNotContain(bookingId);
    }

    private List<Integer> getAllBookingIds() {
        List<GetBookingsResponse> getBookingsResponse = GetBookingsRequest.readAllBookings();
        return getBookingsResponse.stream()
                .map(GetBookingsResponse::getBookingid)
                .sorted()
                .collect(Collectors.toList());
    }
}
