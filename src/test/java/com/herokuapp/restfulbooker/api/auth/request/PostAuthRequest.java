package com.herokuapp.restfulbooker.api.auth.request;

import com.herokuapp.restfulbooker.BaseRequest;
import com.herokuapp.restfulbooker.api.auth.payload.PostAuthPayload;
import com.herokuapp.restfulbooker.api.auth.response.PostAuthResponse;
import com.herokuapp.restfulbooker.url.BookingUrl;
import io.restassured.http.ContentType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostAuthRequest extends BaseRequest {

    public static PostAuthResponse createAuthToken(PostAuthPayload payload) {

        return given()
                .spec(requestSetup())
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(BookingUrl.AUTH)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().ifError()
                .extract()
                .response()
                .getBody()
                .as(PostAuthResponse.class);
    }
}
