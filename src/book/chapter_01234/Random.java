package book.chapter_01234;

public class Random {
	public static void main(String[] args) {
		
		/*
		 * random()은 0.0과 1.0 사이의 범위에 속하는 double값을 반환한다.
		 * 0.0은 포함되고 1.0은 포함되지 않는다.
		 * 
		 * 1과 10사이의 정수를 구하기 원한다면
		 * 0~9사이를 얻은 후 1을 더한다.
		 * 
		 * 각 변의 10을 곱하여 0.0 ~ 9.0을 만든 후,
		 * 
		 * int로 변환.
		 * 
		 * + 1을 해주면 된다.
		 * 
		 * 1~ 10
		 */
		
		
		System.out.println((int)(Math.random() * 100) + 1);	//1~100
		System.out.println((int)(Math.random() * 45) + 1);	//1~45
		System.out.println((int)(Math.random() * 6) + 1);	//1~45
		System.out.println((char)((Math.random() * 26) + 65));	//A~Z
	}
} 
