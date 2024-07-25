package org.example;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "Question_ID")
    private int questionID;
    @Column(name = "Question")
    private String question;
    @OneToOne
    @JoinColumn(name = "Address_ID")
    Answer answer;

    public Question(int questionID, String question, Answer answer) {
        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
        super();
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswer() {
        return answer;
    }
}
