package book.chapter_06_constructor;

public class Ex_final {
	public static void main(String[] args) {
		Card c = new Card();
		

		//c.KIND = "dfas";	//에러 발생! final 선언 후 수정 불가
		System.out.println(c);

	}
}

class Card{
	final int NUMBER;
	final String KIND;
	
	static int width = 100;
	static int height = 250;
	
	Card(){
		this("HEART", 1);
	}
	
	Card(String kind, int num){
		KIND = kind;
		NUMBER = num;
	}
	
	@Override
	public String toString() {
		return "Card [NUMBER=" + NUMBER + ", KIND=" + KIND + "]";
	}

}
