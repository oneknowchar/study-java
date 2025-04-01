package myChat;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    private static final int PORT = 5713;

    public static void main(String[] args) {

        try (
                Socket socket = new Socket();
                Scanner sc = new Scanner(System.in);
            ) {

            socket.connect(new InetSocketAddress("localhost", PORT), 3000);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            log("== CLIENT ==");

            while(true) {
                //메시지 보내기
                String nickName = "jiseong";
                System.out.print(nickName + ": ");
                String toSend = nickName + ": " + sc.nextLine();
                output.writeUTF(toSend);

                //메시지 받기
                String receive = input.readUTF();
                log(receive);
                System.out.print(nickName + ": ");	//항상 표시
            }

        } catch (IOException e) {
            log(e);
        }
    }
}
