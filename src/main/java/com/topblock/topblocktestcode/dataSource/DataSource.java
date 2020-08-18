package com.topblock.topblocktestcode.dataSource;

import com.topblock.topblocktestcode.models.StudentInfo;
import com.topblock.topblocktestcode.models.TestRetakeScores;
import com.topblock.topblocktestcode.models.TestScores;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataSource {
    public static List<StudentInfo> studentInfoDS = new ArrayList<>();
    public static List<TestRetakeScores> testRetakeScoresDS = new ArrayList<>();
    public static List<TestScores> testScoresDS = new ArrayList<>();


// populating the global variables with data from excel files.
public static void  populateList(Map<String, Map<Integer,List<String>>> data){
    for(String keyFileName : data.keySet()){
        Map<Integer,List<String>> globalFileData = data.get(keyFileName);
        if(keyFileName.toLowerCase().contains("student")){
            for (Integer rowKey : globalFileData.keySet()){
                if (rowKey != 0) {
                    List<String> rowData = globalFileData.get(rowKey);
                    studentInfoDS.add(new StudentInfo(Integer.parseInt(rowData.get(0)),rowData.get(1),rowData.get(2)));
                }

            }

        }
        if(keyFileName.toLowerCase().contains("retake")){
            for (Integer rowKey : globalFileData.keySet()){
                if(rowKey != 0) {
                    List<String> rowData = globalFileData.get(rowKey);
                    testRetakeScoresDS.add(new TestRetakeScores(Integer.parseInt(rowData.get(0)), Integer.parseInt(rowData.get(1))));
                }
            }

        }
        if(keyFileName.toLowerCase().contains("test scores")){
            for (Integer rowKey : globalFileData.keySet()) {
                if (rowKey != 0) {
                    List<String> rowData = globalFileData.get(rowKey);
                    testScoresDS.add(new TestScores(Integer.parseInt(rowData.get(0)), Integer.parseInt(rowData.get(1))));

                }
            }

        }

    }

}

}
