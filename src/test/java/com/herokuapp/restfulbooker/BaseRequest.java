package com.herokuapp.restfulbooker;

import com.herokuapp.restfulbooker.url.BookingUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    protected static RequestSpecification requestSetup() {

        return new RequestSpecBuilder()
                .setBaseUri(BookingUrl.BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    protected static RequestSpecification requestSetupWithToken(String token) {

        return new RequestSpecBuilder()
                .setBaseUri(BookingUrl.BASE_URL)
                .setContentType(ContentType.JSON)
                .addCookie("token", token)
                .build();
    }
}
