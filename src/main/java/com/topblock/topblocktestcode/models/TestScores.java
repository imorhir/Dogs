package com.topblock.topblocktestcode.models;


public class TestScores {

     private Integer StudentId;
     private Integer Score;

    public TestScores(Integer studentId, Integer score) {
        StudentId = studentId;
        Score = score;
    }


    public Integer getStudentId() {
        return StudentId;
    }

    public void setStudentId(Integer studentId) {
        StudentId = studentId;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }
}
