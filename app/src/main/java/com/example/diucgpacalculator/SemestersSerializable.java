package com.example.diucgpacalculator;

import java.io.Serializable;

public class SemestersSerializable implements Serializable {
    public String semesterName;
    public String credit;
    public String sgpa;

    public SemestersSerializable() {
    }

    public SemestersSerializable(String semesterName, String credit, String sgpa) {
        this.semesterName = semesterName;
        this.credit = credit;
        this.sgpa = sgpa;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getSgpa() {
        return sgpa;
    }

    public void setSgpa(String sgpa) {
        this.sgpa = sgpa;
    }
}
