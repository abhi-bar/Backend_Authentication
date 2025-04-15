package com.example.quiz_security.repo;

import com.example.quiz_security.entity.QuizQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizQuestionEntity,Long> {

}
