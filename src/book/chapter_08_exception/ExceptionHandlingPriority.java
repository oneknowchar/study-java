package book.chapter_08_exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExceptionHandlingPriority {
	public static void main(String[] args) {
		try {
			//do something...
			
			Path filePath = Paths.get("/fake/path/filename.txt");

			Files.createDirectories(filePath.getParent());	//경로 먼저 생성해야 에러 안 남
//			Files.createFile(filePath);	//경로 생성한 후 파일을 생성
			OutputStream outputStream = Files.newOutputStream(filePath, StandardOpenOption.CREATE);
			
			outputStream.write("hello World!!1".getBytes(StandardCharsets.UTF_8));
			outputStream.write("hello World!!2".getBytes(StandardCharsets.UTF_8));
			outputStream.write("hello World!!3".getBytes(StandardCharsets.UTF_8));
			outputStream.write("hello World!!4".getBytes(StandardCharsets.UTF_8));
			outputStream.write("hello World!!5".getBytes(StandardCharsets.UTF_8));
			InputStream inputStream = Files.newInputStream(filePath);
			
			 byte[] buffer = new byte[8]; // 버퍼 크기
	            int bytesRead;	//length 읽은 길이
	            
	            //실제 바이트를 읽어온 길이. 마지막 스트림이 버퍼의 크기보다
	            //작을때, 종료 시킴.
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	            	System.out.println();
	            	System.out.println(bytesRead);
	                // 읽은 바이트 수만큼 배열의 해당 부분을 문자열로 변환
	                String chunk = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
	                System.out.print(chunk); // 읽은 데이터 출력
	            }
		
		} catch (FileNotFoundException e) {
			// 파일이 없을 때 처리
			System.out.println("파일을 찾을 수 없습니다: " + e);
		} catch (IOException e) {
			// 파일 입출력 오류 처리
			System.out.println("입출력 오류 발생: " + e);
		} catch (Exception e) {
			// 모든 다른 예외 처리
			System.out.println("알 수 없는 오류 발생: " + e);
		}
	}
}
