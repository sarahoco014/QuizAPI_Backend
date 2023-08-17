package com.bnta.quiz_API.components;

import com.bnta.quiz_API.models.Player;
import com.bnta.quiz_API.models.Question;
import com.bnta.quiz_API.models.Quiz;
import com.bnta.quiz_API.repositories.PlayerRepository;
import com.bnta.quiz_API.repositories.QuestionRepository;
import com.bnta.quiz_API.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        // Create a question with its answers

        Question question1 = new Question(
                "What is the world's longest river?",
                "Nile",
                Arrays.asList(
                        "Thames",
                        "Nile",
                        "Amazon"
                )
        );
        questionRepository.save(question1);

        Question question2 = new Question(
                "What is the world's highest mountain?",
                "Mount Everest",
                Arrays.asList(
                        "Ben Nevis",
                        "Mount Everest",
                        "Kilimanjaro"
                )
        );
        questionRepository.save(question2);

        Question question3 = new Question(
                "What is the world's largest country?",
                "Russia",
                Arrays.asList(
                        "China",
                        "Russia",
                        "USA"
                )
        );
        questionRepository.save(question3);


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
        Quiz quiz2 = new Quiz();
        quiz2.getQuestions().add(questionRepository.findById(1).get());
        quiz2.getQuestions().add(questionRepository.findById(2).get());
//        quiz1.getQuestions().add(question2);
        quiz1.setCurrentPlayer(player1);
        quizRepository.save(quiz1);
        quizRepository.save(quiz2);



    }
}
