package org.example;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User_Details")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(length = 25)
    private String name;

    @Column(length = 50)
    private String address;

    @Transient
    private double gpa;

    @Column(name = "passed")
    private boolean isPass;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @Lob
    private byte[] profilePhoto;

    public Data(int id, String name, String address, double gpa, boolean isPass, Date addedDate, byte[] profilePhoto) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gpa = gpa;
        this.isPass = isPass;
        this.addedDate = addedDate;
        this.profilePhoto = profilePhoto;
    }

    public Data() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
