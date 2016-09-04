package java0720_api.prob;

/*
 * [출력결과]
 *  영어 소문자 갯수:3
 *  영어 대문자 갯수:3
 *  숫자 갯수:2
 */

public class Prob006_String {

	public static void main(String[] args) {
		String data = "ke4RdTA5";

		display(process(data));
	}// end main()

	public static char[] process(String data) {
		char[] add = data.toCharArray();

		return add;
	}// end process()

	public static void display(char[] arr) {
		int eng = 0;
		int eng2 = 0;
		int su = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'a' && arr[i] <= 'z') {
				eng++;
			} else if (arr[i] >= 'A' && arr[i] <= 'Z') {
				eng2++;
			} else {
				su++;
			}
		}
		System.out.println("영어 소문자 갯수 :" + eng);
		System.out.println("영어 대문자 갯수 :" + eng2);
		System.out.println("숫자 갯수 :" + su);

	}// end display()

}// end class
