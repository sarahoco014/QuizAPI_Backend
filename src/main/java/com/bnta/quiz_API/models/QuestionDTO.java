package com.bnta.quiz_API.models;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {

    private String questionText;

    private List<String> multipleChoices;

    private List<Quiz> quizzes;




    public QuestionDTO() {}


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



