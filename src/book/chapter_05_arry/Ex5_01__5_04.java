package book.chapter_05_arry;

public class Ex5_01__5_04 {
	public static void main(String[] args) {
		int [] aaa = {1,2,3,4};
		int [] bbb= {1,2,3,4,};
		System.out.println(aaa[1] == bbb[1]);
		System.out.println("-------------------------------------------------------------");
		
		int[][] arr = {
				{ 5, 5, 5, 5, 5},
				{ 10, 10, 10},
				{ 20, 20, 20, 20},
				{ 30, 30} // <<< 이놈길이
		};
		System.out.println(arr[3].length);
		System.out.println("-------------------------------------------------------------");

		int[]arrr = {10,20,30,40,50};
		int sum = 0;
		for(int a : arrr) {
			sum += a;
		}
		System.out.println("sum = " + sum);
		System.out.println("-------------------------------------------------------------");
		
		//2차원 배열에 담긴 모든 값의 총 합과 평균을 구하는 프로그램
		int[][] score = {
				{ 5, 5, 5, 5, 5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};
		
		int total = 0;
		float average = 0;
		
		int totalCnt = 0;
		for(int i = 0; i < score.length; i++) {
			totalCnt += score[i].length;
			for(int j = 0; j < score[i].length; j++){
				total+= score[i][j];
			}
		}
		
		average = (float)total / totalCnt;	
		//totalCnt를 구하는 또 다른 방법은 가로 세로가 일정한 길이... 가로 * 세로 = 20.
		System.out.println("total="+total); // 결과 : total=325
		System.out.println("average="+average); // 결과 : average=16.25
		System.out.println("-------------------------------------------------------------");
	}
	
	
}
