package network.tcp.v3;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SessionV3 implements Runnable {

    public final Socket socket;

    public SessionV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // 클라이언트 에게 문자 받기
            while (true) {
                String received = input.readUTF();
                log("server <-  client: " + received);

                if (received.equals("exit")) break;

                String toSend = received + " World";

                // 클라이언트 에게 문자 보내기
                log("server -> client : " + toSend);
                output.writeUTF(toSend);
            }

            log("connection close");

            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
