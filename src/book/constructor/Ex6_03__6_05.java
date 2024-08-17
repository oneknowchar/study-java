package book.constructor;

public class Ex6_03__6_05 {
	public static void main(String[] args) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;

		System.out.println("이름 : " + s.name);
		System.out.println("total : " + s.getTotal());
		System.out.println("avg : " + s.getAverage());

		System.out.println("-------------------------------------------------------------");

		Student ss = new Student("홍길동", 1, 1, 100, 60, 76);

		System.out.println(ss.info());
	}
}

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public Student() {
	};

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String info() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", "+  getTotal() + ", " + getAverage();
	}

	public int getTotal() {
		return kor + eng + math;
	}

	public float getAverage() {
		return (int) (getTotal() / 3f * 10 + 0.5) / 10f;
		// return Math.round(getTotal()/3f *10)/ 10f;
		// return (float)Math.round((float)getTotal()/3 *10)/ 10;
	}
}
