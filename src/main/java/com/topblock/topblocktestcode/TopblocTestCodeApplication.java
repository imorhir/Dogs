package com.topblock.topblocktestcode;

import com.topblock.topblocktestcode.sender.Sender;
import com.topblock.topblocktestcode.services.ClassService;
import com.topblock.topblocktestcode.dataSource.DataSource;
import com.topblock.topblocktestcode.reader.ExcelReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication

public class TopblocTestCodeApplication {


	private static String [] excelPath;
	@Value("${excel.url}")
	public void setImagePath(String[] value) {
		this.excelPath = value;
	}

	public static void main(String[] args) {
		SpringApplication.run(TopblocTestCodeApplication.class, args);

		try {
			DataSource.populateList(ExcelReader.read(excelPath));
			Sender.postData();
			System.out.println(ClassService.getFemaleCsMajor());
			System.out.println(ClassService.average());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
