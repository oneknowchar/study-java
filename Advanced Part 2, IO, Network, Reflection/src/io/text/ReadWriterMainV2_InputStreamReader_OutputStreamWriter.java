package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * InputStreamReader, OutputStreamWriter는 결국 바이트로 변환을 도와주는 클래스일 뿐이
 * I/O Stream 클래스를 사용해도 될꺼같은데 막상 열어보면 Reader, Writer 클래스 구현체이다.
 *
 * 왜 I/O Stream과 Reader, Writer를 구별했냐면...
 * 1. Reader/Writer는 인코딩을 고려하여 문자(Character) 단위로 읽고 씀
 * 2. 다루는 데이터도, 바이트와 문자는 근본적으로 다름
 */
public class ReadWriterMainV2_InputStreamReader_OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        //파일에 쓰기
        FileOutputStream fos = new FileOutputStream(TextConst.FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        osw.write(writeString);
        osw.close();

        //파일 읽기
        FileInputStream fis = new FileInputStream(TextConst.FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;
        while((ch = isr.read()) != 1) {
            content.append((char)ch);
        }
        isr.close();

        System.out.println(content);
    }
}
