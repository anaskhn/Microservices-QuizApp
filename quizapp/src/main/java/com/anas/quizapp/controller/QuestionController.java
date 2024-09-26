package com.anas.quizapp.controller;

import com.anas.quizapp.model.question;
import com.anas.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody question quest){
        return questionService.addQuestion(quest);
    }
}
