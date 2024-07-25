package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestionID(1212);
        q1.setQuestion("What is Java ?");

        Answer ans1 = new Answer();
        ans1.setAnswerID(343);
        ans1.setAnswer("Java is a programming language.");
        ans1.setQuestion(q1);

        Answer ans2 = new Answer();
        ans2.setAnswerID(344);
        ans2.setAnswer("Java is used to create software.");
        ans2.setQuestion(q1);

        Answer ans3 = new Answer();
        ans3.setAnswerID(345);
        ans3.setAnswer("Java has different types of frameworks.");
        ans3.setQuestion(q1);

        List<Answer> answerList = new ArrayList<Answer>();
        answerList.add(ans1);
        answerList.add(ans2);
        answerList.add(ans3);

        q1.setAnswers(answerList);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(q1);
        session.save(ans1);
        session.save(ans2);
        session.save(ans3);

        Question question = (Question) session.get(Question.class, 1212);
        System.out.println("\nQuestion : " + question.getQuestion() + "\n");
        for (Answer answer : question.getAnswers())
            System.out.println("Answer : " + answer.getAnswer());
        System.out.println();

        transaction.commit();

        session.close();
        factory.close();
    }
}
