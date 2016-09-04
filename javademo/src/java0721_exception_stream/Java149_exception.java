package java0721_exception_stream;

public class Java149_exception {

	public static void main(String[] args) {
		String data1 = "12";
		String data2 = "0";

		try {
			int x = Integer.parseInt(data1);
			int y = Integer.parseInt(data2);
			int res = x / y;
		} catch (NumberFormatException ex) {
			System.out.println("숫자를 입력하세요.");
		} catch (ArithmeticException ex) {
			System.out.println("분모는 0보다 큰 수를 입력하세요.");
		} catch (RuntimeException ex) { // 예상 외의 상황을 처리할 때 사용 하는 매개변수
			System.out.println(ex.toString());
		}
		/*
		 * 상속관계에 있는 익셉션들은 제일 상위의 것을 제일 아래에 둬야 한다.
		 * 이유는 제일 상위에 있으면 먼저 처리하고 나서 밑에서도 처리 해서 중복처리 되기 때문.
		 */

	}// end main()

}// end class
