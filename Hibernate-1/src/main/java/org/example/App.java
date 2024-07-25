package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        System.out.println();
        System.out.println("Enter the details of Student as requested...");
        System.out.println();

        Student student = new Student();

        System.out.print("ID : ");
        student.setId(input.nextInt());

        System.out.print("Name : ");
        student.setName(input.next());

        System.out.print("City : ");
        student.setCity(input.next());

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();

        System.out.println();
        System.out.println(student);
        System.out.println("Insertion Successful...");
    }
}
