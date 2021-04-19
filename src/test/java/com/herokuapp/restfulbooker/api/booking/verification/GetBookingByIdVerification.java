package com.herokuapp.restfulbooker.api.booking.verification;

import com.herokuapp.restfulbooker.api.booking.payload.PostBookingPayload;
import com.herokuapp.restfulbooker.api.booking.response.GetBookingResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingByIdVerification {

    public static void verifyGetBookingByIdResponse(GetBookingResponse response, PostBookingPayload payload) {
        assertThat(response.getFirstname()).isEqualTo(payload.getFirstname());
        assertThat(response.getLastname()).isEqualTo(payload.getLastname());
        assertThat(response.getTotalprice()).isEqualTo(payload.getTotalprice());
        assertThat(response.isDepositpaid()).isEqualTo(payload.getDepositpaid()); //TODO fix
        assertThat(response.getAdditionalneeds()).isEqualTo(payload.getAdditionalneeds());
        assertThat(response.getBookingdates().getCheckin()).isEqualTo(payload.getBookingdates().getCheckin());
        assertThat(response.getBookingdates().getCheckout()).isEqualTo(payload.getBookingdates().getCheckout());
    }
}
