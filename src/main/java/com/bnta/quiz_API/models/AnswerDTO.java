package com.bnta.quiz_API.models;

public class AnswerDTO {

    private String answerText;

    private boolean correctAnswer;

    private Question question;

    public AnswerDTO(String answerText, boolean correctAnswer, Question question){
        this.answerText = answerText;
        this.correctAnswer = correctAnswer;
        this.question = question; // comeback
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
