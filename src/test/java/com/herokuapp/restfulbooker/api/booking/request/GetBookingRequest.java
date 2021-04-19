package com.herokuapp.restfulbooker.api.booking.request;

import com.herokuapp.restfulbooker.BaseRequest;
import com.herokuapp.restfulbooker.api.booking.response.GetBookingResponse;
import com.herokuapp.restfulbooker.url.BookingUrl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

import static com.herokuapp.restfulbooker.url.BookingUrl.BOOKING;
import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetBookingRequest extends BaseRequest {

    public static GetBookingResponse readBookingById(long bookingId) {

        return given()
                .spec(requestSetup())
                .when()
                .get(BookingUrl.BOOKING + "/" + bookingId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().ifError()
                .extract()
                .response()
                .getBody()
                .as(GetBookingResponse.class);
    }
}
