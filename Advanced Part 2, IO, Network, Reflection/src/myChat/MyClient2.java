package myChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class MyClient2 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        DataOutputStream output = null;
        DataInputStream input = null;

        try (
                Socket socket = new Socket();
                Scanner sc = new Scanner(System.in);
            ) {

            socket.connect(new InetSocketAddress("localhost", PORT), 2000);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());

            log("== [START] CLIENT 222 == ");

            while (true) {
                System.out.print("client 222 : ");
                String toSend = sc.nextLine();

                if ("/s".equals(toSend)) {
                    break;
                }

                output.writeUTF(toSend);
            }

            log("== [END] CLIENT == ");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { input.close(); } catch (IOException e) { e.printStackTrace(); }
            try { output.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }
}
