package book.chapter_07_OOP;

public class Ex_07_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		System.out.println();
		
		deck.shuffle();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		System.out.println();
		System.out.println(deck.pick(1));	//pick index
		System.out.println(deck.pick());	//pick random
	}
}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		// 배열 sutdacard를 적절히 초기화 하시오.
		for (int i = 0; i < CARD_NUM; i++) {
			int number = i + 1;
			
			//섯다 카드를 잘 모르지만, 10이 넘어가면 다시 1 ~ 10으로 보여줘야 함
			if(number >= 11) number -= 10;
			
			//setIsKwang
			if(i == 0 || i == 2 || i == 7) {
				cards[i] = new SutdaCard(number, true);
			}else {
				cards[i] = new SutdaCard(number, false);
			}
		}
	}
	
	//배열 cards에 담긴 카드의 위치를 뒤섞는다.
	void shuffle() {
		for(int i = 0; i < 1000; i++) {
			int random = (int)(Math.random()*CARD_NUM);
			SutdaCard temp = null;
			
			temp = cards[0];
			cards[0] = cards[random];
			cards[random] = temp;
		}
	}
	
	//배열 cards에서 지정된 위치의 SutdaCadd를 반환한다.
	SutdaCard pick(int index) {
		return cards[index];
	}
	
	//배열 cards에서 임의의 위치의 SutdaCard를 반환한다.
	SutdaCard pick() {
		int random = (int)(Math.random() * CARD_NUM);
		return cards[random];
	}
}

class SutdaCard{
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}
