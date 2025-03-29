package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 버퍼 직접 구현 가장 성능이 좋음, 큰 데이터를 다루고 성능 최적화가 중요하다면 직접 구현해라.
 */
public class CreateFileV2_buffer {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[]buffer = new byte[BufferedConst.BUFFER_SIZE];
        int bufferIndex = 0;

        //파일 크기 만큼 바이트 단위로 입력함
        for(int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            //버퍼크기에 비트를 입력한다.
            buffer[bufferIndex++] = 1;

            //버퍼가 가득 차면 쓰고, 버퍼를 비운다.
            if(bufferIndex == BufferedConst.BUFFER_SIZE) {
                fos.write(buffer);
                bufferIndex = 0;
            }
        }

        //끝 부분에 오면 버퍼가 가득 차지 않아 남은경우, 남은 부분 쓰기
        if(bufferIndex > 0 ) {
            fos.write(buffer, 0, bufferIndex);
        }

        fos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File created name = " + BufferedConst.FILE_NAME);
        System.out.println("File size = " + BufferedConst.FILE_SIZE / 1024/ 1024 + " MB");
        System.out.println("Time taken = " + (endTime - startTime) + "ms");
    }
}
