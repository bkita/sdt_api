package com.herokuapp.restfulbooker.api.auth.payload;

import com.herokuapp.restfulbooker.common.Credentials;
import lombok.Value;


@Value
public class PostAuthPayload {

    String username;
    String password;

    public static PostAuthPayload getDefaultAuthPayload() {
        return new PostAuthPayload(Credentials.USER_NAME, Credentials.PASSWORD);
    }
}
