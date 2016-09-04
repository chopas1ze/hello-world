package java0720_api;

import java.util.Calendar;

/*
 * 2016년 2월 마지막과 요일을 구하는 프로그램을 구현하세요.
 * [출력결과]
 * 2016-2-29 월요일
 */
public class Java145_calendar {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		cal.set(2016, 1, 1);
		int date = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE, date); // 29일에 대한 요일을 구하기
		String day = "";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			day = "일요일";
			break;
		case 2:
			day = "월요일";
			break;
		case 3:
			day = "화요일";
			break;
		case 4:
			day = "수요일";
			break;
		case 5:
			day = "목요일";
			break;
		case 6:
			day = "금요일";
			break;
		case 7:
			day = "토요일";
		}

		System.out.printf("%d-%d-%d %s ", 2016, 2, date, day);

	}// end main()

}// end class
