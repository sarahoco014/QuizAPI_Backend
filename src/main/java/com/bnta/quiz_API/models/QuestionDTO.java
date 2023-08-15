package com.bnta.quiz_API.models;

public class QuestionDTO {

    private AnswerStatus status;

    public QuestionDTO(AnswerStatus status) {
        this.status = status;
    }

    public QuestionDTO() {
    }

    public AnswerStatus getStatus() {
        return status;
    }

    public void setStatus(AnswerStatus status) {
        this.status = status;
    }
}



