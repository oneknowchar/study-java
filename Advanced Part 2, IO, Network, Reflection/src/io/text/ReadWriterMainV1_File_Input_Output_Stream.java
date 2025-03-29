package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import io.start.ByteArrayStreamMain;

/**
 * 스트림의 데이터는 byte 단위를 사용한다.
 * 따라서 String 문자는 byte로 변환한 다음에 저장해야 한다.
 * 이전에 배운 BufferedXxx와 같이 누군가 이러한 변환 기능을 대신 처리해주면 좋지 않을까?
 */
public class ReadWriterMainV1_File_Input_Output_Stream {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        //텍스트 데이터 -> byte 데이터 (인코딩)
        byte[] data = writeString.getBytes(StandardCharsets.UTF_8);

        //파일에 쓰기
        FileOutputStream fos = new FileOutputStream(TextConst.FILE_NAME);
        fos.write(data);
        fos.close();


        //파일에 읽기
        FileInputStream fis = new FileInputStream(TextConst.FILE_NAME);
        byte[] readBytes = ByteArrayStreamMain.readAllBytes(fis);
        fis.close();

        //byte 데이터 -> 텍스트 데이터 (디코딩)
        String readString = new String(readBytes, StandardCharsets.UTF_8);
        System.out.println(readString);
    }
}
