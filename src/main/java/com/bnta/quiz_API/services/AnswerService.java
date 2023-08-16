package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.Answer;
import com.bnta.quiz_API.models.AnswerDTO;
import com.bnta.quiz_API.repositories.AnswerRepository;
import com.bnta.quiz_API.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    public void addAnswer(AnswerDTO answerDTO, int questionId){
        Answer answer = new Answer(answerDTO.getAnswerText(), answerDTO.isCorrectAnswer(),questionRepository.findById(questionId).get());
        answerRepository.save(answer);
    }

    public void updateAnswer(AnswerDTO answerDTO, int answerId){
        Answer answerToUpdate = answerRepository.findById(answerId).get();
        answerToUpdate.setAnswerText(answerDTO.getAnswerText());
        answerToUpdate.setCorrectAnswer(answerDTO.isCorrectAnswer());
        answerRepository.save(answerToUpdate);
    }

    public void deleteAnswer(int answerId){
        answerRepository.deleteById(answerId);
    }
}
