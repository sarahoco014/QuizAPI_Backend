package com.bnta.quiz_API.controllers;

import com.bnta.quiz_API.models.Player;
import com.bnta.quiz_API.models.PlayerGuessDTO;
import com.bnta.quiz_API.models.Quiz;
import com.bnta.quiz_API.models.QuizDTO;
import com.bnta.quiz_API.services.PlayerService;
import com.bnta.quiz_API.services.QuestionService;
import com.bnta.quiz_API.services.QuizService;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @Autowired
    QuestionService questionService;


// CREATE - QUIZ

    @PostMapping
    public ResponseEntity<List<Quiz>> createQuiz(@RequestBody QuizDTO quizDTO ){
        quizService.addQuiz(quizDTO);
        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.CREATED);
    }


//    GET - get all quizzez

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.OK);
    }

//   GET - SHOW BY ID

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable int id) {
        return new ResponseEntity<>(quizService.getQuizById(id), HttpStatus.OK);
    }

// UPDATE - HandleGuess

    @PostMapping("/{quizId}")
    public ResponseEntity<String> handleGuess(@PathVariable int quizId, @RequestBody PlayerGuessDTO playerGuessDTO) {
        return new ResponseEntity(quizService.handleGuess(playerGuessDTO, quizId), HttpStatus.OK);
    }

// UPDATE - AddPlayerToQuiz

//    @PatchMapping("/{quizId}/{playerId}")
//    public ResponseEntity<Player> addPLayerToQuiz(@PathVariable Integer quizId, Integer playerId){
//        quizService.addPlayerToQuiz(playerId, quizId);
//        return new ResponseEntity<>(playerService.getPlayerById(playerId), HttpStatus.OK);
//
//    }

    @PatchMapping("/{id}/add-player/{playerId}")
    public ResponseEntity<Player> addPlayerToQuiz(@PathVariable int id, @PathVariable int playerId) {
        quizService.addPlayerToQuiz(playerId, id);
        return new ResponseEntity<>(playerService.getPlayerById(playerId), HttpStatus.OK);
    }

//    DELETE - Delete Quiz

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteQuiz(@PathVariable Integer id) {
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}

