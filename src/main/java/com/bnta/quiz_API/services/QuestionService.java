package com.bnta.quiz_API.services;

import com.bnta.quiz_API.models.Question;
import com.bnta.quiz_API.models.QuestionDTO;
import com.bnta.quiz_API.repositories.AnswerRepository;
import com.bnta.quiz_API.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

//    CREATE - NEW QUESTION
//    public void addQuestion(QuestionDTO questionDTO){
//    Question question = new Question(questionDTO.getQuestionText(), questionDTO.getMultipleChoices());
//    questionRepository.save(question);
//    }
    public void createQuestion(QuestionDTO questionDTO, AnswerDTO answerDTO1, AnswerDTO answerDTO2, AnswerDTO answerDTO3){
        Question question = new Question(
            questionDTO.getQuestionText(),
            Arrays.asList(
                    answerRepository.save(new Answer(answerDTO1.getAnswerText(),answerDTO1.isCorrectAnswer())),
                    answerRepository.save(new Answer(answerDTO2.getAnswerText(),answerDTO2.isCorrectAnswer())),
                    answerRepository.save(new Answer(answerDTO3.getAnswerText(),answerDTO3.isCorrectAnswer()))
            )
        );
         questionRepository.save(question); // added this method that replicate how we do it in the dataloader but it is not working the same way, we may have to just have a question not take in answers as params and the multiple choices one by one.
    }

//    READ - INDEXES
    public List<Question> getAllQuestions(){
        return   questionRepository.findAll();
    }

//    READ - SHOW BY ID
    public Question getQuestionById(int id){
        return  questionRepository.findById(id).get();
    }

    // get answers by question (would)

//    DELETE - QUESTION
    public void deleteQuestion(int id){
        Question question = questionRepository.findById(id).get();
        questionRepository.deleteById(id);
    }

//    public void updateQuestion(QuestionDTO questionDTO, int id){
//        Question questionToUpdate = questionRepository.findById(id).get();
//        questionToUpdate.setQuestionText(questionDTO.getQuestionText());
//        questionToUpdate.setMultipleChoices(questionDTO.getMultipleChoices());
//    }

//    updating a question would change all the questions in all quizzes, there is no need,
//    only create and delete to avoid changing the history of player quizzes

}
