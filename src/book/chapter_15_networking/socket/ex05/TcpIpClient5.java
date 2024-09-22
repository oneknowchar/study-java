package book.chapter_15_networking.socket.ex05;

import java.io.IOException;
import java.net.Socket;

public class TcpIpClient5 {
	public static void main(String[] args) {
		String address = "127.0.0.1";
		
		try {
			Socket socket = new Socket(address, 5555);
			
			System.out.println("서버에 연결 되었습니다.");
			
			new Thread(new Sender(socket)).start();
			new Thread(new Receiver(socket)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
