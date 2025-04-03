package myChat;

import static util.MyLogger.log;
import static util.MyLogger.printCommandKey;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class MyClient implements Runnable {
    private static final int PORT = 12345;

    private String nickName;

    public String getNickName() {
        return "".equals(nickName) || null == nickName ? "YOU" : nickName;
    }

    public void setNickName(String data) {
        if ("".equals(this.nickName) || null == nickName) {

            this.nickName = data;
            MyServer.SIGNED_USERS.add(this);

            log(this.nickName + "! welcome here!");
            return;
        }

        log("you are already signed... [username : " + this.nickName + "]");
    }

    public MyClient getMember(int idx) {
        return MyServer.SIGNED_USERS.get(idx);
    }

    public void setMember(MyClient member) {
        MyServer.SIGNED_USERS.add(member);
    }

    public List<MyClient> getMembers() {
        return MyServer.SIGNED_USERS;
    }



    @Override
    public String toString() {
        return "MyClient [nickName=" + nickName + "]";
    }

    public static void main(String[] args) {
        MyClient myClient = new MyClient();
        Thread thread = new Thread(myClient);
        thread.start();
    }

    @Override
    public void run() {

        try {
            Socket socket = new Socket();
            Scanner sc = new Scanner(System.in);
            socket.connect(new InetSocketAddress("localhost", PORT), 2000);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            log("'/help' -get some help commands");

            while (true) {

                System.out.print(this.getNickName() + " : ");
                String receive = sc.nextLine();
                String command = receive; // 명령어
                String data = ""; // 데이터

                // 입력된 명령어 파싱, 분석
                if (receive.indexOf(" ") > 0) {
                    String[] StrArr = receive.split(" ", 2);	// 최대 2개의 요소로 분리
                    command = StrArr[0];
                    data = StrArr[1];
                }

                // 닉네임이 없는 경우
                if ("".equals(this.nickName)) {
                    log("/join {username} -please set username");
                    continue;
                }

                switch (command) {
                case "/join": {
                    setNickName(data); // 닉네임 설정 후 회원가입
                    break;
                }
                case "/message": {
                    sendMessage(output, data);
                    break;
                }
                case "/change": {
                    setNickName(data); // 닉네임 설정
                    break;
                }
                case "/users": {
                    printMembers();
                    break;
                }
                case "/exit": {
                    log("== close the client program == ");
                    return;
                }
                case "/help": {
                    printCommandKey();
                    break;
                }
                default:
                    log("wrong command, '/help' get some help commands");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(DataOutputStream output, String data) {
        try {
            output.writeUTF(this.nickName + " : " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printMembers() {
        MyServer.SIGNED_USERS.stream().forEach(member -> log(member));
    }

}
