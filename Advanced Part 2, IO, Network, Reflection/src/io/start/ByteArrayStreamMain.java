package io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ByteArrayStreamMain {
    public static void main(String[] args) throws IOException {
        byte[] input = { 1, 2, 3 };

        // 메모리에 쓰기(output)
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(input);

        //메모리에서 읽기
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        byte[] bytes = ByteArrayStreamMain.readAllBytes(bis);
        System.out.println(Arrays.toString(bytes));

        /*
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * 참고로 메모리에 어떤 데이터를 저장하고 읽을 때는 컬렉션이나 배열을 사용하면 되기 때문에, 이 기능은 잘 사용하지 않는다.
         * 주로 스트림을 간단하게 테스트 하거나 스트림의 데이터를 확인하는 용도로 사용한다.
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */
    }

    /**
     * readAllBytes() 함수는 Java 9부터 사용 가능.
     * @MethodName: readAllBytes
     * @Desc: 자바 8인 지금의 경우 직접 구현함
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n;
        byte[] buffer = new byte[1024]; // 1KB 버퍼 크기
        while ((n = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
