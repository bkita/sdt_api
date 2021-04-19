package com.herokuapp.restfulbooker.api.auth.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostAuthResponse {

    private String token;
}
