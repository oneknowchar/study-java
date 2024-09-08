package book.chapter_08_exception;

public class NestedTryCatch {
	public static void main(String[] args) {
		try {
			System.out.println("외부 try 블록 시작");
			try {
				System.out.println("내부 try 블록 시작");
				// 의도적으로 예외 발생
				throw new Exception("내부 예외 발생");
			} catch (Exception e) {
				System.out.println("내부 catch 블록에서 처리: " + e.getMessage());
				// 예외를 외부 catch 블록으로 재던지기 (선택 사항)
				// 이 줄을 주석 처리하면 외부 catch 블록은 처리하지 않음
				throw e; 
			} finally {
				System.out.println("내부 finally 블록 실행");
			}
		} catch (Exception e) {
			System.out.println("외부 catch 블록에서 처리: " + e.getMessage());
		} finally {
			System.out.println("외부 finally 블록 실행");
		}
		
		//End
		System.out.println("Hello world!");
	}
}
