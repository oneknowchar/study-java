package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {
    private static final DateTimeFormatter  FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {
        String time = LocalTime.now().format(FORMATTER);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj.toString());
    }

    public static void printCommandKey() {
        log("===================================");
        log("/join {username}  - sign in");
        log("/message {message}  - to send message");
        log("/change {username}  - chage username");
        log("/users  - show users");
        log("/exit  - to exit");
        log("===================================");
    }
}
