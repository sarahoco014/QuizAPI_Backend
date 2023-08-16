package com.bnta.quiz_API.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String answerText;

    @Column(name = "correct_answer")
    private boolean correctAnswer;

    @JsonIgnoreProperties({"multipleChoices"})
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer( String answerText, boolean correctAnswer, Question question) {
        this.answerText = answerText;
        this.correctAnswer = correctAnswer;
        this.question = question;
    }

    public Answer() {}


    //    Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
