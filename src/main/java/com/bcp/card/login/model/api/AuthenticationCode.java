package com.bcp.card.login.model.api;

import lombok.Data;

@Data
public class AuthenticationCode {

    private String code;
    private String email;

}
