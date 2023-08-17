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

    @Column(name = "multiple_choices")
    private List<String> multipleChoices;

    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private List<Quiz> quizzes;

    public Question (String questionText, List<String> multipleChoices){
        this.questionText = questionText;
        this.multipleChoices = multipleChoices;
        this.quizzes = new ArrayList<>();
    }

    public Question(){}


//    Getters and setters
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

    public List<String> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(List<String> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
