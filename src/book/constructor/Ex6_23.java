package book.constructor;

import java.util.Arrays;

public class Ex6_23 {
	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		
		System.out.println(Arrays.toString(data));
		
		System.out.println("최대값 : "  + max(data));
		System.out.println("최대값 : "  + max(null));
		System.out.println("최대값 : "  + max(new int[] {}));
	}


	public static int max(int[] data) {
		if(data == null || data.length == 0 ) {
			return -9999999;
		}
		int max = data[0];
		for(int thisData : data) {
			if(thisData > max) {
				max = thisData;
			}
		}
		return max;
	}
}
