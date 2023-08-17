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



//        CREATING QUESTIONS
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

        Question question4 = new Question(
                "What country has the most natural lakes?",
                "Canada",
                Arrays.asList(
                        "Canada",
                        "China",
                        "Brazil"
                )
        );
        questionRepository.save(question4);

        Question question5 = new Question(
                "How many time zones does Russia have?",
                "11",
                Arrays.asList(
                        "9",
                        "10",
                        "11"
                )
        );
        questionRepository.save(question5);

        Question question6 = new Question(
                "What is the name of the largest city in Australia?",
                "Brisbane",
                Arrays.asList(
                        "Brisbane",
                        "Melbourne",
                        "Sydney"
                )
        );
        questionRepository.save(question6);

        Question question7 = new Question(
                "In which city was the first marathon held?",
                "Athens",
                Arrays.asList(
                        "Rome",
                        "Athens",
                        "London"
                )
        );
        questionRepository.save(question7);

        Question question8 = new Question(
                "In what ocean is the Bermuda Triangle located?",
                "Atlantic Ocean",
                Arrays.asList(
                        "Pacific Ocean",
                        "Atlantic Ocean",
                        "Arctic Ocean"
                )
        );
        questionRepository.save(question8);

        Question question9 = new Question(
                "In which UK city would you find the river Clyde?",
                "Glasgow",
                Arrays.asList(
                        "Edinburgh",
                        "Aberdeen",
                        "Glasgow"
                )
        );
        questionRepository.save(question9);

        Question question10 = new Question(
                "Which continent is in all four hemispheres?",
                "Africa",
                Arrays.asList(
                        "South America",
                        "Asia",
                        "Africa"
                )
        );
        questionRepository.save(question10);


//        CREATING PLAYERS
        Player player1 = new Player("Jon");
        Player player2 = new Player("Jenifer");
        playerRepository.save(player1);
        playerRepository.save(player2);


//        ADDING QUESTIONS TO QUIZZES
        Quiz quiz1 = new Quiz();
        quiz1.getQuestions().add(questionRepository.findById(1).get());
        quiz1.getQuestions().add(questionRepository.findById(2).get());
        quiz1.getQuestions().add(questionRepository.findById(3).get());
        quiz1.getQuestions().add(questionRepository.findById(4).get());
        quiz1.getQuestions().add(questionRepository.findById(5).get());

        Quiz quiz2 = new Quiz();
        quiz2.getQuestions().add(questionRepository.findById(6).get());
        quiz2.getQuestions().add(questionRepository.findById(7).get());
        quiz2.getQuestions().add(questionRepository.findById(8).get());
        quiz2.getQuestions().add(questionRepository.findById(9).get());
        quiz2.getQuestions().add(questionRepository.findById(10).get());

//        ADDING PLAYER TO QUIZZES
        quiz1.setCurrentPlayer(player1);
        quizRepository.save(quiz1);
        quizRepository.save(quiz2);

    }
}
