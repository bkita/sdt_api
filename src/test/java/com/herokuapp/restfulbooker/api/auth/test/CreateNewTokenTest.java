package com.herokuapp.restfulbooker.api.auth.test;

import com.herokuapp.restfulbooker.api.auth.payload.PostAuthPayload;
import com.herokuapp.restfulbooker.api.auth.request.PostAuthRequest;
import com.herokuapp.restfulbooker.api.auth.response.PostAuthResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateNewTokenTest {

    @Test
    void shouldReturnNewTokenForValidCredentials() {
        PostAuthResponse authResponse = PostAuthRequest.createAuthToken(PostAuthPayload.getDefaultAuthPayload());
        assertThat(authResponse.getToken()).isNotEmpty();
    }
}
