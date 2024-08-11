package book.arry;

public class Ex5_06 {
	public static void main(String[] args) {
		//큰 금액의 동전을 우선적으로 거슬러 줘야한다.
		int[] cointUnit = {500, 100, 50, 10};
		
		int money = 2680;
		
		System.out.println("money = " + money);
		
		for(int i = 0; i<cointUnit.length; i++) {
			//몫, 남은값
			System.out.println(cointUnit[i] + "원 : " + money / cointUnit[i]);
			money = money % cointUnit[i];
		}
	}
}
