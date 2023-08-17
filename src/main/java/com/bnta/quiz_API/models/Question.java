package com.bnta.quiz_API.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "question_text")
    private String questionText;

    @Column (name = "correct_answer")
    private String correctAnswer; // The correct answer is included in the options list

    @Column
    private List<String> options; // Changed from a list of Answer objects to Strings, as it was easier to deal with.

    @JsonIgnore
    @ManyToMany(mappedBy = "questions") // Many questions to many quizzes
    private List<Quiz> quizzes;

    public Question (String questionText, String correctAnswer, List<String> options){
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.quizzes = new ArrayList<>();
    }

    public Question(){}

//    GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
