package com.example.quiz_security.service;

import com.example.quiz_security.entity.QuizQuestionEntity;
import com.example.quiz_security.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuizRepository quizRepository;

    public List<QuizQuestionEntity> getAllQuestions(){
        List<QuizQuestionEntity> quizRepositoryAll = quizRepository.findAll();
        return quizRepositoryAll;
    }

    public QuizQuestionEntity saveQuestion(QuizQuestionEntity question){
        QuizQuestionEntity save = quizRepository.save(question);
        return save;
    }
}
