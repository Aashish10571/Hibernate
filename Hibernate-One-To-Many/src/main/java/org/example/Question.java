package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name = "Question_ID")
    private int questionID;

    @Column(name = "Question")
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(int questionID, String question, List<Answer> answers) {
        this.questionID = questionID;
        this.question = question;
        this.answers = answers;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
