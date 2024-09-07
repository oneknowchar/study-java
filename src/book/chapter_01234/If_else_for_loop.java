package book.chapter_01234;

public class If_else_for_loop {
	public static void main(String[] args) {
		//1부터 20까지의 정수 중에서 2또는 3의 배수가 아닌 수의 총합
		int sum1 = 0;
		for(int i = 1; i<=20; i++) {
			if(i % 2 != 0 && i % 3 != 0) {
				System.out.print(i + (i == 19 ? "" :"+"));
				sum1 += i;
			}
		}
		System.out.println("= " + sum1);
		System.out.println("-------------------------------------------------------------");
		
		// 1+(1+2)+(1+2+3)+(1+2+3+4)+(1+2+3+5)....((1+2+3+...+10) 의 계산결과는?
		int sum2 = 0;
		for(int i = 1; i<= 10; i++) {
			sum2 += i + sum2;
		}
		System.out.println(sum2);
		System.out.println("-------------------------------------------------------------");
		
		//1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 100이상이 되는 총합은?
		int sum3 = 0;
		int i3= 0;
		while(true) {
			if(sum3 >= 100) break;	// 100 초과시 멈춤

			++i3;	//1 씩 증가
			
			if(i3 %2 ==0) {	//짝수면 음수로 변환 후 더하기
				sum3 -= i3;
			}else {
				sum3 += i3;	//홀수면 양수로 더하기
			}
		}
		System.out.println("i3 count = " + i3);
		System.out.println("-------------------------------------------------------------");
		
		//두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 경우의 수를 출력
		for(int i = 1; i<=6; i++) {
			for(int j = 1; j<=6; j++) {
				if(i + j == 6) {
					System.out.println(i + "+"+ j + "= 6");
				}
			}
		}
		System.out.println("-------------------------------------------------------------");
		
		//문자열 숫자를 모두 더한 값?
		String str = "12345";
		int sum4 = 0;
		for(int i=0; i<str.length(); i++) {
			//str.charAt(i)은 문자를 반환하므로
			//숫자(int)로 변환하려면 문자에서 '0'의 아스키 코드를 빼주는 방법을 사용
			sum4+=str.charAt(i) - '0';
		}
		System.out.println(sum4);
		System.out.println("-------------------------------------------------------------");

		//회문수를 구하자
		int number = 12321;
		int tmp = number;
		
		int result = 0; 
		
		while (tmp != 0) {
			result = result * 10 + tmp % 10;
			tmp=tmp/10;
		}
		if(number == result) {
			System.out.println(number +"는 회문수 입니다.");
		}else {
			System.out.println(number +"는 회문수가 아닙니다.");
		}
		
	}
}
