package com.bnta.quiz_API.components;

import com.bnta.quiz_API.models.Answer;
import com.bnta.quiz_API.models.Player;
import com.bnta.quiz_API.models.Question;
import com.bnta.quiz_API.repositories.AnswerRepository;
import com.bnta.quiz_API.repositories.PlayerRepository;
import com.bnta.quiz_API.repositories.QuestionRepository;
import com.bnta.quiz_API.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Create a question

        Question question1 = new Question("What is the world's longest river?");
        questionRepository.save(question1);

        // Create answers

        Answer answer1 = new Answer("Nile", true, question1);
        Answer answer2 = new Answer("Thames", false, question1);
        Answer answer3 = new Answer("Amazon", false, question1);
        answerRepository.save(answer1);
        answerRepository.save(answer2);
        answerRepository.save(answer3);

        // Create a player

        // Add player to quiz

        // Add question to quiz

    }
}
