package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import io.start.ByteArrayStreamMain;
/**
 * 파일을 한 번에 처리한다.
 * 디스크나 파일 시스템에서 데이터를 읽고 쓰는 기본단위가 보통 4KB, 8KB이기 때문에 한 번에 쓴다고해서 무작정 빠른 것은 아니다.
 */
public class ReadFileV4_readAllBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        //파일을 한 번에  읽음
        byte[] bytes= ByteArrayStreamMain.readAllBytes(fis);
        fis.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File name = " + BufferedConst.FILE_NAME);
        System.out.println("File size = " + bytes.length / 1024/ 1024 + " MB");
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}
