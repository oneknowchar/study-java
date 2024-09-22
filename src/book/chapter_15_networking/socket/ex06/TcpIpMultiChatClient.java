package book.chapter_15_networking.socket.ex06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpMultiChatClient {
	public static void main(String[] args) {
		try {
			String address = "127.0.0.1";
			Scanner sc = new Scanner(System.in);
			
			System.out.print("닉네임을 작성해 주세요 : ");
			String name = sc.nextLine();
			System.out.println();
			Socket socket = new Socket(address, 6666);
			System.out.println("서버에 연결되었습니다.");
			
			Thread sender = new ClientSender(socket, name);
			Thread receiver = new ClientReceiver(socket);
			sender.start();
			receiver.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static class ClientSender extends Thread{
		Socket socket;
		DataOutputStream output;
		String name;
		
		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				this.output  = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			
			try {
				if(output != null) {
					output.writeUTF(name);
				}
				
				while(output != null) {
					output.writeUTF("["+ name + "]" + sc.nextLine());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static class ClientReceiver extends Thread{
		Socket socket;
		DataInputStream input;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				this.input  = new DataInputStream(socket.getInputStream());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			
			try {
				while(input != null) {
					System.out.println(input.readUTF());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
