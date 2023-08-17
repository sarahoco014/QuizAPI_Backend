package com.bnta.quiz_API.models;

public class QuizDTO {

    private int currentQuestionIndex;

    private boolean finished;

    private int score;

    public QuizDTO (int currentQuestionIndex, boolean finished, int score){
        this.currentQuestionIndex = 0;
        this.finished = false;
        this.score = 0;
    }

    public QuizDTO(){}

//    GETTERS AND SETTERS
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
