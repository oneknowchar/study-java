package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 버퍼를 신경 없이 속도가 빠르게 개선, 동기화 락이 있어 약간의 성능 저하. 왠만해선 충분
 * 대신 멀티스레드 환경에선 안전
 */
public class CreateFileV3_BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(BufferedConst.FILE_NAME);

        //일일이 버퍼 경우를 따지며 코딩할 필요 없이
        //내부에서 단순히 버퍼 기능 제공, 마치 예제 1과 같이 단순한게 코드 작성가능
        BufferedOutputStream bos = new BufferedOutputStream(fos, BufferedConst.BUFFER_SIZE);

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            bos.write(i);
        }

        bos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File created name = " + BufferedConst.FILE_NAME);
        System.out.println("File size = " + BufferedConst.FILE_SIZE / 1024/ 1024 + " MB");
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}
