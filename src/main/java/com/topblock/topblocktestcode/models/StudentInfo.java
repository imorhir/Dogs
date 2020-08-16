package com.topblock.topblocktestcode.models;

public class StudentInfo {
    private Integer studentId;
    private String  major;
    private String gender;

    public StudentInfo(Integer studentId, String major, String gender) {
        this.studentId = studentId;
        this.major = major;
        this.gender = gender;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
