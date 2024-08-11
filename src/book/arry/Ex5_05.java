package book.arry;

public class Ex5_05 {
	public static void main(String[] args) {
		int[]ballArr = {1,2,3,4,5,6,7,8,9};
		int[]ball3 = new int[3];
		
		//배열 ballArr의 임의의 요소 2개를 골라서 위치를 바꾼다. 20번 반복
		for(int x = 0; x < 20; x ++) {
			int i = (int)(Math.random()*ballArr.length);
			int j = (int)(Math.random()*ballArr.length);
			
			// 알맞은 코드를 넣어완성하시오.
			int tmp = 0;
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;			
		}
		
		for(int i = 0; i<ballArr.length; i++) {
			System.out.print(ballArr[i] + (i == ballArr.length-1 ? "" : "|"));
		}
		
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		
		//배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		System.arraycopy(ballArr, 0, ball3, 0, 3);
		
		for(int i = 0; i<ball3.length; i++) {
			System.out.print(ball3[i] + (i == ball3.length-1 ? "": "|"));
		}
	}
}
