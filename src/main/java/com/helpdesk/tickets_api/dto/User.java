package com.helpdesk.tickets_api.dto;

import com.helpdesk.tickets_api.configuration.SystemUserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String username;


    public static User fromUserDetails(SystemUserDetails systemUserDetails) {
        return new User(systemUserDetails.getId(), systemUserDetails.getUsername());
    }

}
