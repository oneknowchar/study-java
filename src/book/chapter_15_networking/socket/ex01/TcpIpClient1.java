package book.chapter_15_networking.socket.ex01;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient1 {
	public static void main(String[] args) {

		try {
			String serverIp = "127.0.0.1";
			System.out.println("서버에 연결 중입니다. 서버 IP : " + serverIp);

			// 소켓을 생성하여 연결을 요청한다
			Socket socket = new Socket(serverIp, 1111);

			// 소켓의 입력 스트림을 얻는다
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);

			// 소켓으로 부터 데이터를 출력한다
			System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");

			dis.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		} catch (Exception e) {
			System.out.println("에러 발생 : " + e.getMessage());
			System.out.println("서버 소켓을 확인해 주세요");
		}
	}
}
