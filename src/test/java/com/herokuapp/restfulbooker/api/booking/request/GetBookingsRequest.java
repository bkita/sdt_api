package com.herokuapp.restfulbooker.api.booking.request;

import com.herokuapp.restfulbooker.BaseRequest;
import com.herokuapp.restfulbooker.api.booking.response.GetBookingsResponse;
import com.herokuapp.restfulbooker.url.BookingUrl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static com.herokuapp.restfulbooker.url.BookingUrl.BOOKING;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetBookingsRequest extends BaseRequest {

    public static List<GetBookingsResponse> readAllBookings() {

        return Arrays.asList(given()
                .spec(requestSetup())
                .when()
                .get(BookingUrl.BOOKING)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().ifError()
                .extract()
                .response()
                .getBody()
                .as(GetBookingsResponse[].class));
    }
}
