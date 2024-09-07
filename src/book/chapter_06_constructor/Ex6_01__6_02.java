package book.chapter_06_constructor;

public class Ex6_01__6_02 {
	public static void main(String[] args) {
		SutdaCard s1 = new SutdaCard(3, false);
		SutdaCard s2 = new SutdaCard();
		
		System.out.println(s1.info());
		System.out.println(s2.info());
	}
}

class SutdaCard{
	public int num;
	public boolean isKwang;
	
	public SutdaCard() {
		this(1, true);
	}
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String info() {
		return num + (isKwang ? "K" : "");
	}
}
