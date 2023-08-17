package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.*;
import com.bnta.quiz_API.repositories.PlayerRepository;
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

//    READ - SHOW QUESTIONS BY QUIZ
    public List<Question> listQuizQuestions(int id){
        Quiz quiz = quizRepository.findById(id).get();
        return quiz.getQuestions();
    }



//    UPDATE - UPDATE QUIZ QUESTIONS
//    public void updateQuizQuestions(QuizDTO quizDTO, int id){
//        Quiz quizQuestionsToUpdate = quizRepository.findById(id).get();
//        quizQuestionsToUpdate.setQuestions();
//    }


    public AnswerStatus handleGuess(PlayerGuessDTO playerGuessDTO, int id) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            Question currentQuestion = quiz.getQuestions().get(quiz.getCurrentQuestionIndex());
            // Assuming the correct answer has the property correctAnswer set to true
            Optional<Answer> correctAnswer = currentQuestion.getMultipleChoices()
                    .stream()
                    .filter(Answer::isCorrectAnswer)
                    .findFirst();
            if (correctAnswer.isPresent()) {
                if (correctAnswer.get().getAnswerText().equalsIgnoreCase(playerGuessDTO.getGuess())) {
                    // Correct answer
                    quiz.setScore(quiz.getScore() + 1); // Increase score by 1 or any logic you decide for scoring
                    quiz.setCurrentQuestionIndex(quiz.getCurrentQuestionIndex() + 1);

                    if (quiz.getCurrentQuestionIndex() == quiz.getQuestions().size()) {
                        quiz.setFinished(true);
                    }
                    quizRepository.save(quiz);
                    return AnswerStatus.CORRECT;

                } else {
                    // Incorrect answer
                    quiz.setCurrentQuestionIndex(quiz.getCurrentQuestionIndex() + 1);
                    if (quiz.getCurrentQuestionIndex() == quiz.getQuestions().size()) {
                        quiz.setFinished(true);
                    }
                    quizRepository.save(quiz);
                    return AnswerStatus.INCORRECT;
                }
            }
            if (playerGuessDTO.getGuess().equals("")) {
                return AnswerStatus.UNANSWERED;
            }
        }
        return AnswerStatus.UNANSWERED;
    }




//    UPDATE - ADD PLAYER TO QUIZ
    public void addPlayerToQuiz(int playerId, int quizId){
        Quiz quiz = quizRepository.findById(quizId).get();
        Player player = playerRepository.findById(playerId).get();
        quiz.setCurrentPlayer(player);
        quizRepository.save(quiz);
    }

    //    DELETE - DELETE QUIZ
    public void deleteQuiz(int id){
        quizRepository.deleteById(id);
    }

}
