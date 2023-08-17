package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.*;
import com.bnta.quiz_API.repositories.PlayerRepository;
import com.bnta.quiz_API.repositories.QuestionRepository;
import com.bnta.quiz_API.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    QuestionRepository questionRepository;


//    CREATE - NEW QUIZ
    public Quiz addQuiz(QuizDTO quizDTO){
        Quiz quizToSave = new Quiz();
        quizRepository.save(quizToSave);
        return quizToSave;
    }

//    READ - INDEXES
    public List<Quiz> getAllQuizzes(){
        return quizRepository.findAll();
    }

//    READ - SHOW BY ID
    public Quiz getQuizById(int id){
        return quizRepository.findById(id).get();
    }

//    READ - SHOW QUESTIONS BY QUIZ ID
    public List<Question> listQuizQuestions(int id){
        Quiz quiz = quizRepository.findById(id).get();
        return quiz.getQuestions();
    }



    public String handleGuess(PlayerGuessDTO playerGuessDTO, int id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id); // Optional because we want to check if the quiz exists

        String output= "";

//        IF QUIZ EXISTS GET QUESTION AND THE CORRECT ANSWER
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            Question currentQuestion = quiz.getQuestions().get(quiz.getCurrentQuestionIndex());
            String correctAnswer = currentQuestion.getCorrectAnswer();

//            CHECKING IF GUESS IS EMPTY
            if (playerGuessDTO.getGuess().isEmpty() || playerGuessDTO.getGuess().equals("")) {
                output = "Unanswered, please guess again";
            }

//            CHECKING IF GUESS IS CORRECT
            else if (correctAnswer.equalsIgnoreCase(playerGuessDTO.getGuess())) {
                quiz.setScore(quiz.getScore() + 1); // Increase score by 1 or any logic you decide for scoring
                quiz.setCurrentQuestionIndex(quiz.getCurrentQuestionIndex() + 1);

//                CHECKING IF QUIZ IS FINISHED
                if (quiz.getCurrentQuestionIndex() == quiz.getQuestions().size()) {
                    quiz.setFinished(true);
                }
                quizRepository.save(quiz);
                output = "That is correct!";
            }

//            SETTING GUESS AS INCORRECT
            else {
                quiz.setCurrentQuestionIndex(quiz.getCurrentQuestionIndex() + 1);

//                CHECKING IF QUIZ IS FINISHED
                if (quiz.getCurrentQuestionIndex() == quiz.getQuestions().size()) {
                    quiz.setFinished(true);
                }
                quizRepository.save(quiz);
                output = "That is incorrect!";
            }
        }
        return output;
    }

//    UPDATE - ADD PLAYER TO QUIZ
    public void addPlayerToQuiz(int playerId, int quizId){
        Quiz quiz = quizRepository.findById(quizId).get();
        Player player = playerRepository.findById(playerId).get();
        quiz.setCurrentPlayer(player);
        quizRepository.save(quiz);
    }

//    UPDATE - ADD QUESTION TO QUIZ
    public void addQuestionToQuiz(int questionId, int quizId){
        Quiz quiz = quizRepository.findById(quizId).get();
        Question question = questionRepository.findById(questionId).get();
        quiz.getQuestions().add(question);
        quizRepository.save(quiz);
    }

    //    DELETE - DELETE QUIZ
    public void deleteQuiz(int id){
        quizRepository.deleteById(id);
    }

}
