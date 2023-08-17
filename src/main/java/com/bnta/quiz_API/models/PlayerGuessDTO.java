package com.bnta.quiz_API.models;

public class PlayerGuessDTO {

    private String guess;

    public PlayerGuessDTO(String guess){
        this.guess = guess;
    }

    public PlayerGuessDTO() {}

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
}
