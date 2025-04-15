package com.example.quiz_security.controller;

import com.example.quiz_security.dto.AuthRequestDTO;
import com.example.quiz_security.entity.UserEntity;
import com.example.quiz_security.service.UserLoginService;
import com.example.quiz_security.util.Jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Jwtutil jwtutil;

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userLoginService.registerUser(user));
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequest){
        // Log the raw request body instead of the object
        System.out.println("AuthRequest object type: " + (authRequest == null ? "null" : authRequest.getClass().getName()));
        if (authRequest != null) {
            System.out.println("Email field: " + authRequest.getEmail());
            System.out.println("Password field: " + authRequest.getPassword());
        } else {
            System.out.println("AuthRequest is null");
        }
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtutil.generateToken(userDetails.getUsername(), userDetails.getAuthorities().iterator().next().getAuthority());
        return ResponseEntity.ok(Map.of("token", token));
    }

}
