package book.chapter_06_constructor;

import java.util.Arrays;

public class Ex_This {
	public static void main(String[] args) {
		Human jiseong = new Human("jiseong", 31);
		
		System.out.println(jiseong.toString());
		
		Human jjiseong = new Human();
		System.out.println(jjiseong);
		
		System.out.println("-----------------------------------------------------------");
		
		//arr은 jiseong에도 있고, jjiseong에도 있다. static이니 Human 객체로 직접 접근한다.
		for(int i=0; i< Human.arr.length; i++) {
			System.out.print(Human.arr[i] + ( i != Human.arr.length -1 ? ", " : ""));
		}
	}
}


class Human{
	
	//static 이지만, 선언 순서도 중요
	static int[] arr = new int[10];
	
	static {
		for(int i=0; i< arr.length; i++) {
			arr[i]= (int)(Math.random()*10)+1;
		}
	}
	
	private String name;
	private int age;
	private String[]hobbies = new String[] {"game"};
	
	//인스턴스 블럭
	{
		//클래스의 모든 생성자에서 공통적으로 수행되어져야 하는 블럭
		//모든 생성자 내부에 같은 코드 중복 작성 대신 인스턴스 블럭으로 일괄 공통 적용!!!
		//재사용성을 높이고, 코드의 중복을 제거, 신뢰성 향상, 오류 발생가능성 최소화
		System.out.println("인스턴스 블록 생성!");
	}
	
	static { 
		System.out.println("클래스 초기화 블럭!");
	}
	
	public Human() {
		this("user00", 22, new String[] {"soccer"});
	}
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Human(String name, int age, String[] hobbies) {
		this(name, age);	//this(); 생성자 호출시 제일 먼저 호출해야 한다.
		this.hobbies = hobbies;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", hobbies=" + Arrays.toString(hobbies) + "]";
	}
	
}
