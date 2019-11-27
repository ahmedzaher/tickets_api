package com.helpdesk.tickets_api.model;

import lombok.Data;

@Data
public class JwtRequest {

    private String username;
    private String password;
}
