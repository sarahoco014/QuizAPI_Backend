package com.bnta.quiz_API.controllers;

import com.bnta.quiz_API.models.*;
import com.bnta.quiz_API.services.PlayerService;
import com.bnta.quiz_API.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizzes")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    PlayerService playerService;

//    CREATE - QUIZ
    @PostMapping
    public ResponseEntity<List<Quiz>> createQuiz(@RequestBody QuizDTO quizDTO ){
        quizService.addQuiz(quizDTO);
        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.CREATED);
    }

//    GET - INDEX
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.OK);
    }

//    GET - SHOW BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable int id) {
        return new ResponseEntity<>(quizService.getQuizById(id), HttpStatus.OK);
    }

//    GET - SHOW QUESTIONS BY QUIZ ID
    @GetMapping("/{id}/questions")
    public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable int id) {
        return new ResponseEntity<>(quizService.listQuizQuestions(id), HttpStatus.OK);
    }

//    UPDATE - HANDLE GUESS
    @PostMapping("/{quizId}")
    public ResponseEntity<String> handleGuess(@PathVariable int quizId, @RequestBody PlayerGuessDTO playerGuessDTO) {
        return new ResponseEntity(quizService.handleGuess(playerGuessDTO, quizId), HttpStatus.OK);
    }

//    UPDATE - ADD QUESTION TO QUIZ
    @PatchMapping("/{id}/add-question/{questionId}")
    public ResponseEntity<Quiz> addQuestionToQuiz(@PathVariable int id, @PathVariable int questionId) {
        quizService.addQuestionToQuiz(questionId, id);
        return new ResponseEntity<>(quizService.getQuizById(id), HttpStatus.OK);
    }

//    UPDATE - ADD PLAYER TO QUIZ
    @PatchMapping("/{id}/add-player/{playerId}")
    public ResponseEntity<Player> addPlayerToQuiz(@PathVariable int id, @PathVariable int playerId) {
        quizService.addPlayerToQuiz(playerId, id);
        return new ResponseEntity<>(playerService.getPlayerById(playerId), HttpStatus.OK);
    }

//    DELETE - DELETE QUIZ
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteQuiz(@PathVariable Integer id) {
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

