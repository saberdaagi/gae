package com.teckup.security.service;


import com.teckup.core.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(User user);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
