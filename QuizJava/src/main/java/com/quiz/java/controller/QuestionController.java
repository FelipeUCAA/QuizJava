package com.quiz.java.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiz.java.question.Question;
import com.quiz.java.question.QuestionRepository;
import com.quiz.java.question.QuestionResponseDTO;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> getQuestionById(@PathVariable Integer id) {
        Optional<Question> question = repository.findById(id);
        return question.map(q -> ResponseEntity.ok(new QuestionResponseDTO(q)))
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<QuestionResponseDTO> createQuestion(@RequestBody Question question) {
        Question savedQuestion = repository.save(question);
        return ResponseEntity.ok(new QuestionResponseDTO(savedQuestion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponseDTO> updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) {
        Optional<Question> existingQuestion = repository.findById(id);
        if (existingQuestion.isPresent()) {
            updatedQuestion.setId(id);
            Question savedQuestion = repository.save(updatedQuestion);
            return ResponseEntity.ok(new QuestionResponseDTO(savedQuestion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
