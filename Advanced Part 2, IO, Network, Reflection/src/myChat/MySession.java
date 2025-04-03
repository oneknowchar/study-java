package myChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import static util.MyLogger.log;

public class MySession implements Runnable {
    private final Socket socket;

    public MySession(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            ){

            log("== [START] TREAD == ");

            while (true) {
                String toSend = input.readUTF();

                if ("/exit".equals(toSend)) {
                    break;
                }

                output.writeUTF(toSend);
                log(toSend);
            }

            log("== [END] TREAD == ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
