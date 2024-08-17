package book.constructor;

public class Ex6_09 {
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Marine m2 = new Marine();
		
		System.out.println("m1 = " + m1);
		System.out.println("m2 = " + m2);
		
		System.out.println();
		System.out.println("wepon up!!! ");
		System.out.println();
		
		Marine.weponUp();
		
		System.out.println("m1 = " + m1);
		System.out.println("m2 = " + m2);
	}
}

class Marine {
	//static 모든 병사의 공격력과 방어력은 같아야 한다
	static int weapon = 6;
	static int armor = 0;
	int x = 0, y = 0;
	int hp = 60;

	//클래스 변수를 사용하는 함수는 클래스 함수가 된다.
	static void weponUp() {
		weapon++;
	}

	//클래스 변수를 사용하는 함수는 클래스 함수가 된다.
	static void armorUp() {
		armor++;
	}

	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Marine [x=" + x + ", y=" + y + ", hp=" + hp + ", weapon=" + Marine.weapon + "]";
	}
	
}
