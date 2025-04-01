package myChat;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    private static final int PORT = 5713;

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                Scanner sc = new Scanner(System.in);
            ) {
            log("== SERVER ==");
            Socket socket = serverSocket.accept();
            log("== client connected! ==");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            while(true) {
                //메시지 받기
                String receive = input.readUTF();
                log(receive);

                //메시지 보내기
                String nickName = "server";
                System.out.print(nickName + ": ");
                String toSend = nickName + ": " + sc.nextLine();
                output.writeUTF(toSend);
            }
        } catch (IOException e) {
            log("== server error!! ==");
            log(e);
        }
    }
}
