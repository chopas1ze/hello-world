package java0720_api;

import java.util.Calendar;

abstract class Test {
	public static Test getInstance() {
		return null;
	};
}

class TestExam extends Test {

	public static Test getInstance() {
		Test tt = new TestExam();
		return tt;
	}
}

public class Java144_Calendar {

	public static void main(String[] args) {
		// Calendar 클래스는 추상클래스라 객체 생성이 불가능하다.
		// Calendar cal = new Calendar();

		Test tt = Test.getInstance();
		/*
		 * Calendar은 추상클래스이므로 객체생성을 할 수 없다.
		 */

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		// Month은 1월 일때 0으로 리턴한다.
		int month = cal.get(Calendar.MONTH) + 1; // 현재 6월인데 1월을 0으로 리턴하기 때문에
													// +1해준다.
		System.out.println(month); // 7
		int date = cal.get(Calendar.DATE);
		// int hour = cal.get(Calendar.HOUR); //12시간
		int hour = cal.get(Calendar.HOUR_OF_DAY); // 24시간
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		// 2016-7-20 11:27:13
		System.out.printf("%d-%d-%d %d:%d:%d\n", year, month, date, hour, minute, second);

		// 이번달의 마지막일 리턴 //31
		System.out.println(cal.getActualMaximum(Calendar.DATE));
		
		//오늘의 요일 리턴(일요일 -> 1)   수요일은 4 출력
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		//오늘을 기준으로 5일전의 날짜를 리턴
		cal.add(Calendar.DATE, -5);
		
		System.out.println(cal.toString());
		
		//날짜를 15일로 바꿈.
		cal.set(Calendar.DATE, 15);
		System.out.println(cal.get(Calendar.DATE));

		cal.set(2015,4,20); // 2015-5-20  월을 넣어줄떄는 -1  월을 가지고 올떄는 +1
		System.out.println(cal.toString());
		
		
	}// end main()

}// end class
