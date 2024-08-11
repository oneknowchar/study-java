package book.arry;

public class Ex5_08 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];
		for (int i = 0; i < answer.length; i++) {
			/* (1) 알맞은 코드를 넣어 완성하시오. */
				counter[answer[i]-1] ++;
		}
		for (int i = 0; i < counter.length; i++) {
			/* 알맞은 코드를 넣어 완성하시오 (2) . */
			String star = "";
			
			for(int j=0; j<counter[i]; j++) {
				star+="*";
			}
			System.out.println(counter[i] + star);
		}
	}
}
