package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 파일을 한 번에 처리한다.
 * 디스크나 파일 시스템에서 데이터를 읽고 쓰는 기본단위가 보통 4KB, 8KB이기 때문에 한 번에 쓴다고해서 무작정 빠른 것은 아니다.
 */
public class CreateFileV4_buffer_fileSize {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        //버퍼를 파일 크기만큼 잡아버려 한 번에 처리하지만 메모리에 부담이 많이감.
        byte[] buffer = new byte[BufferedConst.FILE_SIZE];
        for(int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            buffer[i] = 1;
        }

        fos.write(buffer); //한 번에 저장
        fos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File created name = " + BufferedConst.FILE_NAME);
        System.out.println("File size = " + BufferedConst.FILE_SIZE / 1024/ 1024 + " MB");
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}
