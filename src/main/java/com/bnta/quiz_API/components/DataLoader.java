package com.bnta.quiz_API.components;

import com.bnta.quiz_API.models.Answer;
import com.bnta.quiz_API.models.Player;
import com.bnta.quiz_API.models.Question;
import com.bnta.quiz_API.models.Quiz;
import com.bnta.quiz_API.repositories.AnswerRepository;
import com.bnta.quiz_API.repositories.PlayerRepository;
import com.bnta.quiz_API.repositories.QuestionRepository;
import com.bnta.quiz_API.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        // Create a question with its answers

        Question question1 = new Question(
                "What is the world's longest river?",
                Arrays.asList(
                        new Answer("Nile", true),
                        new Answer("Thames", false),
                        new Answer("Amazon", false)
                )
        );
        questionRepository.save(question1);


        Question question2 = new Question(
                "What is the highest mountain in the world?",
                Arrays.asList(
                        new Answer("Kilimanjaro", false),
                        new Answer("Mount Everest", true),
                        new Answer("Ben Nevis", false)
                )
        );
        questionRepository.save(question2);



        // Create a player

        Player player1 = new Player("Jon");
        Player player2 = new Player("Jenifer");
        playerRepository.save(player1);
        playerRepository.save(player2);

        // Create quiz
        // Add player to quiz
        // Add question to quiz

        Quiz quiz1 = new Quiz();
        quiz1.getQuestions().add(question1);
        quiz1.getQuestions().add(question2);
        quiz1.setCurrentPlayer(player1);
        quizRepository.save(quiz1);



    }
}
