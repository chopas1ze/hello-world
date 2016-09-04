package java0708_method;

/* 1 윤년의 조건
* 1) 년도를 4로 나눈나머지가 0이고 100로 나눈 나머지가 0이 아니다.
* 2) 년도를 400로 나눈 나머지가 0이다.
* 2001부터 2012년사이에서 윤년을 구하시오
**/
public class Java057_method {
	/*
	 * year변수에 값이 윤년이면 true 평년이면 false을 반환하는 프로그램을 구현하시오.
	 */

	public static void main(String[] args) {
		int year = 2012;
		if (isLeapYear(year)) {  //true
			System.out.printf("%d년은 윤년입니다", year);
		} else {
			System.out.printf("%d년은 평년입니다", year);
		}

	}// end main()

	public static boolean isLeapYear(int year) {
		// 여기를 구현하시오.
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}

	}// end isLeapYear
}// end class
