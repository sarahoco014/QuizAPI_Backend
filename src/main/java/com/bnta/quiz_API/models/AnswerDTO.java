package com.bnta.quiz_API.models;

public class AnswerDTO {

    private String answerText;

    private boolean correctAnswer;

    public AnswerDTO(String answerText, boolean correctAnswer){
        this.answerText = answerText;
        this.correctAnswer = correctAnswer;
    }

    public AnswerDTO(){}

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
