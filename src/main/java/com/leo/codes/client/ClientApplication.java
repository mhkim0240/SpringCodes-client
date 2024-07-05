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
		System.out.println("test");
/*
		DateTimeZone seoul = DateTimeZone.forID("Asia/Seoul");
		DateTime dateTime = new DateTime(seoul);
		DateTime dt = dateTime.minusMinutes(2);
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyyMMddHHmm");
		String statDt = dtfOut.print(dt);
*/
		//String statDtCondition = "201511051515";


		try {
			sendUser(new User("John Doe"));
			//System.out.println("test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	void sendUser(User user) throws Exception {
		String urlStr = "http://localhost:8080/api/users";
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
