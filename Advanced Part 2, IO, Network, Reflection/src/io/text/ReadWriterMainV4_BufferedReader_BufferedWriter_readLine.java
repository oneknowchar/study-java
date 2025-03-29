package io.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * FileWriter = FileOutputStream + OutputStreamWriter
 * FileReader = FileInputStream + InputStreamReader
 *
 * 자바 11버전 부터 매개변수로 캐릭터셋을 생성자 매게변수로 넣을 수 있음.
 * 지금은 자바 8이라 TextConst.FILE_NAME만 넣어봄 //생략시 시스템 디폴트 캐릭터 셋
 */
public class ReadWriterMainV4_BufferedReader_BufferedWriter_readLine {
    private static int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        //파일에 쓰기
        FileWriter fw = new FileWriter(TextConst.FILE_NAME);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        //파일에 읽기
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(TextConst.FILE_NAME);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;

        while((line = br.readLine()) != null) { 
            content.append(line).append("\n");
        }
        br.close();

        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
