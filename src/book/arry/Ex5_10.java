package book.arry;

public class Ex5_10 {
	public static void main(String[] args) {
		char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'
			};
							// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String src = "abc123";
		String result = "";
		
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		for(int i=0; i < src.length();i++) {
			char ch = src.charAt(i);
			if( 'a'<= ch && ch <= 'z') {
				result+= abcCode[ch-'a'];	//알파벳 0번째 인덱스를 구하려면 a를 뺀다.
			}else {	
				result+= numCode[ch-'0'];	//숫자 0번째 인덱스를 구하려면 0을 뺀다.
			}
			
		}
		System.out.println("src:"+src);
		System.out.println("result:"+result);
	}
}
