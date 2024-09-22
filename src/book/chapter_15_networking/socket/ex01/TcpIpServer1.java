package book.chapter_15_networking.socket.ex01;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer1 {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(1111);
			serverSocket.setSoTimeout(5* 1000);
			System.out.println(getTime() + "서버가 준비되었습니다.");

			int count = 0;
			while (true) {
				++count;
				System.out.println(getTime() + "연결 요청을 기다립니다.");

				Socket socket = serverSocket.accept();

				System.out.println(getTime() + "연결 요청됨");
				System.out.println(getTime() + socket.getInetAddress());

				// 소켓의 출력스트림을 얻는다
				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputStream);

				// 원격 소켓에 데이터를 보낸다
				dos.writeUTF(getTime() + "[Notice] Test Message from server");

				System.out.println(getTime() + "데이터를 전송했습니다.");
				dos.close();
				socket.close();

				if (count == 5) {
					System.out.println(getTime() + "Max repeat request... socekt close!");
					break;
				}
			}

			System.out.println(getTime() + "socket Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss]");
		return sdf.format(new Date());
	}
}
