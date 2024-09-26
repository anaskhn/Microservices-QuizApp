package com.anas.quizapp.dao;

import com.anas.quizapp.model.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface QuestionDao extends JpaRepository<question, Integer> {
    List<question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<question> findRandomQuestionsByCategory(String category, int numQ);
}
