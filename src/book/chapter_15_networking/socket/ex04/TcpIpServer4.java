package book.chapter_15_networking.socket.ex04;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer4 implements Runnable{
	ServerSocket serverSocket;
	Thread[] threadArr;
	
	public static void main(String[] args) {
		//5개짜리 스레드 Array 생성,  프로그램 실행
		TcpIpServer4 server = new TcpIpServer4(5);
		server.start();
	}
	
	//생성자
	public TcpIpServer4(int num) {
		try {
			serverSocket = new ServerSocket(4444);
			serverSocket.setSoTimeout(1000 * 60 * 5);
			System.out.println(getTime() + "서버가 준비되었습니다.");
			
			threadArr = new Thread[num];
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void start() {
		for(int i = 0; i < threadArr.length; i++) {
			//Runnable을 받아왔기 때문에 this를 사용
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(getTime() + "가 연결 요청을 기다립니다.");
			
			Socket socket;
			try {
				socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");
				
				//소켓의 출력스트림을 얻는다.
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				
				//remote socket에 데이터를 보낸다.
				dos.writeUTF(getTime()+"[NOTICE] test messeage from server4...");
				
				System.out.println(getTime()+ "데이터를 전송했습니다.");
				
				dos.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	/**
	 * 현재 시간을 구한다
	 * @return
	 */
	public static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss]");
		return sdf.format(new Date()) + name;
	}
}
