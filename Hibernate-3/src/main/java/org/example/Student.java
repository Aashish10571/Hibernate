package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int id;

    private String name;

    private String city;

    private Certificates certificate;

    public Student() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.id + " : " + this.name + " : " + this.city;
    }

    public void setCertificate(Certificates certificate) {
        this.certificate = certificate;
    }
}
