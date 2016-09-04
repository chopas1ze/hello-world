package java0718_api;

/*
 * [출력결과]
 * aerok
 */
public class Java118_String {

	public static void main(String[] args) {
		String sn = "korea";
		char[] data = display(sn);
		System.out.println(data); // char배열은 문자열로 출력

	}// end main()

	public static char[] display(String alpa) {
		// alpa매개변수에 저장된 문자열을 reverse한후 반환하는
		// 프로그램을 구현하세요.
		char[] data = new char[alpa.length()];

		for (int i = 0; i < data.length; i++) {

			data[i] = alpa.charAt(alpa.length() - 1 - i);
		}
		return data;

	}// end display()

}// end class
