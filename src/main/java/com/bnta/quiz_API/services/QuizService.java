package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.*;
import com.bnta.quiz_API.repositories.PlayerRepository;
import com.bnta.quiz_API.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    PlayerRepository playerRepository;


    public List<Quiz> getAllQuizzes(){
        return quizRepository.findAll();
    }

    public Quiz getQuizById(int id){
        return quizRepository.findById(id).get();
    }

    public Quiz saveQuiz(QuizDTO quizDTO){
        Quiz quizToSave = new Quiz();
        quizRepository.save(quizToSave);
        return quizToSave;
    }

    public void deleteQuiz(int id){
        quizRepository.deleteById(id);
    }

//    public void updateQuizQuestions(QuizDTO quizDTO, int id){
//        Quiz quizQuestionsToUpdate = quizRepository.findById(id).get();
//        quizQuestionsToUpdate.setQuestions();
//    }

    // need to do handel guess method!!

    public List<Question> listQuizQuestions(int id){
        Quiz quiz = quizRepository.findById(id).get();
        return quiz.getQuestions();
    }

    public void addQuiz(){
        Quiz newQuiz = new Quiz();
        quizRepository.save(newQuiz);
        }

    public void addPlayerToQuiz(int playerId, int quizId){
        Quiz quiz = quizRepository.findById(quizId).get();
        Player player = playerRepository.findById(playerId).get();
        quiz.setCurrentPlayer(player);
        quizRepository.save(quiz);
    }
        


}
