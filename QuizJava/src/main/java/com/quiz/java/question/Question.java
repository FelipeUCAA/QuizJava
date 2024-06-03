
package com.quiz.java.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "questions")
@Table(name = "questions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_text", nullable = true, length = 500)
    private String questionText;

    @Column(name = "correct_answer_index", nullable = true)
    private Integer correctAnswerIndex;

    @Column(name = "answer_1", nullable = true, length = 255)
    private String answer1;

    @Column(name = "answer_2", nullable = true, length = 255)
    private String answer2;

    @Column(name = "answer_3", nullable = true, length = 255)
    private String answer3;

    @Column(name = "answer_4", nullable = true, length = 255)
    private String answer4;

    //get&set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getquestion_text() {
        return questionText;
    }

    public void setquestion_text(String question_text) {
        this.questionText = question_text;
    }

    public Integer getcorrect_answer_index() {
        return correctAnswerIndex;
    }

    public void setcorrect_answer_index(Integer correct_answer_index) {
        this.correctAnswerIndex = correct_answer_index;
    }

    public String getanswer_1() {
        return answer1;
    }

    public void setanswer_1(String answer_1) {
        this.answer1 = answer_1;
    }

    public String getanswer_2() {
        return answer2;
    }

    public void setanswer_2(String answer_2) {
        this.answer2 = answer_2;
    }

    public String getanswer_3() {
        return answer3;
    }

    public void setanswer_3(String answer_3) {
        this.answer3 = answer_3;
    }

    public String getanswer_4() {
        return answer4;
    }

    public void setanswer_4(String answer_4) {
        this.answer4 = answer_4;
    }
}
