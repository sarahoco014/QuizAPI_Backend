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


// the reason why answers didn't show on postico is because we didn't save them to answerRepository, with this change now answers show on both postico and postman (for questions made in the dataloader).
//        );
        Question question1= new Question(
                "What is the world's longest river?",
                Arrays.asList(
                        answerRepository.save(new Answer("Nile", true)),
                        answerRepository.save(new Answer("Thames", false)),
                        answerRepository.save(new Answer("Amazon", false))
                )
        );

        questionRepository.save(question1);


        Question question2 = new Question(
                "What is the highest mountain in the world?",
                Arrays.asList(
                        answerRepository.save(new Answer("Kilimanjaro", false)),
                        answerRepository.save(new Answer("Mount Everest", true)),
                        answerRepository.save(new Answer("Ben Nevis", false))
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
        quiz1.getQuestions().add(questionRepository.findById(1).get());
        quiz1.getQuestions().add(questionRepository.findById(2).get());
//        quiz1.getQuestions().add(question2);
        quiz1.setCurrentPlayer(player1);
        quizRepository.save(quiz1);



    }
}
