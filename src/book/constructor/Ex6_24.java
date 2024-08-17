package book.constructor;

public class Ex6_24 {
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value + "의 절대값 : " + abs(value));
	}
	
	public static int abs(int number) {
		return number < 0 ? -number : number;
	}
}
