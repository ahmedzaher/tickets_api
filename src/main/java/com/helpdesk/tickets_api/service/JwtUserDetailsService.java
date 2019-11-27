package com.helpdesk.tickets_api.service;


import com.helpdesk.tickets_api.configuration.SystemUserDetails;
import com.helpdesk.tickets_api.model.SystemUser;
import com.helpdesk.tickets_api.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<SystemUser> user = systemUserRepository.findByUsername(username);

        user.orElseThrow( () -> new UsernameNotFoundException("User not found"));

        return user.map(SystemUserDetails::new).get();
    }

}
