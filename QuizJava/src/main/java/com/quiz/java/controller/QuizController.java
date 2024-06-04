package com.quiz.java.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiz.java.question.AnswerDTO;
import com.quiz.java.question.Game;
import com.quiz.java.question.Question;
import com.quiz.java.question.QuestionRepository;
import com.quiz.java.question.QuestionResponseDTO;
import com.quiz.java.service.GameService;
import com.quiz.java.service.QuizService;
import com.quiz.java.service.ScoreService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/start")
    public List<QuestionResponseDTO> startQuiz() {
        List<Question> questions = quizService.startNewQuiz();
        return questions.stream()
                .map(QuestionResponseDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/answer")
    public ResponseEntity<String> answerQuestion(@RequestBody AnswerDTO answer, @RequestParam String playerId) {
        Optional<Question> question = questionRepository.findById(answer.getQuestionId());
        if (question.isPresent()) {
            boolean isCorrect = question.get().getCorrectAnswerIndex().equals(answer.getSelectedAnswerIndex());
            scoreService.updateScore(playerId, isCorrect);
            return ResponseEntity.ok(isCorrect ? "Correct" : "Incorrect");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/score")
    public int getScore(@RequestParam String playerId) {
        return scoreService.getScore(playerId);
    }

    @Autowired
    private GameService gameService;

    @PostMapping("/finish")
    public ResponseEntity<Void> finishQuiz(@RequestParam String playerId) {
    int score = scoreService.getScore(playerId);
    gameService.saveGame(playerId, score);
    return ResponseEntity.noContent().build();
    }

    @GetMapping("/history")
    public List<Game> getGameHistory(@RequestParam String playerId) {
    return gameService.getGameHistory(playerId);
    }
}
