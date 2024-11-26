package com.leo.codes.client;

/*
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.codes.client.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;


@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		//test();



	}

	@PostConstruct
	void init(){
		test();
	}

	void test()
	{
///*
		try {
			sendUser(new User("John Doe"));
			//System.out.println("test");
		} catch (Exception e) {
			e.printStackTrace();
		}
 //*/
		//String time = getCurrentDD(1);

		//System.out.println("test");
/*
		while(true)
		{
			String time = getCurrentMiliSecond(1);
			System.out.println("time: " + time);
		}
*/
/*
		DateTimeZone seoul = DateTimeZone.forID("Asia/Seoul");
		DateTime dateTime = new DateTime(seoul);
		DateTime dt = dateTime.minusMinutes(2);
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyyMMddHHmm");
		String statDt = dtfOut.print(dt);
*/
		//String statDtCondition = "201511051515";


	}
	public static String getCurrentDD(int min) {

		TimeZone kstTz = TimeZone.getDefault();
		Calendar ccal = Calendar.getInstance(kstTz);
		ccal.add(Calendar.MINUTE, -min);
		int year =ccal.get(Calendar.YEAR);
		int month = ccal.get(Calendar.MONTH) + 1;
		int dayOfMonth =ccal.get(Calendar.DAY_OF_MONTH);
		int hourOfDay = ccal.get(Calendar.HOUR_OF_DAY);
		int minute =ccal.get(Calendar.MINUTE);
		int second = ccal.get(Calendar.SECOND);

		String thisTime =
				ccal.get(Calendar.YEAR) +
						((month<10)?"0":"")+month +
						((dayOfMonth<10)?"0":"")+dayOfMonth;
		return thisTime;
	}
	public static String getCurrentMiliSecond(int min) {


		TimeZone kstTz = TimeZone.getDefault();
		Calendar ccal = Calendar.getInstance(kstTz);
		ccal.add(Calendar.MINUTE, -min);

		int year = Calendar.YEAR;//ccal.get(Calendar.YEAR);
		int month = ccal.get(Calendar.MONTH) + 1;
		int dayOfMonth =ccal.get(Calendar.DAY_OF_MONTH);
		int hourOfDay = ccal.get(Calendar.HOUR_OF_DAY);
		int minute =ccal.get(Calendar.MINUTE);
		int second =ccal.get(Calendar.SECOND);
		int milisecond =ccal.get(Calendar.MILLISECOND);

		String thisTime =
				ccal.get(Calendar.YEAR) +
						((month<10)?"0":"")+month +
						((dayOfMonth<10)?"0":"")+dayOfMonth +
						((hourOfDay<10)?"0":"")+hourOfDay +
						((minute<10)?"0":"")+minute +
						((second<10)?"0":"")+second +
						milisecond
				;
		//20240926140512.504
		//20240926150019.343
		return thisTime;
	}



	public static String getCurrentMin(int min) {
		TimeZone kstTz = TimeZone.getDefault();
		Calendar ccal = Calendar.getInstance(kstTz);
		ccal.add(Calendar.MINUTE, -min);
		int year =ccal.get(Calendar.YEAR);
		int month = ccal.get(Calendar.MONTH) + 1;
		int dayOfMonth =ccal.get(Calendar.DAY_OF_MONTH);
		int hourOfDay = ccal.get(Calendar.HOUR_OF_DAY);
		int minute =ccal.get(Calendar.MINUTE);


		String thisTime =
				ccal.get(Calendar.YEAR) +
						((month<10)?"0":"")+month +
						((dayOfMonth<10)?"0":"")+dayOfMonth +
						((hourOfDay<10)?"0":"")+hourOfDay +
						((minute<10)?"0":"")+minute ;

		return thisTime;
	}


	void sendUser(User user) throws Exception {
		String urlStr = "http://localhost:8080/codes/api/users";
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setConnectTimeout(2000);
		conn.setReadTimeout(2000);

		conn.setDoOutput(true);
		conn.setDoInput(true);

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		// Convert User object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonInputString = objectMapper.writeValueAsString(user);

		// Send JSON input string to the server
		try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
			out.write(jsonInputString.getBytes("utf-8"));
			out.flush();
		}

		int status = conn.getResponseCode();
		System.out.println("Response Code: " + status);

		conn.disconnect();
	}

}
