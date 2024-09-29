package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class Encode_euc_kr {
	public static void main(String[] args) {
		File dummyFile = new File("C:\\Users\\hjs\\test\\dummy.txt");
		String ln = "\n";

		try {
			FileOutputStream fos = new FileOutputStream(dummyFile, false);	//false: 덮어쓰기
//			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dummyFile, false));	실패 
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dummyFile, false), "EUC-KR");	//성공

			StringBuffer sb = new StringBuffer();
			
			sb.append("시작").append(ln);
			sb.append("EUC-KR 인코딩 작성1").append(ln);
			sb.append("EUC-KR 인코딩 작성2").append(ln);
			sb.append("EUC-KR 인코딩 작성3").append(ln);
			sb.append("끝").append(ln);
			
//			osw.write(new String (sb.toString().getBytes(), "EUC-KR"));	//실패
			osw.write(sb.toString());	//성공
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
