package org.example;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @Column(name = "Answer_ID")
    private int answerID;
    @Column(name = "Answer")
    private String answer;
    @OneToOne(mappedBy = "answer")
    private Question question;

    public Answer(int answerID, String answer, Question question) {
        this.answerID = answerID;
        this.answer = answer;
        this.question = question;
    }

    public Answer() {
        super();
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
