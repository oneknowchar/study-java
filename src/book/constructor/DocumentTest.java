package book.constructor;

public class DocumentTest{
	public static void main(String[] args) {
		Document d1 = new Document();
		Document d2 = new Document("자바의 정석");
		Document d3 = new Document();
		Document d4 = new Document();
		Document d5 = new Document();
		Document d6 = new Document("이것이 자바다");
		Document d7 = new Document();
	}
}

 class Document {
	static int count = 0;
	
	String name;
	
	public Document() {
		this("제목 없음" + ++count);
	}
	
	public Document(String name) {
		this.name = name;
		
		System.out.println("문서 " + this.name + "가 생성되었습니다.");
	}
	
}

