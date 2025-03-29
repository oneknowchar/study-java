package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;
/**
 * 버퍼 직접 구현 가장 성능이 좋음, 큰 데이터를 다루고 성능 최적화가 중요하다면 직접 구현해라.
 */
public class ReadFileV2_buffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[]buffer = new byte[BufferedConst.BUFFER_SIZE];
        int fileSize = 0;
        int size;

        while((size = fis.read(buffer)) != -1) {
            fileSize+= size;
        }

        fis.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File name = " + BufferedConst.FILE_NAME);
        System.out.println("File size = " + fileSize / 1024/ 1024 + " MB");
        System.out.println("Time taken = " + (endTime - startTime) + "ms");

    }
}
