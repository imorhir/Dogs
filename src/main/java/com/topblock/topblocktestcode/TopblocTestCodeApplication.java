package com.topblock.topblocktestcode;

import com.topblock.topblocktestcode.sender.Sender;
import com.topblock.topblocktestcode.services.ClassService;
import com.topblock.topblocktestcode.dataSource.DataSource;
import com.topblock.topblocktestcode.reader.ExcelReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopblocTestCodeApplication {

	public static void main(String[] args) {

		SpringApplication.run(TopblocTestCodeApplication.class, args);

		try {
			String[] urls = {"src/main/resources/static/Student Info.xlsx","src/main/resources/static/Test Retake Scores.xlsx", "src/main/resources/static/Test Scores.xlsx"};
			DataSource.populateList(ExcelReader.read(urls));
			Sender.postData();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
