package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * 버퍼드 인풋을 사용했으나 동기화 락이 있어 약간의 성능 저하. 왠만해선 충분
 * 대신 멀티스레드 환경에선 안전
 */
public class ReadFileV3_BufferedInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(BufferedConst.FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis, BufferedConst.BUFFER_SIZE);

        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BufferedConst.BUFFER_SIZE];

        int fileSize = 0;
        int data;
        while((data = bis.read(buffer)) != -1) {
            fileSize+= data;
        }

        bis.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File name = " + BufferedConst.FILE_NAME);
        System.out.println("File size = " + fileSize / 1024/ 1024 + " MB");
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}
