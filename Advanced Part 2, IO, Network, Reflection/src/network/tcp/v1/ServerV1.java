package network.tcp.v1;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV1 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        log("SERVER START");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("SERVER SOCKET START -  listening port :  " + PORT);

        Socket accept = serverSocket.accept();

        DataInputStream input = new DataInputStream(accept.getInputStream());
        DataOutputStream output = new DataOutputStream(accept.getOutputStream());

        // 클라이언트 에게 문자 받기
        String received = input.readUTF();
        log("server <-  client: " + received);

        String toSend = received + " World";

        // 클라이언트 에게 문자 보내기
        log("server -> client : " + toSend);
        output.writeUTF(toSend);

        log("connection close");

        input.close();
        output.close();
        accept.close();
        serverSocket.close();
    }
}
