package com.quiz.java.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.java.question.QuestionResponseDTO;
import com.quiz.java.question.Question;
import com.quiz.java.question.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository repository;

    @GetMapping
    public List<QuestionResponseDTO> getAll() {
        List<Question> questionList = repository.findAll();
        return questionList.stream()
                .map(QuestionResponseDTO::new)
                .collect(Collectors.toList());
    }
}
