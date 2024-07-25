package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestionID(1212);
        q1.setQuestion("What is java ?");

        Question q2 = new Question();
        q2.setQuestionID(242);
        q2.setQuestion("What is collection framework ?");

        Question q3 = new Question();
        q3.setQuestionID(234324);
        q3.setQuestion("What is NeatBeans ?");

        Answer ans1 = new Answer();
        ans1.setAnswerID(333);
        ans1.setAnswer("Java is a programming language.");

        Answer ans2 = new Answer();
        ans2.setAnswerID(444);
        ans2.setAnswer("It is a API to work with group of objects.");

        Answer ans3 = new Answer();
        ans3.setAnswerID(777);
        ans3.setAnswer("It is an IDE for writing codes.");

        q1.setAnswer(ans1);
        q2.setAnswer(ans2);
        q3.setAnswer(ans3);

        ans1.setQuestion(q1);
        ans2.setQuestion(q2);
        ans3.setQuestion(q3);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(q1);
        session.save(q2);
        session.save(q3);

        session.save(ans1);
        session.save(ans2);
        session.save(ans3);

        transaction.commit();

        Question q = session.get(Question.class, 1212);
        System.out.println("\nQuestion : " + q.getQuestion());
        System.out.println("Answer : " + q.getAnswer().getAnswer() + "\n");

        session.close();
        factory.close();
    }
}
