package com.bnta.quiz_API.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "question_id")
//    For the flight and passengers example, we had:
//    @ManyToMany
//    @JoinTable(
//            name = "flights_passengers", ---> "question_quizzes"
//            joinColumns = @JoinColumn(name = "flight_id"), ---> name = "quiz_id"
//            inverseJoinColumns = @JoinColumn(name = "passenger_id")) ---> name = "question_id"
//    @JsonIgnoreProperties({"passengers"}) ---> "questions"
//    private List<Passenger> passengers; ---> private List<Question> questions;
//    what's after the ---> refers to what we would have, the Question class would have the mappedBy "questions" referring to the List of questions below
    private List<Question> questions;

    @Column(name = "current_question_index")
    private int currentQuestionIndex;

    @Column(name = "current_player")
    private Player currentPlayer;

    @Column
    private boolean finished;

    @Column
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.currentPlayer = null;
        this.finished = false;
        this.score = 0;
    }

//    public Quiz(){
//
//    } This empty constructor gave us an error, we assumed it's because the Quiz constructor does not take any params anyway


    //    Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
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
