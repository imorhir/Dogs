package com.topblock.topblocktestcode.reader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelReader {



    public static Map<String, Map<Integer,List<String>>> read(String[] fileLocation) throws IOException {

        Map<String, Map<Integer,List<String>>> globalData= new HashMap<>();
        DataFormatter formatter = new DataFormatter();
        if(fileLocation != null) {
            Map<Integer, List<String>> data;
            for (int j = 0; j < fileLocation.length; j++) {
                FileInputStream file = new FileInputStream(new File(fileLocation[j]));
                Workbook workbook = new XSSFWorkbook(file);
                Sheet sheet = workbook.getSheetAt(0);
                data = new HashMap<>();
                int i = 0;
                for (Row row : sheet) {
                    data.put(i, new ArrayList<String>());
                    for (Cell cell : row) {
                        data.get(i).add(formatter.formatCellValue(cell));
                    }
                    i++;
                }
                globalData.put(fileLocation[j],data);
            }

        }
        return globalData;
    }
}
