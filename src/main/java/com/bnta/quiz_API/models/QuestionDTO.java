package com.bnta.quiz_API.models;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {

    private String questionText;

    private AnswerStatus status;

    private List<AnswerDTO> multipleChoices;

    private List<Quiz> quizzes;




    public QuestionDTO() {}


    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<AnswerDTO> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(List<AnswerDTO> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public AnswerStatus getStatus() {
        return status;
    }

    public void setStatus(AnswerStatus status) {
        this.status = status;
    }
}



