package org.example;

import javax.persistence.Embeddable;

@Embeddable
public class Certificates {
    private String course;

    private String duration;

    public Certificates() {
        super();
    }

    public Certificates(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
