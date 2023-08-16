package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.Answer;
import com.bnta.quiz_API.models.AnswerDTO;
import com.bnta.quiz_API.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public void addAnswer(AnswerDTO answerDTO){
        Answer answer = new Answer(answerDTO.getAnswerText(), answerDTO.isCorrectAnswer());
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
