package com.bnta.quiz_API.models;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "correct_answer")
    private boolean correctAnswer;


    public Answer( String answerText, boolean correctAnswer) {
        this.answerText = answerText;
        this.correctAnswer = correctAnswer;
    }

    public Answer() {
    }


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
}
