package com.bnta.quiz_API.repositories;

import com.bnta.quiz_API.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository <Quiz, Integer> {


}
