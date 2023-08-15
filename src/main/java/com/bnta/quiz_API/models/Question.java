package com.bnta.quiz_API.models;

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

    @OneToMany(mappedBy = "question") // come back here later??
    private List<Answer> multipleChoices;

    @Column // ??
    @Enumerated(EnumType.STRING)
    private AnswerStatus status;

    @ManyToMany(mappedBy = "quiz_id")
    private List<Quiz> quizzes;

    private Question (String questionText, List<Answer> multipleChoices){
        this.questionText = questionText;
        this.multipleChoices = new ArrayList<Answer>();
        this.status = status.UNANSWERED;
        this.quizzes = new ArrayList<>();
    }

    public Question(){}


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
