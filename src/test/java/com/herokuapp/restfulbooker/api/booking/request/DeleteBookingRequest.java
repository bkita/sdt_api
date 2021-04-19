package com.herokuapp.restfulbooker.api.booking.request;

import com.herokuapp.restfulbooker.BaseRequest;
import com.herokuapp.restfulbooker.url.BookingUrl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteBookingRequest extends BaseRequest {

    public static int deleteBooking(long bookingId, String token) {

        return given()
                .spec(requestSetupWithToken(token))
                .when()
                .delete(BookingUrl.BOOKING + "/" + bookingId)
                .then()
                .extract()
                .response()
                .getStatusCode();
    }
}
