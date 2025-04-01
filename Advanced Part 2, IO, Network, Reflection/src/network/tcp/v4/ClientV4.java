package network.tcp.v4;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import network.tcp.SocketCloseUtil;

public class ClientV4 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws UnknownHostException, IOException {
        log("client START");

        // finally 블록 변수에서 접근해야 한다.
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            socket = new Socket("localhost", PORT);

            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());

            log("socekt connected : " + socket);

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("전송 문자");

                // 서버에게 문자 보내기
                String toSend = sc.nextLine();
                output.writeUTF(toSend);
                log("client -> server : " + toSend);

                if (toSend.equals("exit")) {
                    break;
                }
                // 서버에게 문자 받기
                String received = input.readUTF();
                log("client <- server : " + received);
            }

        } catch (IOException e) {
            log(e);
        } finally {
            SocketCloseUtil.closeAll(socket, input, output);
            log("connection close : " + socket);
        }
    }
}
