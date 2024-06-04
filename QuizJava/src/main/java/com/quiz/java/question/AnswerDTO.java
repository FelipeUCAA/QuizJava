package com.quiz.java.question;

public class AnswerDTO {
    private Integer questionId;
    private Integer selectedAnswerIndex;

    
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getSelectedAnswerIndex() {
        return selectedAnswerIndex;
    }

    public void setSelectedAnswerIndex(Integer selectedAnswerIndex) {
        this.selectedAnswerIndex = selectedAnswerIndex;
    }
}
