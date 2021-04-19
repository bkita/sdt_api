package com.herokuapp.restfulbooker.api.booking.request;

import com.herokuapp.restfulbooker.BaseRequest;
import com.herokuapp.restfulbooker.api.booking.payload.PostBookingPayload;
import com.herokuapp.restfulbooker.api.booking.response.PostBookingResponse;
import com.herokuapp.restfulbooker.url.BookingUrl;
import io.restassured.http.ContentType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostBookingRequest extends BaseRequest {

    public static PostBookingResponse createBooking(PostBookingPayload payload) {

        return given()
                .spec(requestSetup())
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(BookingUrl.BOOKING)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().ifError()
                .extract()
                .response()
                .getBody()
                .as(PostBookingResponse.class);
    }
}
