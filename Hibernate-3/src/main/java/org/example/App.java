package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student student = new Student();
        Certificates certificate = new Certificates();

        student.setId(1);
        student.setName("Suman");
        student.setCity("Taukhel");

        certificate.setCourse("Engineering");
        certificate.setCourse("4 years");

        student.setCertificate(certificate);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();

        session.close();
        factory.close();
    }
}
