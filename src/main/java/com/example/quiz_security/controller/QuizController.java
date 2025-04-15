package com.example.quiz_security.controller;

import com.example.quiz_security.entity.QuizQuestionEntity;
import com.example.quiz_security.entity.UserEntity;
import com.example.quiz_security.service.QuestionService;
import com.example.quiz_security.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class QuizController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/question")
    public List<QuizQuestionEntity> getQuestions(){
        return questionService.getAllQuestions();
    }

//    Takes values from request body

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    private QuizQuestionEntity saveQuestion(@RequestBody QuizQuestionEntity quizQuestionEntity){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User: " + auth.getName());
        System.out.println("Authorities: " + auth.getAuthorities());

        return questionService.saveQuestion(quizQuestionEntity);
    }


}
