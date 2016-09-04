package java0715_abstract_interface.prob;

/*
 * [문제]
 * 출력결과를 참조하여 Staff클래스의 메소드을 구현하세요. 
 * 입력된 주민번호를 이용해서 년,월,일,성별을 구하는 로직을 구현하시오
 * 
 *  [출력결과]
 *  홍길동 1982년 10월 12일 남 태생
 *  이영희 2010년 9월 29일 여 태생
 *  주민번호 13자리를 입력하세요

 */
public class Prob002_abstract {
	

	public static void main(String[] args) {
		Staff sf = new Staff("홍길동", "8210121544892");
		process(sf);

		Staff st = new Staff("이영희", "1009294152591");
		process(st);

		Staff sn = new Staff("소몰이", "96042523511");
		process(sn);

	}// end main()

	static void process(Staff data) {
		/*
		 * 주민번호가 13자리이면 "홍길동 1982년 10월 12일 남 태생" 주민번호가 13자리가 아니면
		 * "주민번호 13자리를 입력하세요" 처럼 출력이 되도록 로직 구현
		 */
		if (data.genCount() == 13) {
			System.out.println(data.getName() + " " + data.getYear() + "년 " + data.getMonth() + "월 " + data.getDATE()
					+ "일 " + data.gender() + " 태생");
		} else {
			System.out.println("주민번호 13자리를 입력하세요");
		}

	}// end process()

}// end class
