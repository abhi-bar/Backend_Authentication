package com.example.quiz_security.service;

import com.example.quiz_security.config.PassConfig;
import com.example.quiz_security.entity.UserEntity;
import com.example.quiz_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserLoginService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    PassConfig passConfig;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Trying to load user with email: " + email);
        UserEntity userEntity = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"+email));
        return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole())
                .build();
    }

    public String registerUser(UserEntity userEntity){
        userEntity.setPassword(passConfig.passwordEncoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);
        return "User saved";
    }
}
