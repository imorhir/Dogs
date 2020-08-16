package com.topblock.topblocktestcode.services;

import com.topblock.topblocktestcode.dataSource.DataSource;
import com.topblock.topblocktestcode.models.TestRetakeScores;
import com.topblock.topblocktestcode.models.TestScores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassService {

    public static Integer average(){
        List<Integer> scores = new ArrayList<>();

        DataSource.studentInfoDS.forEach(studentInfo -> {
            TestRetakeScores testRetakeScores = findTestRetakeByStudentId(DataSource.testRetakeScoresDS, studentInfo.getStudentId());
            TestScores testScores = findTestByStudentId(DataSource.testScoresDS, studentInfo.getStudentId());
            if (testRetakeScores != null) {
                //adding the right score to the list after comparing testScores and RetakenScores.
                scores.add(testRetakeScores.getScore() > testScores.getScore() ? testRetakeScores.getScore():testScores.getScore());
            } else{
                scores.add(testScores.getScore());
            }
        });
        //calculating the average.
        Double average = scores.stream().mapToDouble(score -> score).average().orElse(0.0);
        return (int) Math.round(average);

    }

    private static TestRetakeScores findTestRetakeByStudentId(List<TestRetakeScores> listTestRetak, Integer studentID) {
        return listTestRetak.stream().filter(retake -> studentID.equals(retake.getStudentId())).findFirst().orElse(null);
    }

    private static TestScores findTestByStudentId(List<TestScores> listTestRetak, Integer studentID) {
        return listTestRetak.stream().filter(test -> studentID.equals(test.getStudentId())).findFirst().orElse(null);
    }
    //getting the ids of female students majored in CS.
    public static List<String> getFemaleCsMajor(){
        List<String> femaleId = new ArrayList<>();
        DataSource.studentInfoDS.forEach(student->{
            if(student.getMajor().contains("computer science") && student.getGender().equals("F")) {
                femaleId.add(student.getStudentId().toString());

            }
        });
         Collections.sort(femaleId);

         return femaleId;

    }

}