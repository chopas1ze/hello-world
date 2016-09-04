package java0720_api.prob;
/*
 * javac Prob001_String.java
 * java Prob001_String JAvaTest  <- args 배열0번에 저장됨.  JAva Test 라고 치면 args 배열 0번과 1번에 저장됨.
 */

import java.util.Calendar;

/*1 프로그램 실행할때  "JAva Test" 문자열을 args배열에서 값을 받아 출력결과에 같이
 *  나오도록 프로그램을 구현하시오.
 *  java Prob001_String JAva Test
 *   * 
 * 2 출력결과
 *   source : JAva Test 
 *   convert: jaVA tEST
 *   length: 9
 *   reverse : tseT avAJ
 */

public class Prob001_String {

	public static void main(String[] args) {
		String abc = args[0] + " " + args[1];
		String tt = "";
		StringBuffer sb = new StringBuffer(abc);
		sb.reverse();

		for (int i = 0; i < abc.length(); i++) {
			if (abc.charAt(i) >= 'a' && abc.charAt(i) <= 'z') {
				tt += (char) (abc.charAt(i) - 32);
			} else if (abc.charAt(i) >= 'A' && abc.charAt(i) <= 'Z') {
				tt += (char) (abc.charAt(i) + 32);
			} else {
				tt += " ";
			}
		}

		System.out.println("source : " + abc);
		System.out.println("convert : " + tt);
		System.out.println("length : " + abc.length());
		System.out.println("reverse : " + sb);
	
		
		
	
	}

}// end class
