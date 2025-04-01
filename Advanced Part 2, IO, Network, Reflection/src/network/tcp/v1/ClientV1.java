package network.tcp.v1;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ClientV1 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws UnknownHostException, IOException {
        log("client START");

        long start = System.currentTimeMillis();
        try {
//            Socket socket = new Socket("192.168.1.250", 12345);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.1.254", 12345), 2000);

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());

            log("socekt connected : " + socket);

            //서버에게 문자 보내기
            String toSend = "Hello";
            output.writeUTF(toSend);
            log("client -> server : "  + toSend);

            //서버에게 문자 받기
            String received = input.readUTF();
            log("client <- server : "  + received);

            //자원 정리
            log("connection close : " + socket);
            input.close();
            output.close();
            socket.close();
        }catch (SocketTimeoutException e) {
            // TODO: handle exception

        }finally {
            long end = System.currentTimeMillis();

            System.out.println((end - start)  + "ms");
        }

    }
}
