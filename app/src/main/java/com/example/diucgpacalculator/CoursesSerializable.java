package com.example.diucgpacalculator;

import java.io.Serializable;

public class CoursesSerializable implements Serializable {
    public String courseName;
    public String courseCredit;
    public String courseGPA;

    public CoursesSerializable() {
    }

    public CoursesSerializable(String courseName, String courseCredit, String courseGPA) {
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.courseGPA = courseGPA;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseGPA() {
        return courseGPA;
    }

    public void setCourseGPA(String courseGPA) {
        this.courseGPA = courseGPA;
    }
}
