package com.quiz.java.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.java.question.Game;
import com.quiz.java.question.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public void saveGame(String playerId, int score) {
        Game game = new Game();
        game.setPlayerId(playerId);
        game.setScore(score);
        game.setDate(LocalDateTime.now());
        gameRepository.save(game);
    }

    public List<Game> getGameHistory(String playerId) {
        return gameRepository.findByPlayerId(playerId);
    }
}

