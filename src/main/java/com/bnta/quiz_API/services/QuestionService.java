package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.Question;
import com.bnta.quiz_API.models.QuestionDTO;
import com.bnta.quiz_API.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

//    CREATE - NEW QUESTION
    public void addQuestion(QuestionDTO questionDTO){
    Question question = new Question(questionDTO.getQuestionText(), questionDTO.getCorrectAnswer(), questionDTO.getOptions());
    questionRepository.save(question);
    }


//    READ - INDEXES
    public List<Question> getAllQuestions(){
        return   questionRepository.findAll();
    }

//    READ - SHOW BY ID
    public Question getQuestionById(int id){
        return  questionRepository.findById(id).get();
    }

    // get answers by question (would)

//    DELETE - QUESTION
    public void deleteQuestion(int id){
        Question question = questionRepository.findById(id).get();
        questionRepository.deleteById(id);
    }

//    public void updateQuestion(QuestionDTO questionDTO, int id){
//        Question questionToUpdate = questionRepository.findById(id).get();
//        questionToUpdate.setQuestionText(questionDTO.getQuestionText());
//        questionToUpdate.setMultipleChoices(questionDTO.getMultipleChoices());
//    }

//    updating a question would change all the questions in all quizzes, there is no need,
//    only create and delete to avoid changing the history of player quizzes

}
