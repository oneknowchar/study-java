package book.chapter_06_constructor;

public class Ex_extends {
	public static void main(String[] args) {
		Parent p = new Child();
		Child child = new Child();
		
		System.out.println(p.x);		//100
		System.out.println(child.x);	//200
		
		p.method();						//Child........
		child.method();					//Child........
	}
}

class Parent {
	int x = 100;
	
	void method() {
		System.out.println("parent........");
	}
}

class Child extends Parent{
	int x = 200;
	
	void method() {
		System.out.println("Child........");
	}
}