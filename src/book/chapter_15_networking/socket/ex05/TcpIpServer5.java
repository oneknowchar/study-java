package book.chapter_15_networking.socket.ex05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpServer5 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(5555);

			System.out.println("서버가 준비되었습니다.");

			socket = serverSocket.accept();

			new Thread(new Sender(socket)).start();
			new Thread(new Receiver(socket)).start();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

class Sender implements Runnable {
	Socket socket;
	DataOutputStream out;
	String name;
	
	Sender(Socket socket){
		this.socket = socket;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = "[" + socket.getInetAddress() + ":" +  socket.getPort() + "]"; 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(out != null) {
			try {
				out.writeUTF(name + sc.nextLine());
			}catch (Exception e) {
				e.printStackTrace();
				sc.close();
			}
		}
	}
}

class Receiver implements Runnable{
	Socket socket;
	DataInputStream input;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		
		try {
			input = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		while(input != null) {
			try {
				System.out.println(input.readUTF());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
