package com.bnta.quiz_API.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties({"question"})
    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Answer> multipleChoices;

    @Enumerated(EnumType.STRING)
    @Column
    private AnswerStatus status;

    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private List<Quiz> quizzes;

    public Question (String questionText, List<Answer> multipleChoices){
        this.questionText = questionText;
        this.multipleChoices = multipleChoices;
        this.status = AnswerStatus.UNANSWERED;
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

    public List<Answer> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(List<Answer> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public AnswerStatus getStatus() {
        return status;
    }

    public void setStatus(AnswerStatus status) {
        this.status = status;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
