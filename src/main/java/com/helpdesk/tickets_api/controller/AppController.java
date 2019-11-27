package com.helpdesk.tickets_api.controller;

import com.helpdesk.tickets_api.configuration.SystemUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public String index() {
        SystemUserDetails user = (SystemUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return String.format("Welcome %s", user.getUsername());
    }

}
