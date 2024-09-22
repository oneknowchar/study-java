package book.chapter_15_networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ex_URLConnection {

	public static void main(String[] args) {
		String address = "http://localhost:8088/fileController/index";

		try {
			URLConnection conn = new URL(address).openConnection();
			
			String contentType = conn.getContentType();
			
			if(contentType.toLowerCase().contains("text")) {
				String line = "";
				BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while((line = input.readLine()) != null) {
					System.out.println(line);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
