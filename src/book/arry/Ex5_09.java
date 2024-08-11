package book.arry;

public class Ex5_09 {
	public static void main(String[] args) {
		char[][] star = { 
			{ '*', '*', ' ', ' ', ' ' }, 
			{ '*', '*', ' ', ' ', ' ' }, 
			{ '*', '*', '*', '*', '*' },
			{ '*', '*', '*', '*', '*' } 
		};
		char[][] result = new char[star[0].length][star.length];
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				/* 알맞은 코드를 넣어 완성하시오 (1) . */
				// result[j][star.length - 1 - i] = star[i][j];
				int x = j;
				int y = star.length - 1 - i;
				result[x][y] = star[i][j];
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		//https://coderbear.tistory.com/44
	}
}
