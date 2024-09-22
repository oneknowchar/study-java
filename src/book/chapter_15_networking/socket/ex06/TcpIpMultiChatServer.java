package book.chapter_15_networking.socket.ex06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultiChatServer {
	HashMap<String, DataOutputStream> clients;

	public TcpIpMultiChatServer() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}

	public static void main(String[] args) {
		new TcpIpMultiChatServer().Start();
	}

	public void Start() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(6666);
			System.out.println("멀티챗 서버가 시작되었습니다.");

			while (true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]에서 접속했습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();

		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream input;
		DataOutputStream output;

		public ServerReceiver(Socket socket) {
			this.socket = socket;

			try {
				this.input = new DataInputStream(socket.getInputStream());
				this.output = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String name = "";
			
			try {
				name = input.readUTF();
				sendToAll("#"+ name + "님이 들어오셨습니다.");
				
				clients.put(name, output);
				
				System.out.println("현재 접속자 수 =  " + clients.size());
				
				while(input != null) {
					sendToAll(input.readUTF());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sendToAll("#"+ name + "님이 나갔습닌다.");
				clients.remove(name);
				System.out.println("현재 접속자 수 =  " + clients.size());
			}
		}
	}
}
