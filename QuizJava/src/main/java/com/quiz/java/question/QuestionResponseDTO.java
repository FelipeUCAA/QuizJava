package com.quiz.java.question;

public record QuestionResponseDTO(Integer id, String questionText, Integer correctAnswerIndex, String answer1, String answer2, String answer3, String answer4 ) {
    
    public QuestionResponseDTO(Question question){
        this(question.getId(), question.getQuestionText(), question.getCorrectAnswerIndex(), question.getAnswer1(), question.getAnswer2(), question.getAnswer3(), question.getAnswer4());
    }
        
}
