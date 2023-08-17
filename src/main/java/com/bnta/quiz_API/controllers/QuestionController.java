package com.bnta.quiz_API.controllers;


import com.bnta.quiz_API.models.Question;
import com.bnta.quiz_API.models.QuestionDTO;
import com.bnta.quiz_API.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

//    CREATE - Question
    @PostMapping
    public ResponseEntity<List<Question>> addQuestion(@RequestBody QuestionDTO questionDTO){
        questionService.addQuestion(questionDTO);
        return new ResponseEntity(questionService.getAllQuestions(), HttpStatus.CREATED);
    }

//    GET - INDEXES
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

//    GET - SHOW BY INDEX
    @GetMapping(value = "/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id){
       Question question = questionService.getQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

//    DELETE - Question
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deleteQuestion(@PathVariable Integer id){
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}

