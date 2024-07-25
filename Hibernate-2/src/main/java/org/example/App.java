package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        System.out.println("Enter the information as requested...");
        System.out.println();

        Data data = new Data();

        System.out.print("Name : ");
        data.setName(input.next());

        System.out.print("Address : ");
        data.setAddress(input.next());

        System.out.print("Exam Passed ?? : ");
        data.setPass(input.nextBoolean());

        System.out.print("GPA : ");
        data.setGpa(input.nextDouble());

        data.setAddedDate(new Date());

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/profile.png");
            byte[] photo = new byte[fileInputStream.available()];
            data.setProfilePhoto(photo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(data);
        transaction.commit();
        session.close();

        System.out.println();
        System.out.println("Saved...");
    }
}
