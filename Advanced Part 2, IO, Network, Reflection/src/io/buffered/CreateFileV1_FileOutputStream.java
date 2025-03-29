package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 버퍼가 없어 속도가 느린 문제
 */
public class CreateFileV1_FileOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            fos.write(i);
        }

        fos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File created name = " + BufferedConst.FILE_NAME);
        System.out.println("File size = " + BufferedConst.FILE_SIZE / 1024/ 1024 + " MB");
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}
