package network.tcp.v2;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientV2 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws UnknownHostException, IOException {
        log("client START");

        Socket socket = new Socket("localhost", PORT);

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        DataInputStream input = new DataInputStream(socket.getInputStream());

        log("socekt connected : " + socket);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("전송 문자");

            // 서버에게 문자 보내기
            String toSend = sc.nextLine();
            output.writeUTF(toSend);
            log("client -> server : " + toSend);

            if(toSend.equals("exit")) {
                break;
            }
            // 서버에게 문자 받기
            String received = input.readUTF();
            log("client <- server : " + received);
        }

        // 자원 정리
        log("connection close : " + socket);
        input.close();
        output.close();
        socket.close();

    }
}
