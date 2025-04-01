package network.tcp.v3;

import static util.MyLogger.log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerV3 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        log("SERVER START");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("SERVER SOCKET START -  listening port :  " + PORT);


        while (true) {
            Socket socket = serverSocket.accept();
            log("socket connected : " + socket);

            SessionV3 session = new SessionV3(socket);

            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
