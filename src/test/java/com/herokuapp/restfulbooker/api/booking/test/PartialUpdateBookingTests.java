package com.herokuapp.restfulbooker.api.booking.test;

import com.herokuapp.restfulbooker.api.auth.payload.PostAuthPayload;
import com.herokuapp.restfulbooker.api.auth.request.PostAuthRequest;
import com.herokuapp.restfulbooker.api.booking.payload.PostBookingPayload;
import com.herokuapp.restfulbooker.api.booking.request.PatchBookingRequest;
import com.herokuapp.restfulbooker.api.booking.request.PostBookingRequest;
import com.herokuapp.restfulbooker.api.booking.response.PatchBookingResponse;
import com.herokuapp.restfulbooker.api.booking.response.PostBookingResponse;
import com.herokuapp.restfulbooker.api.booking.verification.PostBookingVerification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PartialUpdateBookingTests {

    private static int bookingId;
    private static PostBookingPayload createPayload;
    private static String token;


    @BeforeAll
    public static void setup() {
        createPayload = PostBookingPayload.getDefaultPostBooking();
        token = PostAuthRequest.createAuthToken(PostAuthPayload.getDefaultAuthPayload()).getToken();
    }

    @Test
    void shouldCreateNewBooking() {
        PostBookingResponse response = PostBookingRequest.createBooking(createPayload);
        bookingId = response.getBookingid();
        PostBookingVerification.verifyCreateBookingResponse(response, createPayload);

        JSONObject updatePayload = new JSONObject();
        updatePayload.put("firstname", "Michael");

        PatchBookingResponse updateResponse = PatchBookingRequest.partialUpdateBooking(updatePayload, bookingId, token);
        assertThat(updateResponse.getFirstname()).isEqualTo("Michael");
    }
}
