package book.constructor;

public class Ex6_22 {
	public static void main(String[] args) {
		String str = "1234";

		System.out.println(str + "는 숫자 입니까? " + isNumber(str));

		str = "1234ooooo";
		System.out.println(str + "는 숫자 입니까? " + isNumber(str));
	}

	public static boolean isNumber(String str) {
		if (str == null || "".equals(str))
			return false;

		for (int i = 0; i < str.length(); i++) {
			if (!('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}
}
