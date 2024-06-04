package com.quiz.java.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    private Map<String, Integer> scores = new HashMap<>();

    public void updateScore(String playerId, boolean isCorrect) {
        scores.putIfAbsent(playerId, 0);
        if (isCorrect) {
            scores.put(playerId, scores.get(playerId) + 1);
        }
    }

    public int getScore(String playerId) {
        return scores.getOrDefault(playerId, 0);
    }
}

