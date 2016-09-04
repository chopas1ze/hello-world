package java0718_api.prob;

/*
 * 1 매개변수로 받은 문자열에서 각 단어의 첫 번째만
     리턴하는 makeInitial 메서드를 구현하시오. 
 * 2 출력결과
 *   JDBC
 *   JSP
 *   EJB
 */
public class Prob003_String {

	public static void main(String[] args) {
		System.out.println(makeInitial("java Data Base Conectivity"));
		System.out.println(makeInitial("java server Pages"));
		System.out.println(makeInitial("Enterprise Java Beans"));
	}// end main()

	private static String makeInitial(String fullName) {
		// fullName의 매개변수에서 각 단어의 첫글자만 대문자로 변경후
		// 반환하는 프로그램을 구현하시오.
		String abc = "";
		String[] aa = fullName.split(" ");
		for (int i = 0; i < aa.length; i++) {
			if (aa[i].charAt(0) >= 'a' && aa[i].charAt(0) <= 'z') {
				aa[i]=aa[i].toUpperCase();
			}
			
			abc=abc+aa[i].charAt(0);
		}

		return abc;
		
		
	
		
	}// end makeInitial()

}// end class
