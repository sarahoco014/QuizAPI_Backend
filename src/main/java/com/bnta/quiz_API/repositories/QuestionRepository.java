package com.bnta.quiz_API.repositories;

import com.bnta.quiz_API.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Integer> {
}
