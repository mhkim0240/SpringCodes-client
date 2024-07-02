package com.leo.codes;

/*
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class CodesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodesApplication.class, args);
		//test();
	}


	@PostConstruct
	void init(){
		test();
	}

	void test()
	{
		System.out.println("test");
/*
		DateTimeZone seoul = DateTimeZone.forID("Asia/Seoul");
		DateTime dateTime = new DateTime(seoul);
		DateTime dt = dateTime.minusMinutes(2);
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyyMMddHHmm");
		String statDt = dtfOut.print(dt);
*/
		//String statDtCondition = "201511051515";
	}


}
