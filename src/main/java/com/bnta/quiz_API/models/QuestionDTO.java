package com.bnta.quiz_API.models;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {

    private String questionText;

    private String correctAnswer;

    private String fact;

    private List<String> options;

    private List<Quiz> quizzes;


    public QuestionDTO(String questionText, String correctAnswer, List<String> options, String fact) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.quizzes = new ArrayList<>();
        this.fact = fact;
    }

    public QuestionDTO(){}

//    GETTERS AND SETTERS
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}



