package com.example.quiz_security.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "question_id")
public class QuizQuestionEntity {

    @Id
    private Long id;

    private String questionTest;

    private String correctAnswer;

    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "option_text")
    private List<String> optionText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTest() {
        return questionTest;
    }

    public void setQuestionTest(String questionTest) {
        this.questionTest = questionTest;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptionText() {
        return optionText;
    }

    public void setOptionText(List<String> optionText) {
        this.optionText = optionText;
    }
}
