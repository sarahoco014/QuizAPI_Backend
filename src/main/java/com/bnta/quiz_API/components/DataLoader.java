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
                ),
                "The Nile River is the longest river in the world, The Nile flows into the Mediterranean Sea., The Nile has a length of about 6,695 kilometers (4,160 miles), Its average discharge is 3.1 million litres (680,000 gallons) per second."
        );
        questionRepository.save(question1);

        Question question2 = new Question(
                "What is the world's highest mountain?",
                "Mount Everest",
                Arrays.asList(
                        "Ben Nevis",
                        "Mount Everest",
                        "Kilimanjaro"
                ), "At 8,849 meters (29,032 feet), it is considered the tallest point on Earth. In the nineteenth century, the mountain was named after George Everest, a former Surveyor General of India. The Tibetan name is Chomolungma, which means ‘Mother Goddess of the World.’ The Nepali name is Sagarmatha, which has various meanings."

        );
        questionRepository.save(question2);

        Question question3 = new Question(
                "What is the world's largest country?",
                "Russia",
                Arrays.asList(
                        "China",
                        "Russia",
                        "USA"
                ), "Russia, the largest country in the world, occupies one-tenth of all the land on Earth. It spans 11 time zones across two continents (Europe and Asia) and has coasts on three oceans (the Atlantic, Pacific, and Arctic). The Russian landscape varies from desert to frozen coastline, tall mountains to giant marshes."
        );
        questionRepository.save(question3);

        Question question4 = new Question(
                "What country has the most natural lakes?",
                "Canada",
                Arrays.asList(
                        "Canada",
                        "China",
                        "Brazil"
                ), "Of the 1.42 million lakes around the world with a size of over 0.1 sq. km, Canada is home to a whopping 62% of them."
        );
        questionRepository.save(question4);

        Question question5 = new Question(
                "How many time zones does Russia have?",
                "11",
                Arrays.asList(
                        "9",
                        "10",
                        "11"
                ), "There are eleven time zones in Russia, which currently observe times ranging from UTC+02:00 to UTC+12:00. Daylight saving time (DST) has not been used in Russia since 26 October 2014. From 27 March 2011 to 26 October 2014, permanent DST was used."
        );
        questionRepository.save(question5);

        Question question6 = new Question(
                "What is the name of the largest city in Australia?",
                "Brisbane",
                Arrays.asList(
                        "Brisbane",
                        "Melbourne",
                        "Sydney"
                ), "Perhaps one of the lesser-known facts about Brisbane is that it is home to the largest city hall in the country. Brisbane City Hall, which opened in 1930, is spread across two acres of land and took ten years to build. When completed, it was the second-largest construction of its time, after the Sydney Harbour Bridge."
        );
        questionRepository.save(question6);

        Question question7 = new Question(
                "In which city was the first marathon held?",
                "Athens",
                Arrays.asList(
                        "Rome",
                        "Athens",
                        "London"
                ), "0.01% of the global population have finished a marathon in their lifetime."
        );
        questionRepository.save(question7);

        Question question8 = new Question(
                "In what ocean is the Bermuda Triangle located?",
                "Atlantic Ocean",
                Arrays.asList(
                        "Pacific Ocean",
                        "Atlantic Ocean",
                        "Arctic Ocean"
                ), "The Bermuda Triangle is a section of the North Atlantic Ocean off North America in which more than 50 ships and 20 airplanes are said to have mysteriously disappeared. The area, whose boundaries are not universally agreed upon, has a triangular shape that reaches approximately from the Atlantic coast of Florida to Bermuda to the islands known as the Greater Antilles."
        );
        questionRepository.save(question8);

        Question question9 = new Question(
                "In which UK city would you find the river Clyde?",
                "Glasgow",
                Arrays.asList(
                        "Edinburgh",
                        "Aberdeen",
                        "Glasgow"
                ), "The River Clyde is one of the major rivers in Scotland, and is arguably the most well-known of the country’s rivers. It’s 170 km long, making it the third-longest river in the country, and the ninth-longest in the UK. It runs through the major city of Glasgow, and has been historically important to both Scotland and the British Empire, due to its significant roles in trade and shipbuilding."
        );
        questionRepository.save(question9);

        Question question10 = new Question(
                "Which continent is in all four hemispheres?",
                "Africa",
                Arrays.asList(
                        "South America",
                        "Asia",
                        "Africa"
                ), "Hardest Geezer is currently attempting to run the full length of the continent, from South to North."
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
