package com.bnta.quiz_API.models;

public class PlayerGuessDTO {

    private String guess;

    public PlayerGuessDTO(String guess){
        this.guess = guess;
    }

    public PlayerGuessDTO() {}

//    GETTERS AND SETTERS
    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
}
