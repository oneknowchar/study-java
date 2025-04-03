package myChat;

import static util.MyLogger.log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private static final int PORT = 12345;
    public static List<MyClient> SIGNED_USERS = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            log("== [START] SERVER ==");

            while (true) {
                Socket socket = serverSocket.accept();

                MySession session = new MySession(socket);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
