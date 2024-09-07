package book.chapter_01234;

public class Operation {
	public static void main(String[] args) {
		//사과 수가 123개일때 필요한 바구니 갯수
		System.out.println((int)Math.ceil(125/10d));
		System.out.println("-------------------------------------------------------------");
		
		//백의 자리 이하를 버리는 법
		System.out.println(456/100 * 100);
		System.out.println("-------------------------------------------------------------");
		
		//10 - 주어진 수의 1의자리 의 나머지 값
		int num = 81;
		System.out.println(10 - (num%10));
		System.out.println("-------------------------------------------------------------");
		
		//Math.ceil(숫자)   -> 올림
		//Math.round(숫자)  -> 반올림
		//Math.floor(숫자)  -> 내림
		//화씨 -> 섭씨 변환 ,  공식 =  C = 5/9 (F -32)
		int f = 100;
		float c = ((float)5/9) * (100-32);
		c = (float)(Math.round(c  * 100)) /100;	//소수 점 둘째 자리에서 반 올림
		System.out.println("c = " + c);
		System.out.println("-------------------------------------------------------------");
		
		//주어진 문자가 영문자, 소문자 일때만 true
		char ch = '9';
		boolean b = 'a' <= ch && ch <='z' || 'A' <= ch && ch <='Z' ||'0' <= ch && ch <= '9';
		System.out.println("주어진 문자가 영문자, 소문자 일때만 = " + b);
		System.out.println("-------------------------------------------------------------");
		
		
		//대문자를 소문자로 변환, (대문자인 경우에만) 소문자는 대문자 보다 32만큼 크다
		char chs = 'C';
		char lowerCase = 'A' <= chs && chs <= 'Z' ? (char)(chs+32)  : chs;
		System.out.println("ch to lowerCase : "  + lowerCase);
	}
}








