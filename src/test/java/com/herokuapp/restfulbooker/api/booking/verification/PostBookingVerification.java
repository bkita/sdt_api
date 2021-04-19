package com.herokuapp.restfulbooker.api.booking.verification;

import com.herokuapp.restfulbooker.api.booking.payload.PostBookingPayload;
import com.herokuapp.restfulbooker.api.booking.response.PostBookingResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class PostBookingVerification {

    public static void verifyCreateBookingResponse(PostBookingResponse response, PostBookingPayload payload) {
        assertThat(response.getBooking().getFirstname()).isEqualTo(payload.getFirstname());
        assertThat(response.getBooking().getLastname()).isEqualTo(payload.getLastname());
        assertThat(response.getBooking().getTotalprice()).isEqualTo(payload.getTotalprice());
        assertThat(response.getBooking().isDepositpaid()).isEqualTo(payload.getDepositpaid()); // TODO fix
        assertThat(response.getBooking().getAdditionalneeds()).isEqualTo(payload.getAdditionalneeds());
        assertThat(response.getBooking().getBookingdates().getCheckin()).isEqualTo(payload.getBookingdates().getCheckin());
        assertThat(response.getBooking().getBookingdates().getCheckout()).isEqualTo(payload.getBookingdates().getCheckout());
    }
}
