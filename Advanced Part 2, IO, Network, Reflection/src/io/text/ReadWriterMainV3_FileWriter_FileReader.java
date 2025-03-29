package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter = FileOutputStream + OutputStreamWriter
 * FileReader = FileInputStream + InputStreamReader
 *
 * 자바 11버전 부터 매개변수로 캐릭터셋을 생성자 매게변수로 넣을 수 있음.
 * 지금은 자바 8이라 TextConst.FILE_NAME만 넣어봄 //생략시 시스템 디폴트 캐릭터 셋
 */
public class ReadWriterMainV3_FileWriter_FileReader {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        //파일에 쓰기
        FileWriter fw = new FileWriter(TextConst.FILE_NAME);
        fw.write(writeString);
        fw.close();

        //파일에 읽기
        FileReader fr = new FileReader(TextConst.FILE_NAME);
        StringBuilder content = new StringBuilder();
        int ch;

        while((ch = fr.read()) != -1) {
            content.append((char)ch);
        }
        fr.close();

        System.out.println(content);
    }
}
