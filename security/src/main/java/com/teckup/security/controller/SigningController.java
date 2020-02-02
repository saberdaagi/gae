package com.teckup.security.controller;

import com.teckup.core.constants.Role;
import com.teckup.core.domain.Classe;
import com.teckup.security.dto.UserSigninDTO;
import com.teckup.core.domain.User;
import com.teckup.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SigningController {

    final UserService userService;


    @PostConstruct
    public void init() {
        if (!userService.existsByUsername("admin")){
        userService.save(new User(
            "admin",
            "admin@gmail.com",
            "admin",
            Role.ADMIN
        ));}
    }

    @PostMapping("/signup")
    public User signup(@RequestParam String username,
                       @RequestParam String email,
                       @RequestParam String password,
                       @RequestParam Role role) {
        return userService.save(new User(username, email, password, role));
    }

    @GetMapping("/signin")
    public ResponseEntity<UserSigninDTO> signin(@RequestParam(required=false,name="email") String email) {
        return ResponseEntity.ok(new UserSigninDTO(userService.existsByEmail(email)));
    }

}
